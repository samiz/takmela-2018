package takmela.engine;

import takmela.ast.Expr;
import utils.LLst;

public class Frame
{
	public String RuleName;
	public int RuleOption;
	public LLst<Expr> Seq;
	public int IP;
	public Frame Parent;

	public int InputPos;

	public Frame(String ruleName, int ruleOption, LLst<Expr> seq, int inputPos, int iP, Frame parent)
	{
		RuleName = ruleName;
		RuleOption = ruleOption;
		Seq = seq;
		InputPos = inputPos;
		IP = iP;
		Parent = parent;
	}

}
