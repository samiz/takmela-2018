package takmela.ast;

public class Str implements Ast, RExpr
{
	public final String Value;

	public Str(String _Value)
	{
		this.Value = _Value;
	}

	@Override public String toString()
	{
		return String.format("Str(%s)", this.Value);
	}
}
