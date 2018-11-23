package takmela.ast;

public class CharSingle implements takmela.ast.Ast, takmela.ast.CharClassPart
{
	public final char Ch;

	public CharSingle(char _Ch)
	{
		this.Ch = _Ch;
	}

	@Override public String toString()
	{
		return String.format("CharSingle(%s)", this.Ch);
	}
}
