package takmela.engine;

import java.util.List;

import takmela.tree.Tree;
import utils.Utils;

public class Success
{
	public int InputPosNow;
	public List<Tree> Trees;

	public Success(int pos, Tree tree)
	{
		InputPosNow = pos;
		Trees = Utils.list(tree);
	}

	public String toString()
	{
		return String.format("pos: %s, trees: %s", InputPosNow, Trees);
	}
}
