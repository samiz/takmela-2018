package takmela.lexer.automata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import takmela.lexer.ast.ByName;
import takmela.lexer.ast.CharClass;
import takmela.lexer.ast.CharClassPart;
import takmela.lexer.ast.CharSingle;
import takmela.lexer.ast.Oring;
import takmela.lexer.ast.Plus;
import takmela.lexer.ast.Question;
import takmela.lexer.ast.RExpr;
import takmela.lexer.ast.RXSeq;
import takmela.lexer.ast.Star;
import takmela.lexer.ast.Str;

import java.util.Set;
import java.util.Stack;

import utils.ArgumentException;
import utils.LabellerInt;
import utils.NotImplementedException;
import utils.OptionNotHandledException;
import utils.Pair;
import utils.Utils;

public class FAAlgo
{
	private int stateCounter = 0;

	public FA nfaFromRegEx(RExpr _e)
	{
		if (_e instanceof ByName)
		{
			//ByName e = (ByName) _e;
			throw new NotImplementedException("nfaFromRegEx/ByName");
		}
		else if (_e instanceof CharClass)
		{
			CharClass e = (CharClass) _e;
			e = canonicalized(e);
			int start = newState();
			int end = newState();

			return fa(start, end).trans(start, end, charRange(e));
		}
		else if (_e instanceof Oring)
		{
			Oring e = (Oring) _e;
			List<FA> opts = Utils.map(e.Exprs, a -> nfaFromRegEx(a));
			List<Integer> startEpsilons = Utils.map(opts, a -> a.startState);
			List<Integer> endEpsilons = Utils.map(opts, a -> onlyAcceptingState(a));

			int start = newState();
			int end = newState();

			FA fa = fa(start, end).merge(opts);

			for (int i = 0; i < opts.size(); ++i)
			{
				fa.trans(start, startEpsilons.get(i), epsilon());
				fa.trans(endEpsilons.get(i), end, epsilon());
			}
			return fa;
		}
		else if (_e instanceof Plus)
		{
			Plus e = (Plus) _e;
			FA fa = nfaFromRegEx(e.Expr);
			fa.trans(onlyAcceptingState(fa), fa.startState, epsilon());
			return fa;
		}
		else if (_e instanceof RXSeq)
		{
			RXSeq e = (RXSeq) _e;
			if (e.Exprs.size() == 1)
			{
				return nfaFromRegEx(e.Exprs.get(0));
			}
			List<FA> opts = Utils.map(e.Exprs, a -> nfaFromRegEx(a));
			FA fa = fa(opts.get(0).startState, onlyAcceptingState(Utils.last(opts))).merge(opts);
			for (int i = 0; i < opts.size() - 1; ++i)
			{
				fa.trans(onlyAcceptingState(opts.get(i)), opts.get(i + 1).startState, epsilon());
			}
			return fa;
		}
		else if (_e instanceof Star)
		{
			Star e = (Star) _e;
			FA fa = nfaFromRegEx(e.Expr);
			fa.trans(onlyAcceptingState(fa), fa.startState, epsilon());
			fa.trans(fa.startState, onlyAcceptingState(fa), epsilon());
			return fa;
		}
		else if (_e instanceof Question)
		{
			Question e = (Question) _e;
			FA fa = nfaFromRegEx(e.Expr);
			fa.trans(fa.startState, onlyAcceptingState(fa), epsilon());
			return fa;
		}
		else if (_e instanceof Str)
		{
			Str e = (Str) _e;
			List<RExpr> seq = new ArrayList<>();
			for (int i = 0; i < e.Value.length(); ++i)
			{
				char c = e.Value.charAt(i);
				CharClass cc = new CharClass(Utils.list((CharClassPart) new takmela.lexer.ast.CharRange(c, c)));
				seq.add(cc);
			}
			return nfaFromRegEx(new RXSeq(seq));
		}
		else
		{
			throw new OptionNotHandledException(_e);
		}
	}

	private int onlyAcceptingState(FA a)
	{
		if (a.acceptingStates.size() != 1)
		{
			throw new ArgumentException("NFAs should be prepared with exactly one accepting state");
		}
		return a.acceptingStates.iterator().next();
	}

	public FA nfaWithNoCommonTransitions(FA fa)
	{
		int ss = fa.startState;
		Set<Integer> as = fa.acceptingStates;

		Map<Integer, List<Pair<Trans, Integer>>> newTg = new HashMap<>();
		for (Entry<Integer, List<Pair<Trans, Integer>>> kv : fa.tg.entrySet())
		{
			int fromState = kv.getKey();
			List<Pair<Trans, Integer>> transitions = kv.getValue();
			List<Pair<Trans, Integer>> newTransitions = removeCommonTransitions(transitions);
			newTg.put(fromState, newTransitions);
		}
		return new FA(ss, as, newTg);
	}

	private List<Pair<Trans, Integer>> removeCommonTransitions(List<Pair<Trans, Integer>> _transitions)
	{
		List<Pair<Trans, Integer>> transitions = Utils.list(_transitions);
		while (true)
		{
			boolean toSplit = false;
			Pair<Trans, Integer> split1 = null, split2 = null;

			outer: for (int i = 0; i < transitions.size(); ++i)
			{
				Pair<Trans, Integer> a = transitions.get(i);
				for (int j = i + 1; j < transitions.size(); ++j)
				{
					Pair<Trans, Integer> b = transitions.get(j);
					if (a.b != b.b && (!a.a.equals(b.a)) && hasCommon(a.a, b.a))
					{
						toSplit = true;
						split1 = a;
						split2 = b;
						break outer;
					}
				}
			}

			if (toSplit)
			{
				Untangle unt = untangle(split1, split2);
				transitions.remove(split1);
				transitions.remove(split2);

				addTranss(transitions, unt.onlyA, split1.b);
				addTranss(transitions, unt.onlyB, split2.b);

				transitions.add(new Pair<>(unt.common, split1.b));
				transitions.add(new Pair<>(unt.common, split2.b));
			}
			else
			{
				break;
			}
		}
		return transitions;
	}

	private void addTranss(List<Pair<Trans, Integer>> transitions, List<CharRange> ranges, Integer toState)
	{
		for (CharRange r : ranges)
		{
			transitions.add(new Pair<>(r, toState));
		}
	}

	private Untangle untangle(Pair<Trans, Integer> t1, Pair<Trans, Integer> t2)
	{
		CharRange a = (CharRange) t1.a;
		CharRange b = (CharRange) t2.a;

		utils.Untangle<Integer> u = Utils.untangle(a.From, a.To, b.From, b.To);

		Set<CharRange> onlyA = Utils.map(u.onlyA, (p) -> new CharRange(ch(p.a), ch(p.b)));
		Set<CharRange> onlyB = Utils.map(u.onlyB, (p) -> new CharRange(ch(p.a), ch(p.b)));

		Untangle ret = new Untangle(Utils.list(onlyA), new CharRange(ch(u.common.a), ch(u.common.b)),
				Utils.list(onlyB));
		return ret;
	}

	public FA dfaFromNfa(FA nfa)
	{
		Map<Set<Integer>, Set<Pair<Trans, Set<Integer>>>> newTg = new HashMap<>();
		Set<Integer> startState = epsilonClosure(nfa.startState, nfa);
		Set<Set<Integer>> newAcceptingStates = new HashSet<>();

		Stack<Set<Integer>> workList = new Stack<>();
		Set<Set<Integer>> done = new HashSet<>();

		workList.push(startState);

		while (!workList.isEmpty())
		{
			Set<Integer> state = workList.pop();
			done.add(state);
			List<Pair<Trans, Integer>> allOutTrans = new ArrayList<>();

			if (Utils.intersect(nfa.acceptingStates, state).size() != 0)
			{
				newAcceptingStates.add(state);
			}

			for (int s : state)
			{
				allOutTrans.addAll(nfa.outTrans(s));
			}
			Map<Trans, List<Pair<Trans, Integer>>> groups = Utils.groupBy(allOutTrans, (p) -> p.a);
			for (Entry<Trans, List<Pair<Trans, Integer>>> kv : groups.entrySet())
			{
				Trans cond = kv.getKey();
				if (!(cond instanceof Epsilon))
				{
					List<Integer> _states = Utils.mapB(kv.getValue());
					Set<Integer> states = Utils.set(_states);
					states = epsilonClosure(states, nfa);
					Utils.addMapSet(newTg, state, new Pair<>(cond, states));

					if (!done.contains(states))
					{
						//Utils.printf("found new state: %s", states);
						workList.add(states);
					}
				}
			}
		}

		LabellerInt<Set<Integer>> c = new LabellerInt<>();

		FA dfa = new FA(c.labelFor(startState), -1);
		for (Entry<Set<Integer>, Set<Pair<Trans, Set<Integer>>>> kv : newTg.entrySet())
		{
			int s = c.labelFor(kv.getKey());
			List<Pair<Trans, Integer>> trans2 = Utils
					.list(Utils.map(kv.getValue(), (p) -> new Pair<Trans, Integer>(p.a, c.labelFor(p.b))));
			dfa.tg.put(s, trans2);
		}
		Set<Integer> accepting = Utils.map(newAcceptingStates, (Set<Integer> s) -> c.labelFor(s));
		dfa.acceptingStates = accepting;
		return dfa;
	}

	private Set<Integer> epsilonClosure(Set<Integer> state, FA fa)
	{
		Set<Integer> ret = new HashSet<>();
		for (int s : state)
		{
			ret.addAll(epsilonClosure(s, fa));
		}
		return ret;
	}

	private Set<Integer> epsilonClosure(int state, FA fa)
	{
		return Utils.transitiveClosure(state, (s) -> epsilons(s, fa));
	}

	private Set<Integer> epsilons(int state, FA fa)
	{
		Set<Integer> eps = new HashSet<>();
		for (Pair<Trans, Integer> t : fa.outTrans(state))
		{
			if (t.a instanceof Epsilon)
			{
				eps.add(t.b);
			}
		}
		return eps;
	}

	private char ch(Integer b)
	{
		return Character.toChars(b)[0];
	}

	private boolean hasCommon(Trans a, Trans b)
	{
		if (a instanceof CharRange && b instanceof CharRange)
		{
			CharRange aa = (CharRange) a;
			CharRange bb = (CharRange) b;

			if (bb.From > aa.To || aa.From > bb.To)
			{
				return false;
			}
			return true;
			/*
			// The following is equivalent to the above (from DeMorgan's laws)
			// even though the above is much more obvious. Math is cool like that.
			
			// To show it, here are diagrams:
			// Case #1
			//     |a---------------------|
			//              |b------------------|
			 
			// Case #2
			//                |a---------------------|
			//     |b------------------|
			
			// Case #3
			//                |a----|
			//     |b------------------|
			
			// Case #4
			//                |a---------------------|
			//                     |b-----------|
			
			 
			if(bb.From <= aa.To && aa.From <= bb.To)
			{
				return true;
			}
			return false;
			 */
		}
		return false;
	}

	private CharClass canonicalized(CharClass e)
	{
		List<takmela.lexer.ast.CharRange> l2 = new ArrayList<>();
		for (CharClassPart c : e.Parts)
		{
			if (c instanceof CharSingle)
			{
				CharSingle cs = (CharSingle) c;
				l2.add(new takmela.lexer.ast.CharRange(cs.Ch, cs.Ch));
			}
			else if (c instanceof takmela.lexer.ast.CharRange)
			{
				takmela.lexer.ast.CharRange cr = (takmela.lexer.ast.CharRange) c;
				if (cr.From > cr.To)
				{
					cr = new takmela.lexer.ast.CharRange(cr.To, cr.From);
				}
				l2.add(cr);
			}
			else
			{
				throw new OptionNotHandledException(c);
			}
		}
		l2.sort((a, b) -> Integer.compare(a.From, b.From));
		List<CharClassPart> l3 = new ArrayList<>();
		l3.addAll(l2);
		return new CharClass(l3);
	}

	private Trans epsilon()
	{
		return new Epsilon();
	}

	private FA fa(int start, int accept)
	{
		return new FA(start, accept);
	}

	private List<Trans> charRange(CharClass cc)
	{
		List<Trans> ret = new ArrayList<>();
		for (CharClassPart _cr : cc.Parts)
		{
			// Assumes the CharClass has been canonicalized
			// i.e all parts are ranges
			takmela.lexer.ast.CharRange cr = (takmela.lexer.ast.CharRange) _cr;
			ret.add(new CharRange(cr.From, cr.To));
		}
		return ret;
	}

	private int newState()
	{
		return stateCounter++;
	}
}
