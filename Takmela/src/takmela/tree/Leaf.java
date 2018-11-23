package takmela.tree;

public class Leaf implements Node
{
	public final takmela.lexer.lexer.Token token;

	public Leaf(takmela.lexer.lexer.Token token)
	{
		this.token = token;
	}

	public String toString()
	{
		return token.toString();
	}
}
