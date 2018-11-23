package takmela.ast;

public class CharRange implements takmela.ast.Ast, takmela.ast.CharClassPart
{
	public final char From;
	public final char To;

	public CharRange(char _From, char _To)
	{
		this.From = _From;
		this.To = _To;
	}

	@Override public String toString()
	{
		return String.format("CharRange(%s, %s)", this.From, this.To);
	}
}
