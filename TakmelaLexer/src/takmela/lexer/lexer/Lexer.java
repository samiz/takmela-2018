package takmela.lexer.lexer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import takmela.lexer.ast.LexerRule;
import takmela.lexer.automata.FA;
import takmela.lexer.automata.FAAlgo;
import takmela.lexer.automata.Trans;
import test.TestLexer;
import utils.Pair;
import utils.Utils;

public class Lexer implements TokenVocab
{
	private final boolean writeDotFiles; 
	private final Map<String, FA> ruleDfas;
	private Map<String, Integer> vocab = null;
	private final Set<String> skipRules;

	private String inputText;
	private int pos;

	private int line, col;

	public Lexer(takmela.lexer.ast.Module m, Map<String, Integer> tokenVocab, boolean writeDotFiles) throws IOException
	{
		this.writeDotFiles = writeDotFiles;
		ruleDfas = initAutomata(m.Rules);
		skipRules = initSkip(m.Rules);
		vocab = tokenVocab;
	}

	public Lexer(List<LexerRule> rules, Map<String, Integer> tokenVocab, boolean writeDotFiles) throws IOException
	{
		this.writeDotFiles = writeDotFiles;
		ruleDfas = initAutomata(rules);
		skipRules = initSkip(rules);
		vocab = tokenVocab;
	}

	public Lexer(takmela.lexer.ast.Module m, boolean writeDotFiles) throws IOException
	{
		this.writeDotFiles = writeDotFiles;
		ruleDfas = initAutomata(m.Rules);
		skipRules = initSkip(m.Rules);
		initDefaultVocab(m.Rules);
	}

	public Lexer(List<LexerRule> rules, boolean writeDotFiles) throws IOException
	{
		this.writeDotFiles = writeDotFiles;
		ruleDfas = initAutomata(rules);
		skipRules = initSkip(rules);
		vocab = initDefaultVocab(rules);
	}

	public static Map<String, Integer> initDefaultVocab(List<LexerRule> rules)
	{
		Map<String, Integer> vocab = new HashMap<>();
		int c = 0;
		for (LexerRule r : rules)
		{
			vocab.put(r.Name, c++);
		}
		return vocab;
	}

	private Set<String> initSkip(List<LexerRule> rules)
	{
		Set<String> ret = new HashSet<>();
		for (LexerRule r : rules)
		{
			if (r.Skip)
			{
				ret.add(r.Name);
			}
		}
		return ret;
	}

	private Map<String, FA> initAutomata(List<LexerRule> rules) throws IOException
	{
		Map<String, FA> ruleNfas = new HashMap<>();
		FAAlgo algo = new FAAlgo();
		
		if(writeDotFiles)
		{
			File f = new File("./dots");
			if(f.exists())
			{
				if(!f.isDirectory())
				{
					throw new RuntimeException("Cannot write .dot files to " + f.getAbsolutePath() + ", not a directory");
				}
			}
			else
			{
				f.mkdirs();
			}
		}
		for (LexerRule r : rules)
		{
			ruleNfas.put(r.Name, algo.nfaFromRegEx(r.Expr));
		}

		if(writeDotFiles)
		{
			for (Entry<String, FA> kv : ruleNfas.entrySet())
			{
				String dot = TestLexer.toDot(kv.getValue());
				Utils.writeToFile("./dots/" + kv.getKey() + ".dot", dot);
			}
		}
		//*/

		Map<String, FA> ruleDfas = new HashMap<>();

		for (Entry<String, FA> kv : ruleNfas.entrySet())
		{
			String name = kv.getKey();
			FA dfa = algo.dfaFromNfa(kv.getValue());
			ruleDfas.put(name, dfa);
			if(writeDotFiles)
			{
				String dot = TestLexer.toDot(dfa);
				Utils.writeToFile("./dots/" + name + "_dfa.dot", dot);
			}
		}

		Map<String, FA> ruleNoCommon = new HashMap<>();

		for (Entry<String, FA> kv : ruleDfas.entrySet())
		{
			FA noCommonTrans = algo.nfaWithNoCommonTransitions(kv.getValue());
			ruleNoCommon.put(kv.getKey(), noCommonTrans);

			if(writeDotFiles)
			{
				String dot = TestLexer.toDot(noCommonTrans);
				Utils.writeToFile("./dots/" + kv.getKey() + "_noCommon.dot", dot);
			}
		}

		for (Entry<String, FA> kv : ruleNoCommon.entrySet())
		{
			String name = kv.getKey();
			FA dfa = algo.dfaFromNfa(kv.getValue());
			ruleDfas.put(name, dfa);
			if(writeDotFiles)
			{
				String dot = TestLexer.toDot(dfa);
				Utils.writeToFile("./dots/" + name + "_dfa2.dot", dot);
			}
		}
		return ruleDfas;
	}

	public void init(String input)
	{
		this.inputText = input;
		this.pos = 0;
		this.line = this.col = 0;
	}

	public boolean hasMoreTokens()
	{
		return pos < inputText.length();
	}

	public Token nextToken() throws LexerError
	{
		String maxAcceptingRule = null;
		int maxAcceptingPos = 0, maxAcLine = -1, maxAcCol = -1;

		forRules: for (Entry<String, FA> kv : this.ruleDfas.entrySet())
		{
			String ruleName = kv.getKey();
			FA fa = kv.getValue();
			//log("Rule %s, pos=%s", ruleName, pos);
			int state = fa.startState;
			int p = pos;
			int __line = line;
			int __col = col;
			while (true)
			{
				if (p == inputText.length())
				{
					if (fa.acceptingStates.contains(state))
					{
						return accept(ruleName, p, __line, __col);
					}
				}

				char c = inputText.charAt(p);
				boolean found = false;
				for (Pair<Trans, Integer> t : fa.outTrans(state))
				{
					//Utils.printf("....Match %s?", t.a);
					if (t.a.match(c))
					{
						state = t.b;
						found = true;
						break;
					}
					//Utils.printf("....fails");
				}
				if (found)
				{
					p++;
					__col++;
					if (c == '\n')
					{
						__line++;
						__col = 0;
					}
				}
				else
				{
					if (fa.acceptingStates.contains(state))
					{
						if (p > maxAcceptingPos)
						{
							maxAcceptingPos = p;
							maxAcceptingRule = ruleName;
							maxAcLine = __line;
							maxAcCol = __col;
							continue forRules;
						}
						else
						{
							continue forRules;
						}
					}
					else
					{
						continue forRules;
					}
				}
			}
		}
		if (maxAcceptingPos > pos)
		{
			return accept(maxAcceptingRule, maxAcceptingPos, maxAcLine, maxAcCol);
		}
		else
		{
			throw new LexerError("Cannot process input near '" + formatLiteral(Utils.mid(inputText, pos, 5)) + "'");
		}
	}

	private String formatLiteral(String s)
	{
		return s.replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
	}

	private Token accept(String ruleName, int p, int line, int col)
	{
		String lexeme = this.inputText.substring(pos, p);
		Token t = new Token(tokenId(ruleName), lexeme, line, col, skipRules.contains(ruleName));
		pos = p;
		return t;
	}

	public int tokenId(String ruleName)
	{
		return vocab.get(ruleName);
	}

	private void log(String fmt, Object... args)
	{
		Utils.printf(fmt, args);
	}
}
