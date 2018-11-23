package test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import analyzer.errors.Error;
import analyzer.errors.ArbitraryError;
import generatedparser.LexertoolsLexer;
import generatedparser.LexertoolsParser;
import parser.LexertoolsParserTreeListener;
import parser.LexertoolsParserTreeListenerHelper;
import takmela.lexer.ast.LexerRule;
import takmela.lexer.ast.Module;
import takmela.lexer.automata.CharRange;
import takmela.lexer.automata.Epsilon;
import takmela.lexer.automata.FA;
import takmela.lexer.automata.FAAlgo;
import takmela.lexer.automata.Trans;
import takmela.lexer.lexer.Lexer;
import takmela.lexer.lexer.LexerError;
import utils.OptionNotHandledException;
import utils.Pair;
import utils.Utils;

public class TestLexer
{
	public static void main(String[] args) throws IOException, LexerError
	{

		//ast.Module m = parseSingleFile("test/simple_nocommon.txt", new ArrayList<>());
		//ast.Module m = parseSingleFile("test/identifiers_ints.txt", new ArrayList<>());
		//ast.Module m = parseSingleFile("test/indentifier_commonArcs.txt", new ArrayList<>());
		//testFA(m);

		takmela.lexer.ast.Module m = parseSingleFile("test/identifiers_ints.txt", new ArrayList<>());
		testLexing(m, "X12zd eg 146 x 1");

	}

	private static void testLexing(Module m, String string) throws LexerError, IOException
	{
		Lexer lexer = new Lexer(m, true);
		lexer.init(string);
		while (lexer.hasMoreTokens())
		{
			Utils.printf("Accepted ------------------->                   `%s`", lexer.nextToken());
		}
	}

	private static void testFA(takmela.lexer.ast.Module m) throws IOException
	{
		Map<String, FA> ruleNfas = new HashMap<>();
		FAAlgo algo = new FAAlgo();

		for (LexerRule r : m.Rules)
		{
			ruleNfas.put(r.Name, algo.nfaFromRegEx(r.Expr));
		}

		for (Entry<String, FA> kv : ruleNfas.entrySet())
		{
			String dot = toDot(kv.getValue());
			Utils.writeToFile("dots/" + kv.getKey() + ".dot", dot);
		}

		Map<String, FA> ruleDfas = new HashMap<>();

		for (Entry<String, FA> kv : ruleNfas.entrySet())
		{
			String name = kv.getKey();
			FA dfa = algo.dfaFromNfa(kv.getValue());
			ruleDfas.put(name, dfa);
			String dot = toDot(dfa);
			Utils.writeToFile("dots/" + name + "_dfa.dot", dot);
		}

		Map<String, FA> ruleNoCommon = new HashMap<>();

		for (Entry<String, FA> kv : ruleDfas.entrySet())
		{
			FA noCommonTrans = algo.nfaWithNoCommonTransitions(kv.getValue());
			String dot = toDot(noCommonTrans);
			ruleNoCommon.put(kv.getKey(), noCommonTrans);
			Utils.writeToFile("dots/" + kv.getKey() + "_noCommon.dot", dot);
		}

		for (Entry<String, FA> kv : ruleNoCommon.entrySet())
		{
			String name = kv.getKey();
			FA dfa = algo.dfaFromNfa(kv.getValue());
			ruleDfas.put(name, dfa);
			String dot = toDot(dfa);
			Utils.writeToFile("dots/" + name + "_dfa2.dot", dot);
		}
	}

	public static String toDot(FA fa)
	{
		Set<Integer> allStates = Utils.transitiveClosure(fa.startState,
				(s) -> Utils.map(fa.tg.getOrDefault(s, new ArrayList<>()), (p) -> p.b));

		StringBuilder sb = new StringBuilder();
		p(sb, "digraph NFA {");
		p(sb, "rankdir=LR;");

		for (int s : allStates)
		{
			if (fa.acceptingStates.contains(s))
			{
				p(sb, String.format("s%s[fontsize=11, label=\"%s\", shape=doublecircle, fixedsize=true, width=.6];", s,
						s));
			}
			else
			{
				p(sb, String.format(
						"s%s[fontsize=11, label=\"%s\", shape=circle, fixedsize=true, width=.55, peripheries=1];", s,
						s));
			}
		}

		for (Entry<Integer, List<Pair<Trans, Integer>>> kv : fa.tg.entrySet())
		{
			int from = kv.getKey();
			for (Pair<Trans, Integer> p : kv.getValue())
			{
				Trans t = p.a;
				int to = p.b;
				String label = null;
				if (t instanceof Epsilon)
				{
					label = "&epsilon;";
				}
				else if (t instanceof CharRange)
				{
					CharRange r = (CharRange) t;
					label = String.format("{%s..%s}", r.From, r.To);
				}
				else
				{
					throw new OptionNotHandledException(t);
				}
				p(sb, String.format(
						"s%s -> s%s [fontsize=11, fontname=\"Courier\", arrowsize=.7, label = \"%s\", arrowhead = normal];",
						from, to, label));
			}
		}

		p(sb, "}");
		return sb.toString();
	}

	private static void p(StringBuilder sb, String str)
	{
		sb.append(str + "\n");
	}

	public static takmela.lexer.ast.Module parseSingleFile(String fn, List<Error> outParseErrors) throws IOException
	{
		String code = String.copyValueOf(org.antlr.v4.runtime.misc.Utils.readFile(fn));
		ANTLRInputStream in = new ANTLRInputStream(code);

		LexertoolsLexer lexer = new LexertoolsLexer(in);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		ANTLRErrorListener errListener = new LexerParserErrorListener((e) -> {
			outParseErrors.add(new ArbitraryError(e));
		});
		lexer.addErrorListener(errListener);

		LexertoolsParser parser = new LexertoolsParser(tokenStream);
		parser.addErrorListener(errListener);
		ParseTree tree = parser.program();

		String path = new File(fn).getCanonicalPath();
		LexertoolsParserTreeListener listener = new LexertoolsParserTreeListener(
				new LexertoolsParserTreeListenerHelper(), path);

		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(listener, tree);

		takmela.lexer.ast.Module prog = new takmela.lexer.ast.Module(listener.rules);
		System.out.println(prog);
		return prog;
	}
}
