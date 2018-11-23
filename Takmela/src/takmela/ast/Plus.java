package takmela.ast;

public class Plus implements takmela.ast.Ast, takmela.ast.RExpr
{
	public final RExpr Expr;

	public Plus(RExpr _Expr)
	{
		this.Expr = _Expr;
	}

	@Override public String toString()
	{
		return String.format("Plus(%s)", this.Expr);
	}
}
