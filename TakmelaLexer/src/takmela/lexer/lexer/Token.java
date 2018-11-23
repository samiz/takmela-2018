package takmela.lexer.lexer;

import utils.Utils;

public class Token
{
	private final int _id;
	private final String _text;
	private final int _line, _col;
	private final boolean _skip;

	public Token(int _id, String _text, int _line, int _col, boolean _skip)
	{
		this._id = _id;
		this._text = _text;
		this._line = _line;
		this._col = _col;
		this._skip = _skip;
	}

	public String text()
	{
		return _text;
	}

	public int id()
	{
		return _id;
	}

	public int line()
	{
		return _line;
	}

	public int col()
	{
		return _col;
	}

	public boolean skip()
	{
		return _skip;
	}

	public String toString()
	{
		return String.format("<%s, %s%s>", _id, Utils.left(_text, 5), _text.length() > 5 ? ".." : "");
	}
}
