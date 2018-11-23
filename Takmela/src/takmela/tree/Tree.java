package takmela.tree;

import java.util.ArrayList;
import java.util.List;

import utils.Utils;

public class Tree implements Node
{
	public final String Label;
	public final int Choice;
	public final List<Node> Children;

	public Tree(String label, int choice, List<Node> children)
	{
		Label = label;
		Choice = choice;
		Children = children;
	}

	public Tree(String label, int choice)
	{
		Label = label;
		Choice = choice;
		Children = new ArrayList<>();
	}

	public Tree appendChild(Node child)
	{
		List<Node> lst2 = new ArrayList<>();
		lst2.addAll(Children);
		lst2.add(child);
		return new Tree(Label, Choice, lst2);
	}

	public String toString()
	{
		return String.format("%s(%s)", Label, Utils.join(Children, ", "));
	}
}
