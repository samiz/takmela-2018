package takmela.ast;

public class Module implements takmela.ast.Ast
{
	public final java.util.List<Rule> Rules;
	public final java.util.List<LexerRule> LexerRules;

	public Module(java.util.List<Rule> _Rules, java.util.List<LexerRule> _LexerRules)
	{
		this.Rules = _Rules;
		this.LexerRules = _LexerRules;
	}

	@Override public String toString()
	{
		return String.format("Module(%s, %s)", utils.Utils.surroundJoin(this.Rules, "[", "]", ", "),
				utils.Utils.surroundJoin(this.LexerRules, "[", "]", ", "));
	}
}
