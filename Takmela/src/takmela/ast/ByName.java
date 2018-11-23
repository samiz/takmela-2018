package takmela.ast;

public class ByName implements takmela.ast.Ast, takmela.ast.RExpr
{
	public final String Name;

	public ByName(String _Name)
	{
		this.Name = _Name;
	}

	@Override public String toString()
	{
		return String.format("ByName(%s)", this.Name);
	}
}
