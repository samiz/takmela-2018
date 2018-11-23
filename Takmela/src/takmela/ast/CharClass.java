package takmela.ast;

public class CharClass implements takmela.ast.Ast, takmela.ast.RExpr
{
	public final java.util.List<CharClassPart> Parts;

	public CharClass(java.util.List<CharClassPart> _Parts)
	{
		this.Parts = _Parts;
	}

	@Override public String toString()
	{
		return String.format("CharClass(%s)", utils.Utils.surroundJoin(this.Parts, "[", "]", ", "));
	}
}
