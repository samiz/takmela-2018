package takmela.ast;

public class Token implements takmela.ast.Ast, takmela.ast.Expr
{
	public final String Value;

	public Token(String _Value)
	{
		this.Value = _Value;
	}

	@Override public String toString()
	{
		return String.format("Token(%s)", this.Value);
	}
}
