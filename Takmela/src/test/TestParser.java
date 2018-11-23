package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import takmela.lexer.lexer.LexerError;
import utils.Utils;

public class TestParser
{
	public static void main(String[] args) throws IOException, LexerError
	{
		//test("./test/expr.g", "./test/expr_input1.txt", "expr");
		//test("./test/expr.g", "./test/expr_input2.txt", "expr");
		//test("./test/expr.g", "./test/expr_input3.txt", "expr");
		//test("./test/expr.g", "./test/expr_input4.txt", "expr");

		//test("./test/expr_ambig.g", "./test/expr_ambig_input1.txt", "expr");
		//test("./test/expr_ambig.g", "./test/expr_ambig_input1_with_nl.txt", "expr");

		//test("./test/aycock_null.g", "./test/aycock_null_input.txt", "start");
		test("./test/right_recursion.g", "./test/right_recursion_input.txt", "a");

		//test("./test/epsilon.g", "./test/epsilon_input1.txt", "expr");
		//test("./test/epsilon.g", "./test/epsilon_input2.txt", "expr");

		//test("./test/testFirstSet.g", "./test/expr_input1.txt", "expr");
	}

	private static void test(String grammarFn, String inputFn, String startSymbol) throws IOException, LexerError
	{
		List<String> errs = new ArrayList<>();

		takmela.ast.Module mod = takmela.tool.Parse.parseSingleFile(grammarFn, errs);
		if (errs.size() != 0)
		{
			Utils.printf("%s", errs);
		}
		else
		{
			String inputStr = Utils.readAllFile(inputFn);
			takmela.tool.Parse.parse(mod, inputStr, startSymbol, false, (t) -> Utils.printf("Created parse tree: %s", t));
		}
	}
}
