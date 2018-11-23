package takmela.tool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import test.LexerParserErrorListener;
import utils.CmdLineParseException;
import utils.CmdLineParser;
import utils.LLst;
import utils.OptionNotHandledException;
import utils.Utils;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.grack.nanojson.JsonArray;
import com.grack.nanojson.JsonObject;
import com.grack.nanojson.JsonWriter;

import generatedparser.ParsetoolsLexer;
import generatedparser.ParsetoolsParser;
import parser.ParsetoolsParserTreeListener;
import parser.ParsetoolsParserTreeListenerHelper;
import takmela.ast.ByName;
import takmela.ast.CharClass;
import takmela.ast.CharClassPart;
import takmela.ast.Expr;
import takmela.ast.Oring;
import takmela.ast.Plus;
import takmela.ast.Question;
import takmela.ast.RXSeq;
import takmela.ast.Rule;
import takmela.ast.Star;
import takmela.ast.Str;
import takmela.ast.Terminal;
import takmela.engine.ParseEngine;
import takmela.lexer.lexer.Lexer;
import takmela.lexer.lexer.LexerError;
import takmela.lexer.lexer.Token;
import takmela.tree.Leaf;
import takmela.tree.Node;
import takmela.tree.Tree;

public class Parse
{
	public static void main(String[] args) throws CmdLineParseException, IOException, LexerError
	{
		CmdLineParser cmdOpts = new CmdLineParser
				(Utils.set("--terse", "--dot"), 
						Utils.set(""), 
						Utils.set("-s", "-g"), args);

		String startSym = cmdOpts.SingletonKwArgs.getOrDefault("-s", "main");
		String grammarPath = cmdOpts.SingletonKwArgs.getOrDefault("-g", "");
		boolean terse = cmdOpts.Switches.contains("--terse");
		boolean writeDotFiles = cmdOpts.Switches.contains("--dot");

		if (grammarPath.trim().equals(""))
		{
			System.out.println("Must supply grammar file");
			System.exit(1);
		}

		if (cmdOpts.RestArgs.size() != 1)
		{
			System.out.println("Usage: tool.Parse -s <startsymbol> -g <grammarfile> inputfile");
			System.out.println("Optional args: ");
			System.out.println("    --terse       Display less detailed parse tree");
			System.out.println("    --dot         Generate various graphviz .dot files for tokens in ./dots");
			System.out.println("");
			System.out.println("The start symbol is assumed to be 'main' if not provided");
			System.exit(1);
		}

		String inPath = cmdOpts.RestArgs.get(0);
		String inputStr = Utils.readAllFile(inPath);

		List<String> outParseErrors = new ArrayList<>();
		takmela.ast.Module m = parseSingleFile(grammarPath, outParseErrors);
		if (outParseErrors.size() != 0)
		{
			System.out.println("Errors found in grammar:\n" + outParseErrors);
			System.exit(1);
		}
		
		JsonObject obj = new JsonObject();
		JsonArray trees = new JsonArray();
		obj.put("trees", trees);
		
		parse(m, inputStr, startSym, writeDotFiles, (t) -> {
			if(!terse)
			{
				trees.add(toJson(t));
			}
			else
			{
				trees.add(toJsonTerse(t));
			}
		});
		
		System.out.println(JsonWriter.indent("    ").string().object(obj).done());
	}

	private static JsonObject toJson(Tree t)
	{
		JsonObject ret = new JsonObject();
		ret.put("type", "tree");
		ret.put("label", t.Label);
		ret.put("choice", t.Choice);
		
		JsonArray children = new JsonArray();
		
		ret.put("children", children);
		
		for(Node n : t.Children)
		{
			if(n instanceof Leaf)
			{
				Leaf leaf = (Leaf) n;
				children.add(toJson(leaf.token));
			}
			else
			{
				Tree tree = (Tree) n;
				children.add(toJson(tree));
			}
		}
		return ret;
	}

	private static JsonObject toJson(Token t)
	{
		JsonObject ret = new JsonObject();
		ret.put("type", "token");
		ret.put("id", t.id());
		ret.put("lexeme", t.text());
		ret.put("col", t.col());
		ret.put("line", t.line());
		return ret;
	}
	
	private static JsonArray toJsonTerse(Tree t)
	{
		JsonArray ret = new JsonArray();
		ret.add(t.Label);
		
		//JsonArray children = new JsonArray();
		//ret.add(children);
		
		for(Node n : t.Children)
		{
			if(n instanceof Leaf)
			{
				Leaf leaf = (Leaf) n;
				ret.add(toJsonTerse(leaf.token));
			}
			else
			{
				Tree tree = (Tree) n;
				ret.add(toJsonTerse(tree));
			}
		}
		return ret;
	}

	private static Object toJsonTerse(Token t)
	{
		JsonObject tok = new JsonObject();
		tok.put("token", t.text());
		return tok;
	}
	
	public static void parse(takmela.ast.Module mod, String inputStr, String startSymbol, Consumer<Tree> onSuccessfulParse)
			throws IOException, LexerError
	{
		parse(mod, inputStr, startSymbol, false, onSuccessfulParse);
	}

	public static void parse(takmela.ast.Module mod, String inputStr, String startSymbol, 
			boolean writeDotFiles, Consumer<Tree> onSuccessfulParse)
			throws IOException, LexerError
	{
		Set<String> inlineToks = collectInlineTokens(mod.Rules);
		List<takmela.lexer.ast.LexerRule> inlineRules = new ArrayList<>();
		int i = 0;
		for (String tok : inlineToks)
		{
			inlineRules.add(r("_T__" + i++, tok));
		}
		Lexer lex = new Lexer(Utils.concat(inlineRules, Utils.map(mod.LexerRules, r->convert(r))), writeDotFiles);

		lex.init(inputStr);
		List<takmela.lexer.lexer.Token> input = new ArrayList<>();
		while (lex.hasMoreTokens())
		{
			Token t = lex.nextToken();
			if (!t.skip())
			{
				input.add(t);
			}
		}
		ParseEngine pe = new ParseEngine(mod.Rules, lex);
		//ParseEngine_Problematic pe = new ParseEngine_Problematic(mod.Rules, lex);
		pe.parse(startSymbol, input, onSuccessfulParse);
	}

	public static takmela.lexer.ast.LexerRule convert(takmela.ast.LexerRule r)
	{
		return new takmela.lexer.ast.LexerRule(r.Name, r.Within, r.Pushes, r.Pops, r.Class, r.Skip, convert(r.Expr));
	}

	private static takmela.lexer.ast.RExpr convert(takmela.ast.RExpr _e)
	{
		if(_e instanceof takmela.ast.ByName)
		{
			takmela.ast.ByName e = (ByName) _e;
			return new takmela.lexer.ast.ByName(e.Name);
		}
		else if(_e instanceof takmela.ast.CharClass)
		{
			takmela.ast.CharClass e = (CharClass) _e;
			return new takmela.lexer.ast.CharClass(Utils.map(e.Parts, p->convert(p)));
		}
		else if(_e instanceof takmela.ast.Oring)
		{
			takmela.ast.Oring e = (Oring) _e;
			return new takmela.lexer.ast.Oring(Utils.map(e.Exprs, a->convert(a)));
		}
		else if(_e instanceof takmela.ast.Plus)
		{
			takmela.ast.Plus e = (Plus) _e;
			return new takmela.lexer.ast.Plus(convert(e.Expr));
		}
		else if(_e instanceof takmela.ast.Question)
		{
			takmela.ast.Question e = (Question) _e;
			return new takmela.lexer.ast.Question(convert(e.Expr));
		}
		else if(_e instanceof takmela.ast.RXSeq)
		{
			takmela.ast.RXSeq e = (RXSeq) _e;
			return new takmela.lexer.ast.RXSeq(Utils.map(e.Exprs, a->convert(a)));
		}
		else if(_e instanceof takmela.ast.Star)
		{
			takmela.ast.Star e = (Star) _e;
			return new takmela.lexer.ast.Star(convert(e.Expr));
		}
		else if(_e instanceof takmela.ast.Str)
		{
			takmela.ast.Str e = (Str) _e;
			return new takmela.lexer.ast.Str(e.Value);
		}
		else
		{
			throw new OptionNotHandledException(_e);
		}
	}

	private static takmela.lexer.ast.CharClassPart convert(CharClassPart _p)
	{
		if(_p instanceof takmela.ast.CharSingle)
		{
			takmela.ast.CharSingle p = (takmela.ast.CharSingle) _p;
			return new takmela.lexer.ast.CharSingle(p.Ch);
		}
		else if(_p instanceof takmela.ast.CharRange)
		{
			takmela.ast.CharRange p = (takmela.ast.CharRange) _p;
			return new takmela.lexer.ast.CharRange(p.From, p.To);
		}
		else
		{
			throw new OptionNotHandledException(_p);
		}
	}

	private static takmela.lexer.ast.LexerRule r(String name, String tok)
	{
		return new takmela.lexer.ast.LexerRule(name, 
				new ArrayList<>(), 
				new ArrayList<>(), 
				new ArrayList<>(), 
				null, 
				false, 
				new takmela.lexer.ast.Str(tok));
	}

	private static Set<String> collectInlineTokens(List<Rule> rules)
	{
		Set<String> ret = new HashSet<>();
		for (Rule rule : rules)
		{
			for (LLst<Expr> seq : rule.Options)
			{
				for (Expr _e : LLst.iterate(seq))
				{
					if (_e instanceof Terminal)
					{
						Terminal t = (Terminal) _e;
						ret.add(t.Value);
					}
				}
			}
		}
		return ret;
	}

	public static takmela.ast.Module parseSingleFile(String fn, List<String> outParseErrors) throws IOException
	{
		String code = String.copyValueOf(org.antlr.v4.runtime.misc.Utils.readFile(fn));
		ANTLRInputStream in = new ANTLRInputStream(code);

		ParsetoolsLexer lexer = new ParsetoolsLexer(in);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		ANTLRErrorListener errListener = new LexerParserErrorListener((e) -> outParseErrors.add(e));
		lexer.addErrorListener(errListener);

		ParsetoolsParser parser = new ParsetoolsParser(tokenStream);
		parser.addErrorListener(errListener);
		ParseTree tree = parser.program();

		String path = new File(fn).getCanonicalPath();
		ParsetoolsParserTreeListener listener = new ParsetoolsParserTreeListener(
				new ParsetoolsParserTreeListenerHelper(), path);

		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(listener, tree);

		takmela.ast.Module prog = new takmela.ast.Module(listener.rules, listener.lexer_rules);
		return prog;
	}
	
	public static takmela.ast.Module parseGrammar(String code, List<String> outParseErrors) throws IOException
	{
		ANTLRInputStream in = new ANTLRInputStream(code);

		ParsetoolsLexer lexer = new ParsetoolsLexer(in);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		ANTLRErrorListener errListener = new LexerParserErrorListener((e) -> outParseErrors.add(e));
		lexer.addErrorListener(errListener);

		ParsetoolsParser parser = new ParsetoolsParser(tokenStream);
		parser.addErrorListener(errListener);
		ParseTree tree = parser.program();

		String path = "<inline grammar>";
		ParsetoolsParserTreeListener listener = new ParsetoolsParserTreeListener(
				new ParsetoolsParserTreeListenerHelper(), path);

		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(listener, tree);

		takmela.ast.Module prog = new takmela.ast.Module(listener.rules, listener.lexer_rules);
		return prog;
	}
}
