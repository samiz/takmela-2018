package takmela.ast;

public class Star implements Ast, RExpr
{
	public final RExpr Expr;

	public Star(RExpr _Expr)
	{
		this.Expr = _Expr;
	}

	@Override public String toString()
	{
		return String.format("Star(%s)", this.Expr);
	}
}
