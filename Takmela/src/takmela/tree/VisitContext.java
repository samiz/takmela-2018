package takmela.tree;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class VisitContext
{
	private final Tree tree;

	public VisitContext(Tree tree)
	{
		this.tree = tree;
	}

	public void enterTree()
	{
	}

	public void exitTree()
	{
	}

	public <T extends VisitContext> T __context(String label, Class<? extends T> klass)
	{
		for (Node _t : tree.Children)
		{
			if (_t instanceof Tree)
			{
				Tree t = (Tree) _t;
				if (t.Label.equals(label))
				{
					try
					{
						return klass.getConstructor(Tree.class).newInstance(t);
					}
					catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException e)
					{
						e.printStackTrace();
						throw new RuntimeException("Cannot create context " + label, e);
					}
				}
			}
		}
		throw new RuntimeException("Cannot create context " + label);
	}

	public <T extends VisitContext> List<T> __contexts(String label, Class<? extends T> klass)
	{
		List<T> ret = new ArrayList<>();
		for (Node _t : tree.Children)
		{
			if (_t instanceof Tree)
			{
				Tree t = (Tree) _t;
				if (t.Label.equals(label))
				{
					try
					{
						ret.add(klass.getConstructor(Tree.class).newInstance(t));
					}
					catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		return ret;
	}

	public takmela.lexer.lexer.Token __terminal(int id)
	{
		for (Node _t : tree.Children)
		{
			if (_t instanceof Token)
			{
				Token t = (Token) _t;
				if (t.Token.id() == id)
				{
					return t.Token;
				}
			}
		}
		throw new RuntimeException("Didn't find token: " + id);
	}

	public List<takmela.lexer.lexer.Token> __tokens(int id)
	{
		List<takmela.lexer.lexer.Token> ret = new ArrayList<>();
		for (Node _t : tree.Children)
		{
			if (_t instanceof Token)
			{
				Token t = (Token) _t;
				if (t.Token.id() == id)
				{
					ret.add(t.Token);
				}
			}
		}
		return ret;
	}
}
