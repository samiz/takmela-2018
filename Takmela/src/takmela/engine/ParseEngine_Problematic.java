package takmela.engine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import takmela.ast.Call;
import takmela.ast.Expr;
import takmela.ast.Rule;
import takmela.ast.Terminal;
import takmela.ast.Tokenz;
import takmela.lexer.lexer.Token;
import takmela.lexer.lexer.TokenVocab;
import takmela.tree.Leaf;
import takmela.tree.Tree;
import utils.LLst;
import utils.OptionNotHandledException;
import utils.Pair;
import utils.Triple;
import utils.Utils;

/* An older version of the ParseEngine which does not
 * use iteration/fixedpoint, and thus gets stuck at infinite loops
 * sometimes.
 * 
 * Used as a documentation for the need for fixedpoint and the cases where the older flawed
 * algorithm doesn't work.
 */
public class ParseEngine_Problematic
{
	public static final boolean Logging = true;

	public final List<Rule> rules;
	private final TokenVocab tokenVocab;

	private final Map<String, Rule> namedRules = new HashMap<>();
	private final Map<Pair<String, Integer>, Set<Cont>> continuations = new HashMap<>();
	private final Map<Pair<String, Integer>, Set<Integer>> successfulCalls = new HashMap<>();
	private Map<Triple<String, Integer, Integer>, List<Tree>> successfulCallTrees = new HashMap<>();

	// Set of <continuation ID, resumed at success point> pairs
	private final Set<Pair<Integer, Integer>> awakenings = new HashSet<>();
	private List<Token> input;
	private int contId;

	private Consumer<Tree> onSuccessfulParse;

	public ParseEngine_Problematic(List<Rule> rules, TokenVocab tokenVocab)
	{
		this.rules = rules;
		this.tokenVocab = tokenVocab;
		contId = 0;
		for (Rule r : rules)
		{
			namedRules.put(r.Name, r);
		}
	}

	public void parse(String startSymbol, List<Token> input, Consumer<Tree> onSuccessfulParse)
	{
		this.onSuccessfulParse = onSuccessfulParse;
		this.input = input;
		callTopLevel(startSymbol, 0);
	}

	private void process(String execRuleName, int inputPos, Cont cc)
	{
		Rule r = namedRules.get(execRuleName);
		for (int i = 0; i < r.Options.size(); ++i)
		{
			process(execRuleName, inputPos, i, r.Options.get(i), inputPos, new Tree(execRuleName, i), cc);
		}
	}

	private void process(String execRuleName, int inputPosAtCallOfExecRule, int optNum, LLst<Expr> seq, int inputPos,
			Tree treeSoFar, Cont cc)
	{
		if (execRuleName.equals("root"))
		{
			if (eof(inputPos))
			{
				log("successful parse of " + Utils.slice(input, 0, inputPos) + ", tree= " + treeSoFar);
				onSuccessfulParse.accept(treeSoFar);
			}
			return;
		}
		log(indent(cc), "Process: ", execRuleName, "(" + inputPosAtCallOfExecRule + ") | ", seq);
		boolean stop = false;
		while (seq != null)
		{
			Expr e = seq.head;
			seq = seq.tail;
			if (e instanceof Terminal)
			{
				Terminal t = (Terminal) e;
				if (!match(t.Value, inputPos))
				{
					stop = true;
					break;
				}
				else
				{
					treeSoFar = treeSoFar.appendChild(new Leaf(inputHere(inputPos)));
					inputPos++;
				}
			}
			else if (e instanceof Tokenz)
			{
				Tokenz t = (Tokenz) e;
				int id = tokenVocab.tokenId(t.Value);
				if (!match(id, t.Value, inputPos))
				{
					stop = true;
					break;
				}
				else
				{
					treeSoFar = treeSoFar.appendChild(new Leaf(inputHere(inputPos)));
					inputPos++;
				}
			}
			else if (e instanceof Call)
			{
				Call c = (Call) e;
				call(c.Callee, execRuleName, inputPosAtCallOfExecRule, inputPos, seq, optNum, treeSoFar, cc);
				stop = true;
				break;
			}
			else
			{
				throw new OptionNotHandledException(e);
			}
		} // while
		if (!stop)
		{
			// reached end of the rule with success
			doReturn(treeSoFar, execRuleName, inputPosAtCallOfExecRule, inputPos);
		}
	}

	private void call(String callee, String caller, int inputPosAtCallOfExecRule, int inputPos, LLst<Expr> seq,
			int optNum, Tree treeSoFar, Cont callerCont)
	{
		Cont cont = mkCont(callee, inputPosAtCallOfExecRule, caller, optNum, seq, callerCont, treeSoFar);
		log("Call (", callee, " | ", inputPos, ") k = ", beautify(cont));
		Pair<String, Integer> key = new Pair<>(callee, inputPos);
		boolean firstCall = !continuations.containsKey(key);
		Utils.addMapSet(this.continuations, key, cont);

		if (firstCall)
		{
			process(callee, inputPos, callerCont);
		}
		else
		{
			update(callee, inputPos, cont);
		}
	}

	private void doReturn(Tree treeSoFar, String execRuleName, int inputPosAtCall, int inputPosNow)
	{
		log("Return from ", execRuleName, "(", inputPosAtCall, "), moved input to ", inputPosNow);
		log(".....tree so far = ", treeSoFar);

		Pair<String, Integer> key = new Pair<>(execRuleName, inputPosAtCall);
		Triple<String, Integer, Integer> key2 = new Triple<>(execRuleName, inputPosAtCall, inputPosNow);
		Utils.addMapSet(successfulCalls, key, inputPosNow);
		Utils.addMapList(successfulCallTrees, key2, treeSoFar);
		update(execRuleName, inputPosAtCall, inputPosNow);
	}

	private void update(String callee, int inputPos, Cont cont)
	{
		Set<Integer> sc = successfulCalls.getOrDefault(new Pair<>(callee, inputPos), Utils.set());
		log("sc-list of (", callee, ", ", inputPos, ") = ", Utils.join(sc, ", "));
		for (int s : sc)
		{
			Pair<Integer, Integer> sk = new Pair<>(cont.Id, s);
			//if (!awakenings.contains(sk))
			{
				awakenings.add(sk);

				List<Tree> ts = Utils.mustGet(successfulCallTrees, new Triple<>(cont.CalledRuleName, inputPos, s));

				log("awakenings-scs-of-call: (", cont.CalledRuleName + "|" + cont.CallInputPos, ") " + cont.Code,
						" starting from ", s);

				for (Tree t : ts)
				{
					this.process(cont.CallerRuleName, cont.CallInputPos, cont.OptionIndex, cont.Code, s,
							cont.TreeSoFar.appendChild(t), cont);
				}
			}
		}
	}

	private void update(String succeeded, int inputPosAtCall, int inputPosAfterSuccess)
	{
		Set<Cont> contList = continuations.getOrDefault(new Pair<>(succeeded, inputPosAtCall), Utils.set());

		List<Tree> ts = Utils.mustGet(successfulCallTrees,
				new Triple<>(succeeded, inputPosAtCall, inputPosAfterSuccess));

		logf("success of (%s, %s)-->%s    | ts=%s", succeeded, inputPosAtCall, inputPosAfterSuccess, ts);
		log("k-list of (", succeeded, ", ", inputPosAtCall, ") = ",
				Utils.joinMap(contList, ", ", c -> "{" + beautify(c) + "}"));

		for (Cont cont : contList)
		{
			Pair<Integer, Integer> sk = new Pair<>(cont.Id, inputPosAfterSuccess);
			//if (!awakenings.contains(sk))
			{
				awakenings.add(sk);
				try
				{
					log("awakening-ks-of-sc: (", cont.CallerRuleName + "|" + cont.CallInputPos, ") " + cont.Code,
							" starting from ", inputPosAfterSuccess);
				}
				catch (NullPointerException ex)
				{
					log("b");
				}
				for (Tree t : ts)
				{
					this.process(cont.CallerRuleName, cont.CallInputPos, cont.OptionIndex, cont.Code,
							inputPosAfterSuccess, cont.TreeSoFar.appendChild(t), cont);
				}
			}
			//else
			{
				//log("...prev awakenings already contain ", cont.CallerRuleName, " ", sk); 
			}
		}
	}

	private void callTopLevel(String startSymbol, int inputPos)
	{
		log("Call ", startSymbol, " |  ", inputPos, " (top level)");
		Rule r = namedRules.get(startSymbol);
		Cont rootC = mkRootCont();
		Utils.addMapSet(this.continuations, new Pair<>(startSymbol, inputPos), rootC);
		for (int i = 0; i < r.Options.size(); ++i)
		{
			process(r.Name, 0, i, r.Options.get(i), inputPos, new Tree(startSymbol, 0), rootC);
		}
	}

	private String indent(Cont cc)
	{
		StringBuilder sb = new StringBuilder();
		/*
		cc = cc.Parent;
		while (cc != null)
		{
			sb.append("  ");
			cc = cc.Parent;
		}
		*/
		return sb.toString();
	}

	private Cont mkCont(String callee, int inputPos, String caller, int callerOptNum, LLst<Expr> seq, Cont parentCont,
			Tree treeSoFar)
	{
		return new Cont(mkId(), callee, caller, inputPos, callerOptNum, seq, parentCont, treeSoFar);
	}

	private Cont mkRootCont()
	{
		return new Cont(mkId(), "root", "root", 0, 0, null, null, new Tree("root", 0));
	}

	private int mkId()
	{
		int t = this.contId++;
		return t;
	}

	private Token inputHere(int inputPos)
	{
		return input.get(inputPos);
	}

	private boolean match(String value, int inputPos)
	{
		if (eof(inputPos))
		{
			log("eof");
			return false;
		}
		String inp = input.get(inputPos).text();
		boolean result = inp.equals(value);
		log("....match `", value, "`: ", result ? "success" : "fail");
		return result;
	}

	private boolean match(int tokenId, String lexeme, int inputPos)
	{
		if (eof(inputPos))
		{
			log("eof");
			return false;
		}
		int inp = input.get(inputPos).id();
		boolean result = inp == tokenId;
		log("....match `", lexeme, "`: ", result ? "success" : "fail");
		return result;
	}

	private boolean eof(int inputPos)
	{
		return inputPos >= input.size();
	}

	private void logf(String fmt, Object... items)
	{
		if (Logging)
		{
			System.out.println(String.format(fmt, items));
		}
	}

	private void log(Object... items)
	{
		if (Logging)
		{
			System.out.println(Utils.join(items, ""));
		}
	}

	private String beautify(Cont c)
	{
		String p = "";
		/*
		if(c.Parent != null)
		{
			p = " --> " + beautify(c.Parent);
		}
		*/
		return String.format("[%s|%s]%s", c.CallerRuleName, c.CallInputPos, beautify(c.Code), p);
	}

	private String beautify(LLst<Expr> code)
	{
		if (code == null)
		{
			return "()";
		}
		StringBuilder sb = new StringBuilder();
		String sep = "";

		for (Expr e : code)
		{
			sb.append(sep);
			sb.append(beautify(e));
			sep = " ";
		}
		return sb.toString();
	}

	private String beautify(Expr e)
	{
		if (e instanceof Call)
		{
			Call c = (Call) e;
			return c.Callee;
		}
		else if (e instanceof Terminal)
		{
			Terminal t = (Terminal) e;
			return t.Value;
		}
		else if (e instanceof Tokenz)
		{
			Tokenz t = (Tokenz) e;
			return t.Value;
		}
		else
		{
			throw new OptionNotHandledException(e);
		}
	}
}
