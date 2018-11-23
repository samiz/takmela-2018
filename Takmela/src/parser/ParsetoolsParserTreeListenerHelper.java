package parser;

import java.util.ArrayList;
import java.util.List;

import takmela.ast.Expr;
import takmela.ast.Oring;
import takmela.ast.RExpr;
import takmela.ast.RXSeq;
import takmela.ast.Seq;
import utils.LLst;
import utils.Utils;

public class ParsetoolsParserTreeListenerHelper
{

	public Expr flattenSeq(List<Expr> seq)
	{
		/*
		if (seq.size() == 1)
		{
			return seq.get(0);
		}
		*/
		return new Seq(seq);
	}

	public String stripQuotes(String text)
	{
		return text.substring(1, text.length() - 1);
	}

	public List<LLst<Expr>> makeLst(List<Expr> _seqs)
	{
		List<LLst<Expr>> seqs = new ArrayList<>();
		for (Expr _s : _seqs)
		{
			Seq _seq = (Seq) _s;
			LLst<Expr> seq = LLst.fromList(_seq.Items);
			seqs.add(seq);
		}
		return seqs;
	}

	public List<String> stripHashes(List<String> labels)
	{
		return Utils.map(labels, (s) -> s.substring(1));
	}

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
		if (e1 instanceof Seq)
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
}
