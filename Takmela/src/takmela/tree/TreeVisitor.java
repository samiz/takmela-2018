package takmela.tree;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class TreeVisitor<ListenerT extends TreeListener>
{
	private Map<String, Class<?>> contextMap;

	public TreeVisitor(Map<String, Class<?>> contextMap)
	{
		this.contextMap = contextMap;
	}

	public void visit(Tree tree)
	{
		try
		{
			VisitContext c = (VisitContext) contextMap.get(tree.Label).getConstructor(Tree.class).newInstance(tree);
			c.enterTree();
			for (Node child : tree.Children)
			{
				if (child instanceof Tree)
				{
					visit((Tree) child);
				}
			}
			c.exitTree();
		}
		catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e)
		{
			return;
		}
	}
}
