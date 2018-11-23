package takmela.ast;

public class Oring implements takmela.ast.Ast, takmela.ast.RExpr
{
	public final java.util.List<RExpr> Exprs;

	public Oring(java.util.List<RExpr> _Exprs)
	{
		this.Exprs = _Exprs;
	}

	@Override public String toString()
	{
		return String.format("Oring(%s)", utils.Utils.surroundJoin(this.Exprs, "[", "]", ", "));
	}
}
