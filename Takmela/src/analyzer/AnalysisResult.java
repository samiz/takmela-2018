package analyzer;

import java.util.Map;
import java.util.Set;

import takmela.ast.Call;
import utils.Pair;

public class AnalysisResult
{
	public Set<Set<String>> equivalenceClasses;
	public Set<Call> leftCalls;
	public Map<Pair<String, Integer>, Set<String>> firstSets;
	public Map<String, Set<String>> fullFirstSets;

	public AnalysisResult(Set<Set<String>> equivalenceClasses, Set<Call> leftCalls,
			Map<Pair<String, Integer>, Set<String>> firstSets, Map<String, Set<String>> fullFirstSets)
	{
		super();
		this.equivalenceClasses = equivalenceClasses;
		this.leftCalls = leftCalls;
		this.firstSets = firstSets;
		this.fullFirstSets = fullFirstSets;
	}

	public boolean isRuleLeftRecursive(String ruleName)
	{
		return recursiveEquivalenceClass(ruleName) != null;
	}

	public Set<String> recursiveEquivalenceClass(String ruleName)
	{
		for (Set<String> c : equivalenceClasses)
		{
			if (c.contains(ruleName))
			{
				return c;
			}
		}
		return null;
	}
}
