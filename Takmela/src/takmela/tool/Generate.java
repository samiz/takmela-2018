package takmela.tool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import takmela.tree.TreeListenatorGen;
import utils.CmdLineParseException;
import utils.CmdLineParser;
import utils.Utils;

public class Generate
{
	public static void main(String[] args) throws CmdLineParseException, IOException
	{
		CmdLineParser cmdOpts = new CmdLineParser(null, Utils.set(""), Utils.set("-o", "--package"), args);

		String _package = cmdOpts.SingletonKwArgs.getOrDefault("--package", "");
		String outPath = cmdOpts.SingletonKwArgs.getOrDefault("-o", "./");
		if (cmdOpts.RestArgs.size() != 1)
		{
			System.out.println("Usage: tool.Generate -o <outdir> --package <pkgname> grammar.g");
			System.exit(1);
		}
		String inPath = cmdOpts.RestArgs.get(0);
		TreeListenatorGen gen = new TreeListenatorGen(outPath, _package, "MyGrammar");
		List<String> outParseErrors = new ArrayList<>();
		takmela.ast.Module m = takmela.tool.Parse.parseSingleFile(inPath, outParseErrors);
		if (outParseErrors.size() != 0)
		{
			System.out.println("Errors found in grammar:\n" + outParseErrors);
			System.exit(1);
		}
		gen.generateAll(m);
		gen.writeAll();
	}
}
