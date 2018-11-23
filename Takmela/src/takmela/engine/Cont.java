package takmela.engine;

import takmela.ast.Expr;
import takmela.tree.Tree;
import utils.LLst;

public class Cont
{
	public final int Id;

	// These two are redundant (already stored as keys in the map)
	public final String CalledRuleName;
	public final int CallInputPos;

	// OptionIndex is also redundant here, since we can resume a continuation
	// solely via the 'Code' field, but it's here for tracing/debugging etc
	public final String CallerRuleName;
	public final int OptionIndex;
	public final LLst<Expr> Code;

	//public final Cont Parent;

	public final Tree TreeSoFar;

	public Cont(int id, String calledRuleName, String callerRuleName, int callInputPos, int optionIndex,
			LLst<Expr> code, Cont parent, Tree treeSoFar)
	{
		Id = id;
		CalledRuleName = calledRuleName;
		CallerRuleName = callerRuleName;
		CallInputPos = callInputPos;
		OptionIndex = optionIndex;
		Code = code;
		//Parent = parent;
		TreeSoFar = treeSoFar;
	}

	public String toString()
	{
		return String.format("[#%s, %s, %s; %s, %s]", Id, CalledRuleName, CallInputPos, Code,
				//Parent.Id
				null);
	}
}
