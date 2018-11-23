package analyzer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import takmela.ast.Call;
import takmela.ast.Expr;
import takmela.ast.Rule;
import takmela.ast.Seq;
import takmela.ast.Terminal;

import java.util.Set;

import utils.ArgumentException;
import utils.LLst;
import utils.OptionNotHandledException;
import utils.Pair;
import utils.Utils;

public class Analyzer
{
	public Map<String, Set<Pair<String, List<String>>>> leftRecursive;
	public Map<Set<String>, Set<String>> leftRecursiveClassesToRules;
	public Set<Set<String>> equivalenceClasses;
	public Set<Call> leftCalls;

	public Map<Pair<String, Integer>, Set<String>> firstSets;
	public Map<String, Set<String>> fullFirstSets;

	private Map<String, Rule> Rules;

	private final boolean logging = false;
	// Direct & Indirect left calls
	// Map from rule name to pairs (calleeName, path)
	// where the path doesn't include the caller itself
	// for example for the sample 'sample_arithmetic.peg'
	// the left calls would be as follows:
	//
	//  sentence=[(expr, [expr]), (methodCall, [expr, methodCall]), (term, [expr, term])]
	//  expr=[(expr, [expr]), (term, [term]), (methodCall, [methodCall])]
	//	term=[]
	//	methodCall=[(expr, [expr]), (methodCall, [expr, methodCall]), (term, [expr, term])]
	private Map<String, Set<Pair<String, List<String>>>> leftCallsAll;

	public void analyze(List<Rule> rules)
	{
		Rules = new HashMap<>();
		for (Rule rule : rules)
		{
			Rules.put(rule.Name, rule);
		}
		leftCallsAll = computeLeftCalls();
		computeLeftRecursive();
		if (logging)
		{
			System.out.println("left recursive: " + leftRecursive);
			System.out.println("equivalence classes: " + equivalenceClasses);
		}

		computeFirstSets();
	}

	private void computeLeftRecursive()
	{
		leftRecursive = new HashMap<>();
		equivalenceClasses = new HashSet<>();
		for (Entry<String, Set<Pair<String, List<String>>>> kv : leftCallsAll.entrySet())
		{
			String ruleName = kv.getKey();
			Set<Pair<String, List<String>>> calls = kv.getValue();
			Set<Pair<String, List<String>>> leftRecursiveCalls = new HashSet<>();
			for (Pair<String, List<String>> p : calls)
			{
				if (p.a.equals(ruleName))
				{
					leftRecursiveCalls.add(p);
				}
			}
			if (leftRecursiveCalls.size() != 0)
			{
				leftRecursive.put(ruleName, leftRecursiveCalls);
				for (Pair<String, List<String>> p : leftRecursiveCalls)
				{
					equivalenceClasses.add(Utils.set(p.b));
				}
			}
		}
		equivalenceClasses = Utils.mergeEquivalence(equivalenceClasses);
	}

	private Map<String, Set<Pair<String, List<String>>>> computeLeftCalls()
	{
		Map<String, Set<Pair<String, List<String>>>> leftCalls = new HashMap<>();
		for (Entry<String, Rule> kv : Rules.entrySet())
		{
			String ruleName = kv.getKey();
			Rule rule = kv.getValue();
			this.leftCalls = new HashSet<>();
			Set<String> directCallees = leftCallees(rule.Options);
			Set<Pair<String, List<String>>> info = Utils.map(directCallees, (rn) -> {
				return new Pair<>(rn, Utils.list(rn));
			});
			leftCalls.put(ruleName, info);
		}

		while (true)
		{
			int oldsz = resultSize(leftCalls);
			for (Entry<String, Set<Pair<String, List<String>>>> kv : leftCalls.entrySet())
			{
				String ruleName = kv.getKey();
				Set<Pair<String, List<String>>> leftCallsOfRuleSoFar = kv.getValue();

				Set<Pair<String, List<String>>> newInferredLeftCalls = new HashSet<>();

				for (Pair<String, List<String>> callee : leftCallsOfRuleSoFar)
				{
					String calleeName = callee.a;
					List<String> calleePath = callee.b;
					Set<String> directCallees = leftCallees(r(calleeName).Options);
					for (String callee2 : directCallees)
					{
						if (!calleePath.contains(callee2))
						{
							Pair<String, List<String>> p = new Pair<>(callee2,
									Utils.append(calleePath, Utils.list(callee2)));
							newInferredLeftCalls.add(p);
							if (logging)
							{
								Utils.printf("inferred base=%s new=%s ", ruleName, p);
							}
						}
					}
				}

				//Utils.addAllIf(info, infoDeltas, (a)->!Utils.contains(info, (b)->a.a.equals(b.a)));
				leftCallsOfRuleSoFar.addAll(newInferredLeftCalls);
			}
			int sz = resultSize(leftCalls);
			if (oldsz == sz)
			{
				break;
			}
		}
		if (logging)
		{
			System.out.println(Utils.formatMapItemPerLine(leftCalls));
		}
		return leftCalls;
	}

	private int resultSize(Map<String, Set<Pair<String, List<String>>>> s)
	{
		int result = 0;
		for (Entry<String, Set<Pair<String, List<String>>>> kv : s.entrySet())
		{
			result++; // one for each key;
			result += kv.getValue().size(); // and for all callees
		}
		return result;
	}

	public Set<String> leftCallees(List<LLst<Expr>> ruleOptions)
	{
		Set<String> ret = new HashSet<>();
		for (int i = 0; i < ruleOptions.size(); ++i)
		{
			ret.addAll(leftCallees(ruleOptions.get(i)));
		}
		return ret;
	}

	public Set<String> leftCallees(LLst<Expr> seq)
	{
		// todo: handle cases where the first N leftmost
		// exprs are nullable

		Set<String> ret = new HashSet<>();
		if (seq.head != null)
		{
			ret.addAll(leftCallees(seq.head));
		}
		return ret;
	}

	public Set<String> leftCallees(Expr expr)
	{
		Set<String> ret = new HashSet<>();

		if (expr instanceof Call)
		{
			Call r = (Call) expr;
			ret.add(r.Callee);
			this.leftCalls.add((Call) expr);
		}
		else if (expr instanceof Seq)
		{
			throw new ArgumentException("Should be unreachable");
		}
		else if (expr instanceof Terminal)
		{
			// do nothing
		}
		else
		{
			throw new OptionNotHandledException(expr + "/" + expr.getClass());
		}
		return ret;
	}

	private void computeFirstSets()
	{
		Map<String, Set<String>> ruleFs = new HashMap<>();
		Map<Pair<String, Integer>, Set<String>> optFs = new HashMap<>();
		boolean done = false;

		for (Entry<String, Rule> kv : Rules.entrySet())
		{
			String rname = kv.getKey();
			Rule r = kv.getValue();
			for (int i = 0; i < r.Options.size(); ++i)
			{
				LLst<Expr> opt = r.Options.get(i);
				if (opt != null)
				{
					if (opt.head instanceof Terminal)
					{
						Utils.addMapSet(optFs, new Pair<String, Integer>(rname, i), ((Terminal) opt.head).Value);
					}
				}
			}
		}

		for (Entry<String, Rule> kv : Rules.entrySet())
		{
			String rname = kv.getKey();
			Rule r = kv.getValue();
			for (int i = 0; i < r.Options.size(); ++i)
			{
				Utils.addAllMapSet(ruleFs, rname, optFs.getOrDefault(new Pair<>(rname, i), new HashSet<>()));
			}
		}

		while (!done)
		{
			done = true;
			for (Entry<String, Rule> kv : Rules.entrySet())
			{
				String rname = kv.getKey();
				Rule r = kv.getValue();

				for (int i = 0; i < r.Options.size(); ++i)
				{
					LLst<Expr> opt = r.Options.get(i);
					if (opt.head != null && opt.head instanceof Call)
					{
						Call c = (Call) opt.head;
						Pair<String, Integer> k = new Pair<>(rname, i);
						Set<String> old = optFs.getOrDefault(k, new HashSet<>());
						Set<String> headnow = ruleFs.getOrDefault(c.Callee, new HashSet<>());
						Set<String> newz = Utils.setDiff(headnow, old);

						if (newz.size() != 0)
						{
							done = false;
							old.addAll(newz);
							Utils.addAllMapSet(optFs, k, newz);
						}
					}
				}
				for (int i = 0; i < r.Options.size(); ++i)
				{
					Utils.addAllMapSet(ruleFs, rname, optFs.getOrDefault(new Pair<>(rname, i), new HashSet<>()));
				}
			}
		}
		this.firstSets = optFs;
		this.fullFirstSets = ruleFs;
	}

	private Rule r(String ruleName)
	{
		return Utils.mustGet(Rules, ruleName);
	}

	public AnalysisResult getResult()
	{
		return new AnalysisResult(equivalenceClasses, leftCalls, firstSets, fullFirstSets);
	}
}
