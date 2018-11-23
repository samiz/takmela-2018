package takmela.ast;

public class Question implements takmela.ast.Ast, takmela.ast.RExpr
{
	public final RExpr Expr;

	public Question(RExpr _Expr)
	{
		this.Expr = _Expr;
	}

	@Override public String toString()
	{
		return String.format("Question(%s)", this.Expr);
	}
}
