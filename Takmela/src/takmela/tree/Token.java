package takmela.tree;

public class Token
{
	public final takmela.lexer.lexer.Token Token;

	public Token(takmela.lexer.lexer.Token token)
	{
		Token = token;
	}

	public String toString()
	{
		return Token.toString();
	}
}
