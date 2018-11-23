package takmela.tree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import takmela.ast.Call;
import takmela.ast.Expr;
import takmela.ast.Rule;
import takmela.ast.Seq;
import takmela.ast.Terminal;
import takmela.ast.Tokenz;
import takmela.lexer.lexer.Lexer;
import utils.LLst;
import utils.OptionNotHandledException;
import utils.Utils;

public class TreeListenatorGen
{
	public final String TargetDir;
	public final String PackageName;
	private final String GrammarName;

	// map relative path -> generated code, e.g 'trees/MyTree.java' -> codecodecode
	public final Map<String, String> generated = new HashMap<>();

	public TreeListenatorGen(String targetDir, String packageName, String grammarName)
	{
		TargetDir = targetDir;
		PackageName = packageName;
		GrammarName = grammarName;
	}

	public void generateAll(takmela.ast.Module m)
	{
		generateListenator(m);
		generateTokenVocab(m);
	}

	public void writeAll() throws IOException
	{
		for (Entry<String, String> kv : generated.entrySet())
		{
			String fn = kv.getKey();
			String code = kv.getValue();
			Utils.writeToFile(Utils.combinePath(TargetDir, fn), code);
		}
	}

	private void generateListenator(takmela.ast.Module m)
	{
		List<String> allContexts = new ArrayList<>();
		for (Rule r : m.Rules)
		{
			if (r.Labels.size() == r.Options.size())
			{
				int i = 0;
				for (LLst<Expr> opt : r.Options)
				{
					String ctxName = r.Labels.get(i);
					genContextClass(ctxName, Utils.<LLst<Expr>>list(opt));
					allContexts.add(ctxName);
					i++;
				}
			}
			else if (r.Labels.size() == 0)
			{
				genContextClass(r.Name, r.Options);
				allContexts.add(r.Name);
			}
			else
			{
				throw new RuntimeException("Rule " + r.Name + ": must label all options or none");
			}
		}
		genVisitorClass(allContexts);
		genListenerInterfaceAndClass(allContexts);
	}

	private void genVisitorClass(List<String> allContexts)
	{
		StringBuilder sb = new StringBuilder();

		gPackage(sb);
		g(sb, "public class %sTreeVisitor {", GrammarName);
		g(sb, "public void visit(tree.Tree tree, %sTreeListener listener) {", GrammarName);

		String sep = "";
		for (String name : allContexts)
		{
			g(sb, "%sif(tree.Label.equals(\"%s\")) {", sep, name);
			sep = "else ";

			g(sb, "%sContext __context = new %sContext(tree);", upper(name), upper(name));
			g(sb, "__context.enterTree(listener);");
			g(sb, "for(tree.Node child : tree.Children) {");
			g(sb, "if(child instanceof tree.Tree) {");
			g(sb, "visit((tree.Tree) child, listener);");
			g(sb, "}");
			g(sb, "}");
			g(sb, "__context.exitTree(listener);");
			g(sb, "} // if");
		}
		g(sb, "}");
		g(sb, "}");

		putGen(String.format("%sTreeVisitor", GrammarName), sb.toString());
	}

	private void genListenerInterfaceAndClass(List<String> allContexts)
	{
		StringBuilder sb = new StringBuilder();

		gPackage(sb);
		g(sb, "public interface %sTreeListener {", GrammarName);

		for (String name : allContexts)
		{
			g(sb, "void enter%s(%sContext ctx);", upper(name), upper(name));
			g(sb, "void exit%s(%sContext ctx);", upper(name), upper(name));
			g(sb, "");
		}
		g(sb, "}");

		putGen(String.format("%sTreeListener", GrammarName), sb.toString());

		sb = new StringBuilder();

		gPackage(sb);
		g(sb, "public class %sBaseListener implements %sTreeListener {", GrammarName, GrammarName);

		for (String name : allContexts)
		{
			g(sb, "public void enter%s(%sContext ctx) { } ", upper(name), upper(name));
			g(sb, "public void exit%s(%sContext ctx) { } ", upper(name), upper(name));
			g(sb, "");
		}
		g(sb, "}");

		putGen(String.format("%sBaseListener", GrammarName), sb.toString());
	}

	private void genContextClass(String name, List<LLst<Expr>> sequences)
	{
		Map<String, Integer> callCount = new HashMap<>();
		Map<String, Integer> terminalCount = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		gPackage(sb);
		g(sb, "public class %sContext extends tree.VisitContext {", upper(name));
		g(sb, "public %sContext(tree.Tree tree) {", upper(name));
		g(sb, "super(tree);");
		g(sb, "}");
		g(sb, "public void enterTree(%sTreeListener listener) {", GrammarName);
		g(sb, "listener.enter%s(this);", upper(name));
		g(sb, "}");
		g(sb, "public void exitTree(%sTreeListener listener) {", GrammarName);
		g(sb, "listener.exit%s(this);", upper(name));
		g(sb, "}");
		for (LLst<Expr> a : sequences)
		{
			for (Expr b : a)
			{
				if (b instanceof Tokenz)
				{
					Tokenz t = (Tokenz) b;
					Utils.incCountMap(terminalCount, t.Value);
				}
				else if (b instanceof Terminal)
				{
				}
				else if (b instanceof Call)
				{
					Call c = (Call) b;
					Utils.incCountMap(callCount, c.Callee);
				}
				else if (b instanceof Seq)
				{
					//nop
				}
				else
				{
					throw new OptionNotHandledException(b);
				}
			}
		}
		for (Entry<String, Integer> kv : callCount.entrySet())
		{
			String typeName = kv.getKey();
			if (kv.getValue() > 1)
			{
				g(sb, "java.util.List<%sContext> %s() {", upper(typeName), typeName);
				g(sb, "return __contexts(\"%s\", %sContext.class);", typeName, upper(typeName));
				g(sb, "}");
			}
			else
			{
				g(sb, "%sContext %s() {", upper(typeName), typeName);
				g(sb, "return __context(\"%s\", %sContext.class);", typeName, upper(typeName));
				g(sb, "}");
			}
		}

		for (Entry<String, Integer> kv : terminalCount.entrySet())
		{
			String typeName = kv.getKey();
			if (kv.getValue() > 1)
			{
				g(sb, "java.util.List<lexer.Token> %s() {", typeName);
				g(sb, "return __terminals(\"%s\");", typeName);
				g(sb, "}");
			}
			else
			{
				g(sb, "lexer.Token %s() {", typeName);
				g(sb, "return __terminal(%s%sTokenVocab.%s);", PackageName != "" ? PackageName + "." : "",
						upper(GrammarName), typeName.toUpperCase());
				g(sb, "}");
			}
		}

		g(sb, "}");
		putGen(upper(name) + "Context", sb.toString());
	}

	private void generateTokenVocab(takmela.ast.Module m)
	{
		StringBuilder sb = new StringBuilder();

		Map<String, Integer> vocab = Lexer.initDefaultVocab(Utils.map(m.LexerRules, r->takmela.tool.Parse.convert(r)));

		gPackage(sb);
		g(sb, "public interface %sTokenVocab  {", upper(GrammarName));
		for (Entry<String, Integer> kv : vocab.entrySet())
		{
			String name = kv.getKey();
			int id = kv.getValue();
			g(sb, "public static int " + name.toUpperCase() + " = " + id + ";");
		}
		g(sb, "}");

		putGen(upper(GrammarName) + "TokenVocab", sb.toString());
	}

	private String upper(String name)
	{
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	private void putGen(String path, String generatedStr)
	{
		this.generated.put(path + ".java", generatedStr);
	}

	private void g(StringBuilder sb, String fmt, Object... args)
	{
		sb.append(String.format(fmt, args));
		sb.append("\n");
	}

	private void gPackage(StringBuilder sb)
	{
		if (!PackageName.equals(""))
		{
			g(sb, "package %s;\n", PackageName);
		}
	}
}
