package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.io.File;
import java.io.FileReader;

public class Utils
{
	public static void printf(String fmt, Object...args)
	{
		System.out.println(String.format(fmt, args));
	}
	
	public static String combinePath(String path, String filename)
	{
		return new File(new File(path), filename).getAbsolutePath();
	}
	
	public static String readAllFile(String filename) throws IOException
	{
		BufferedReader r = new BufferedReader(new FileReader(filename));
		StringBuilder sb = new StringBuilder();
		String line;
		String delim = "";
		while((line = r.readLine()) != null)
		{
			sb.append(delim + line);
			delim = "\n";
		}
		r.close();
		return sb.toString();
	}
	
	public static void writeToFile(String filename, String text) throws IOException
	{
		BufferedWriter w = new BufferedWriter(new FileWriter(filename));
		w.write(text);
		w.close();
	}
	
	// Different from Java's String.subString in that it doesn't throw
	// if n is larger than the string length, but just returns as many
	// characters as possible
	public static String left(String text, int n)
	{
		n = n <=text.length() ? n : text.length();
		return text.substring(0, n);
	}
	
	// Different from Java's String.subString in that it doesn't throw
	// if n is larger than the string length, but just returns as many
	// characters as possible
	public static String mid(String text, int i, int n)
	{
		int endIndex = i + n;
		if(endIndex > text.length())
		{
			endIndex = text.length();
		}
		return text.substring(i, endIndex);
	}
	
	@SafeVarargs
	public static<T> List<T> list(T... ts)
	{
		ArrayList<T> ret = new ArrayList<>();
		for(T t : ts)
			ret.add(t);
		
		return ret;
	}
	
	public static<T> List<T> list(Collection<? extends T> coll)
	{
		List<T> ret = new ArrayList<>();
		ret.addAll(coll);
		return ret;
	}
	
	public static<T> Set<T> set(Collection<? extends T> elements)
	{
		Set<T> ret = new HashSet<>();
		for(T value : elements)
		{
			ret.add(value);
		}
		return ret;
	}
	
	public static<T> Set<T> set(@SuppressWarnings("unchecked") T... elements)
	{
		Set<T> ret = new HashSet<>();
		for(T value : elements)
		{
			ret.add(value);
		}
		return ret;
	}
	
	public static <TK,TV> TV mustGet(Map<TK, TV> map, TK key)
	{
		TV ret = map.get(key);
		if(ret == null)
		{
			throw new ExistenceException(String.format("Key %s must exist in map", key));
		}
		return ret;
	}
	
	public static<T> List<T> slice(List<T> lst, int i, int n)
	{
		List<T> ret = new ArrayList<>();
		for(int j=0; j < n; ++j)
		{
			ret .add(lst.get(i+j));
		}
		return ret;
	}
	
	public static<T> T last(List<T> lst)
	{
		// Always assumes list has at least one element	
		return lst.get(lst.size()-1);
	}
	
	public static <TK, TV> void addMapList(Map<TK, List<TV>> map, TK key, TV value)
	{
		List<TV> lst = null;
		if(!map.containsKey(key))
		{
			lst = new ArrayList<TV>();
			map.put(key, lst);
		}
		else
		{
			lst = map.get(key);
		}
		lst.add(value);
	}
	
	public static <TK, TV> void addMapSet(Map<TK, Set<TV>> map, TK key, TV value)
	{
		Set<TV> set = null;
		if(!map.containsKey(key))
		{
			set = new HashSet<>();
			map.put(key, set);
		}
		else
		{
			set = map.get(key);
		}
		set.add(value);
	}
	
	public static<Tk, Tv> void addAllMapSet(Map<Tk, Set<Tv>> map, Tk key, Collection<Tv> values)
	{
		Set <Tv> set = null;
		
		if(!map.containsKey(key))
		{
			set = new HashSet<>();
			map.put(key, set);
		}
		else
		{
			set = map.get(key);
		}
		set.addAll(values);
	}
	
	public static<T> void incCountMap(Map<T, Integer> countMap, T value)
	{
		Integer exists = countMap.get(value);
		if(exists != null)
		{
			countMap.put(value, exists +1);
		}
		else
		{
			countMap.put(value, 1);
		}
	}
	
	public static<T> List<T> append(Collection<T> a, Collection<T> b)
	{
		List<T> ret = new ArrayList<T>(a.size() + b.size());
		
		ret.addAll(a);
		ret.addAll(b);
		
		return ret;
	}
	
	@SafeVarargs
	public static<T> List<T> concat(List<? extends T>... lists)
	{
		ArrayList<T> ret = new ArrayList<>();
		for(List<? extends T> l : lists)
			ret.addAll(l);
		
		return ret;
	}
	
	public static<T> Set<T> intersect(Set<T> s1, Set<T> s2)
	{
		if(s1.size() > s2.size())
		{
			Set<T> tmp = s1;
			s1 = s2;
			s2 = tmp;
		}
		Set<T> result = new HashSet<>();
		for(T t : s1)
		{
			if(s2.contains(t))
			{
				result.add(t);
			}
		}
		return result;
	}

	public static<T> Set<T> setDiff(Set<T> s1, Set<T> s2)
	{
		Set<T> ret = new HashSet<>();
		for(T t : s1)
		{
			if(!s2.contains(t))
			{
				ret.add(t);
			}
		}
		return ret;
	}
	
	public static<T> Set<T> setUnion(Set<T> s1, Set<T> s2)
	{
		Set<T> ret = new HashSet<>();
		
		for(T t : s1)
		{
			ret.add(t);
		}

		for(T t : s2)
		{
			ret.add(t);
		}

		return ret;
	}
	
	public static<Tk, Tv> String formatMapItemPerLine(Map<Tk, Tv> map)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		for(Entry<Tk, Tv> kv : map.entrySet())
		{
			sb.append(String.format("%s=%s\n", kv.getKey(), kv.getValue()));
		}
		sb.append("}");
		return sb.toString();
	}
	
	public static<T> String join(T[] data, String separator)
	{
		if(data.length == 0)
			return "";
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<data.length-1; ++i)
		{
			sb.append(data[i]);
			sb.append(separator);
		}
		sb.append(data[data.length-1]);
		
		return sb.toString();
	}
	
	public static<T> String join(Iterable<T> exprs, String separator)
	{
		Iterator<T> iter = exprs.iterator();
		if(!iter.hasNext())
			return "";
		
		StringBuilder sb = new StringBuilder();
		String delim = "";
		while(iter.hasNext())
		{
			T value = iter.next();
			sb.append(delim);
			delim = separator;
			sb.append(value);
		}
		
		return sb.toString();
	}
	
	public static<T> String joinMap(Collection<T> args, String sep, Function<T, String> fn)
	{
		if(args.size() == 0)
			return "";
		
		StringBuilder sb = new StringBuilder();
		String delim = "";
		for(T value : args)
		{
			sb.append(delim);
			delim = sep;
			sb.append(fn.apply(value));
		}
		
		return sb.toString();
	}

	public static<T> String surroundJoin(Collection<T> exprs, String surroundLeft, String surroundRight, String separator)
    {
        if(exprs.size() == 0)
            return "";
        
        StringBuilder sb = new StringBuilder();
        String delim = "";
        for(T value : exprs)
        {
            sb.append(delim);
            delim = separator;
            sb.append(surroundLeft);
            sb.append(value);
            sb.append(surroundRight);
        }
        
        return sb.toString();
    }
	
	public static<T1,T2> List<T2> map(List<T1> list, Function<T1, T2> fn)
	{
		List<T2> ret = new ArrayList<>();
		for(T1 value : list)
		{
			ret.add(fn.apply(value));
		}
		return ret;
	}
	
	public static<T1,T2> Set<T2> map(Set<T1> set, Function<T1, T2> fn)
	{
		Set<T2> ret = new HashSet<>();
		for(T1 value : set)
		{
			ret.add(fn.apply(value));
		}
		return ret;
	}
	
	public static<T1, T2> List<T2> mapB(List<Pair<T1, T2>> list)
	{
		List<T2> ret = new ArrayList<>();
		for(Pair<T1, T2> value : list)
		{
			ret.add(value.b);
		}
		return ret;
	}
	
	public static<T> Set<Set<T>> mergeEquivalence(Set<Set<T>> equivalenceClassesBase)
	{
		return mergeEquivalence(equivalenceClassesBase, (s1, s2)->setIntersects(s1, s2));
	}
	
	// Assumes both sets are non-empty
	public static<T> boolean setIntersects(Set<T> s1, Set<T> s2)
	{
		if(s1.size() > s2.size())
		{
			Set<T> tmp = s1;
			s1 = s2;
			s2 = tmp;
		}
		for(T t : s1)
		{
			if(s2.contains(t))
			{
				return true;
			}
		}
		return false;
	}

	public static<T> Set<Set<T>> mergeEquivalence(Set<Set<T>> equivalenceClassesBase, BiPredicate<Set<T>, Set<T>> eq)
	{
		List<Set<T>> lst = Utils.list(equivalenceClassesBase);
		while(true)
		{
			List<Set<T>> lst2 = new ArrayList<>();
			Set<Set<T>> merged = new HashSet<>();
			for(int i=0; i<lst.size(); ++i)
			{
				Set<T> s1 = lst.get(i);
				if(merged.contains(s1)) { continue; }
				Set<T> newS1 = set(s1);
				for(int j=i+1; j<lst.size(); ++j)
				{
					Set<T> s2 = lst.get(j);
					
					if(eq.test(newS1, s2))
					{
						newS1 = setUnion(newS1, s2);
						merged.add(s2);
					}
				}
				lst2.add(newS1);
			}
			if(lst2.size() == lst.size()) { break; }
			lst = lst2;
		}
		return Utils.set(lst);
	}
	
	public static utils.Untangle<Integer> untangle(int aFrom, int aTo, int bFrom, int bTo)
	{
		if(aFrom > bTo || aFrom > aTo)
		{
			Untangle<Integer> result = new Untangle<>();
			result.onlyA.add(new Pair<>(aFrom, aTo));
			result.onlyB.add(new Pair<>(bFrom, bTo));
			result.common = null;
			return result;
		}
		else
		{
			boolean swap = false;
			
			if(aFrom > bFrom)
			{
				swap = true;
				
				int temp = aFrom;
				aFrom = bFrom;
				bFrom = temp;
				
				temp = aTo;
				aTo = bTo;
				bTo = temp;
			}
			
			if(aFrom == bFrom && aTo > bTo)
			{
				swap = true;
				
				int temp = aFrom;
				aFrom = bFrom;
				bFrom = temp;
				
				temp = aTo;
				aTo = bTo;
				bTo = temp;
			}
			
			Untangle<Integer> ret = untangle__(aFrom, aTo, bFrom, bTo);
			if(swap)
			{
				Set<Pair<Integer, Integer>> temp = ret.onlyA;
				ret.onlyA = ret.onlyB;
				ret.onlyB = temp;
			}
			return ret;
		}
	}
	
	/*
 	Input: - Two INCLUSIVE ranges 
 	       - ...that must have a part in common
 	       - ...and must be canonicalized as follows:
 	       		* a.from <= b.from                  is always true
 	       		* a.to < b.to if a.from==b.from     is always true
 	       		* from <= to                        is always true for a & b 					 
 	Output: Three disjoint sets: (A - common, common, B - common)
 	        each set can be zero, one or more char ranges
 	This code is very tricky, needs a lot of testing
	*/
	private static utils.Untangle<Integer> untangle__(int aFrom, int aTo, int bFrom, int bTo)
	{
		Untangle<Integer> ret = new Untangle<>();
		
		int f1 = aFrom;
		int t1 = bFrom -1;
		if(f1 <= t1) { ret.onlyA.add(new Pair<>(f1, t1)); }
		
		f1 = bTo + 1;
		t1 = aTo;
		if(f1 <= t1) { ret.onlyA.add(new Pair<>(f1, t1)); }
			
		f1 = aTo +1;
		t1 = bTo;
		if(f1 <= t1) { ret.onlyB.add(new Pair<>(f1, t1)); }
		
		f1 = bFrom;
		t1 = Math.min(aTo, bTo);
		ret.common = new Pair<>(f1, t1);
		
		return ret;
	}
	
	public static<Tk, Tobj> Map<Tk, List<Tobj>> groupBy(Collection<? extends Tobj> collection,
			Function<Tobj, Tk> fn)
	{
		Map<Tk, List<Tobj>> ret = new HashMap<>();
		for(Tobj obj : collection)
		{
			Tk key = fn.apply(obj);
			Utils.addMapList(ret, key, obj);
		}
		return ret;
	}
	
	public static<T> Set<T> transitiveClosure(
			T root, 
			final Map<T, ? extends Collection<T>> related, 
			final ContainsFn<T, Set<T>> contains)
	{
		return transitiveClosure(
				root, 
				new Function<T, Collection<T>>() {
					public Collection<T> apply(T value) {
						return Utils.mustGet(related, value);
				}},
				contains
		);
	}
	
	public static<T> Set<T> transitiveClosure(
			T root, 
			Function<T, ? extends Collection<T>> related)
	{
		return transitiveClosure(root, related, new ContainsFn<T, Set<T>>() {
					public boolean contains(Set<T> v1, T v2) {
						return v1.contains(v2);
				}});
	}
	
	public static<T> Set<T> transitiveClosure(
			T root, 
			Function<T, ? extends Collection<T>> related,
			final ContainsFn<T, Set<T>> containsChecker)
	{
		Set<T> ret = new HashSet<>();
		
		Stack<T> stack = new Stack<>();
		stack.push(root);
		while(stack.size() != 0)
		{
			T t = stack.pop();

			if(ret.contains(t))
			{
				continue; // we've already processed it
			}
			ret.add(t);
			
			Collection<T> trelated = related.apply(t);
			for(T t2 : trelated)
			{
				if(!ret.contains(t2))
				{
					stack.push(t2);
				}
			}
		}
		return ret;
	}

}
