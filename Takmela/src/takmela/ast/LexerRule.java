package takmela.ast;

public class LexerRule implements takmela.ast.Ast
{
	public final String Name;
	public final java.util.List<String> Within;
	public final java.util.List<String> Pushes;
	public final java.util.List<String> Pops;
	public final String Class;
	public final boolean Skip;
	public final RExpr Expr;

	public LexerRule(String _Name, java.util.List<String> _Within, java.util.List<String> _Pushes,
			java.util.List<String> _Pops, String _Class, boolean _Skip, RExpr _Expr)
	{
		this.Name = _Name;
		this.Within = _Within;
		this.Pushes = _Pushes;
		this.Pops = _Pops;
		this.Class = _Class;
		this.Skip = _Skip;
		this.Expr = _Expr;
	}

	@Override public String toString()
	{
		return String.format("LexerRule(%s, %s, %s, %s, %s, %s, %s)", this.Name,
				utils.Utils.surroundJoin(this.Within, "[", "]", ", "),
				utils.Utils.surroundJoin(this.Pushes, "[", "]", ", "),
				utils.Utils.surroundJoin(this.Pops, "[", "]", ", "), this.Class, this.Skip, this.Expr);
	}
}
