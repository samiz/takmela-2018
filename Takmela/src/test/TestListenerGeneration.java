package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import takmela.tree.TreeListenatorGen;
import utils.Utils;

public class TestListenerGeneration
{
	public static void main(String[] args) throws IOException
	{
		test("./test/expr.g");
	}

	private static void test(String grammarFn) throws IOException
	{
		List<String> errs = new ArrayList<>();
		takmela.ast.Module mod = takmela.tool.Parse.parseSingleFile(grammarFn, errs);
		if (errs.size() != 0)
		{
			Utils.printf("%s", errs);
		}
		else
		{
			TreeListenatorGen gen = new TreeListenatorGen("./listenergentest", "listenergentest", "Expr");
			gen.generateAll(mod);
			for (Entry<String, String> kv : gen.generated.entrySet())
			{
				String path = kv.getKey();
				String code = kv.getValue();
				Utils.writeToFile(Utils.combinePath(gen.TargetDir, path), code);
			}
		}
	}
}
