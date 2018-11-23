package parser;

import java.util.ArrayList;
import java.util.List;

import takmela.lexer.ast.Oring;
import takmela.lexer.ast.RExpr;
import takmela.lexer.ast.RXSeq;

public class LexertoolsParserTreeListenerHelper
{
	public RExpr flattenOring(RExpr e1, RExpr e2)
	{
		List<RExpr> items = new ArrayList<>();
		if (e1 instanceof Oring)
		{
			Oring orr = (Oring) e1;
			items.addAll(orr.Exprs);
		}
		else
		{
			items.add(e1);
		}
		items.add(e2);
		return new Oring(items);
	}

	public RExpr flattenSeq(RExpr e1, RExpr e2)
	{
		List<RExpr> items = new ArrayList<>();
		if (e1 instanceof RXSeq)
		{
			RXSeq orr = (RXSeq) e1;
			items.addAll(orr.Exprs);
		}
		else
		{
			items.add(e1);
		}
		items.add(e2);
		return new RXSeq(items);
	}

	public char singleChar(String s)
	{
		switch(s)
		{
			case "\\r": return '\r';
			case "\\n": return '\n';
			case "\\t": return '\t';
			case "\\\"": return '"';
			case "\\'": return '\'';
			case "\\-": return '-';
			default: return s.charAt(0);
		}
	}

	public String stripQuotes(String s)
	{
		return s.substring(1, s.length() - 1);
	}
}
