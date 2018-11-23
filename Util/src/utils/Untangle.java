package utils;

import java.util.HashSet;
import java.util.Set;

public class Untangle<T>
{
	// Each Pair<T,T> is an inclusive [a-b] range
	public Set<Pair<T, T>> onlyA = new HashSet<>();
	public Pair<T,T> common;
	public Set<Pair<T, T>> onlyB = new HashSet<>();
}
