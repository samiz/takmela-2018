package takmela.ast;


public class RXSeq implements Ast, RExpr
{
	public final java.util.List<RExpr> Exprs;

	public RXSeq(java.util.List<RExpr> _Exprs)
	{
		this.Exprs = _Exprs;
	}

	@Override public String toString()
	{
		return String.format("RXSeq(%s)", utils.Utils.surroundJoin(this.Exprs, "[", "]", ", "));
	}
}
