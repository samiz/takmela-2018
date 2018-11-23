package takmela.lexer.ast;

public class CharRange implements takmela.lexer.ast.Ast, takmela.lexer.ast.CharClassPart
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
