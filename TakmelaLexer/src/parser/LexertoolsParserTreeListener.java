package parser;

import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import takmela.lexer.ast.Ast;
import takmela.lexer.ast.ByName;
import takmela.lexer.ast.CharClass;
import takmela.lexer.ast.CharClassPart;
import takmela.lexer.ast.CharRange;
import takmela.lexer.ast.CharSingle;
import takmela.lexer.ast.LexerRule;
import takmela.lexer.ast.Plus;
import takmela.lexer.ast.Question;
import takmela.lexer.ast.RExpr;
import takmela.lexer.ast.Star;
import takmela.lexer.ast.Str;
import generatedparser.LexertoolsParser;
import generatedparser.LexertoolsParserBaseListener;

public class LexertoolsParserTreeListener extends LexertoolsParserBaseListener
{
	private LexertoolsParserTreeListenerHelper __helper;
	public String __compilationUnit;

	public LexertoolsParserTreeListener(LexertoolsParserTreeListenerHelper __helper, String compilationUnit)
	{
		this.__helper = __helper;
		this.__compilationUnit = compilationUnit;
	}

	private ParseTreeProperty<java.util.List<String>> within_part = new ParseTreeProperty<>();
	private ParseTreeProperty<CharClassPart> charClassPart = new ParseTreeProperty<>();
	public java.util.List<LexerRule> rules = new java.util.ArrayList<>();
	private ParseTreeProperty<RExpr> rexpr = new ParseTreeProperty<>();
	private ParseTreeProperty<java.util.List<String>> pops_part = new ParseTreeProperty<>();
	private ParseTreeProperty<java.util.List<String>> pushes_part = new ParseTreeProperty<>();
	public final java.util.Map<takmela.lexer.ast.Ast, Token> firstToken = new java.util.HashMap<>();;
	public final java.util.Map<takmela.lexer.ast.Ast, Token> lastToken = new java.util.HashMap<>();

	void setBoundaryTokens(Ast ast, ParserRuleContext ctx)
	{
		this.firstToken.put(ast, ctx.getStart());
		this.lastToken.put(ast, ctx.getStop());
	}

	@Override public void exitPiecePlus(LexertoolsParser.PiecePlusContext ctx)
	{
		Plus __t7 = new Plus(this.rexpr.get(ctx.rxpiece()));
		setBoundaryTokens(__t7, ctx);
		this.rexpr.put(ctx, __t7);
	}

	@Override public void exitLexer_rule(LexertoolsParser.Lexer_ruleContext ctx)
	{
		LexerRule __t0 = new LexerRule(ctx.IDCap(0).getText(), this.within_part.get(ctx.within_part()),
				this.pushes_part.get(ctx.pushes_part()), this.pops_part.get(ctx.pops_part()), null,
				ctx.KW_SKIP() != null, this.rexpr.get(ctx.rx()));
		setBoundaryTokens(__t0, ctx);
		this.rules.add(__t0);
	}

	@Override public void exitPieceChar(LexertoolsParser.PieceCharContext ctx)
	{
		this.rexpr.put(ctx, this.rexpr.get(ctx.charClass()));
	}

	@Override public void exitWithin_part(LexertoolsParser.Within_partContext ctx)
	{
		List<String> IDCap1 = new ArrayList<>();
		for (int i = 0; i < ctx.IDCap().size(); ++i)
		{
			IDCap1.add(ctx.IDCap().get(i).getText());
		}
		this.within_part.put(ctx, IDCap1);
	}

	@Override public void exitPieceQuestion(LexertoolsParser.PieceQuestionContext ctx)
	{
		Question __t8 = new Question(this.rexpr.get(ctx.rxpiece()));
		setBoundaryTokens(__t8, ctx);
		this.rexpr.put(ctx, __t8);
	}

	@Override public void exitJustPiece(LexertoolsParser.JustPieceContext ctx)
	{
		this.rexpr.put(ctx, this.rexpr.get(ctx.rxpiece()));
	}

	@Override public void exitSingleCharClassPart(LexertoolsParser.SingleCharClassPartContext ctx)
	{
		this.charClassPart.put(ctx, this.charClassPart.get(ctx.singleCh()));
	}

	@Override public void exitPieceAsterisk(LexertoolsParser.PieceAsteriskContext ctx)
	{
		Star __t6 = new Star(this.rexpr.get(ctx.rxpiece()));
		setBoundaryTokens(__t6, ctx);
		this.rexpr.put(ctx, __t6);
	}

	@Override public void exitRangeCharClassPart(LexertoolsParser.RangeCharClassPartContext ctx)
	{
		this.charClassPart.put(ctx, this.charClassPart.get(ctx.rangeCh()));
	}

	@Override public void exitRangeCh(LexertoolsParser.RangeChContext ctx)
	{
		CharRange __t11 = new CharRange(__helper.singleChar(ctx.getChild(0).getText()),
				__helper.singleChar(ctx.getChild(2).getText()));
		setBoundaryTokens(__t11, ctx);
		this.charClassPart.put(ctx, __t11);
	}

	@Override public void exitPieceParened(LexertoolsParser.PieceParenedContext ctx)
	{
		this.rexpr.put(ctx, this.rexpr.get(ctx.rx()));
	}

	@Override public void exitSingleCh(LexertoolsParser.SingleChContext ctx)
	{
		CharSingle __t12 = new CharSingle(__helper.singleChar(ctx.getChild(0).getText()));
		setBoundaryTokens(__t12, ctx);
		this.charClassPart.put(ctx, __t12);
	}

	@Override public void exitPiecePredefined(LexertoolsParser.PiecePredefinedContext ctx)
	{
		ByName __t5 = new ByName(ctx.IDCap().getText());
		setBoundaryTokens(__t5, ctx);
		this.rexpr.put(ctx, __t5);
	}

	@Override public void exitOring(LexertoolsParser.OringContext ctx)
	{
		this.rexpr.put(ctx, __helper.flattenOring(this.rexpr.get(ctx.rx()), this.rexpr.get(ctx.rx_seq())));
	}

	@Override public void exitCharClass(LexertoolsParser.CharClassContext ctx)
	{
		List<CharClassPart> charClassPart9 = new ArrayList<>();
		for (int i = 0; i < ctx.charClassPart().size(); ++i)
		{
			charClassPart9.add(this.charClassPart.get(ctx.charClassPart(i)));
		}
		CharClass __t10 = new CharClass(charClassPart9);
		setBoundaryTokens(__t10, ctx);
		this.rexpr.put(ctx, __t10);
	}

	@Override public void exitJustSeq(LexertoolsParser.JustSeqContext ctx)
	{
		this.rexpr.put(ctx, this.rexpr.get(ctx.rx_seq()));
	}

	@Override public void exitPops_part(LexertoolsParser.Pops_partContext ctx)
	{
		List<String> IDCap3 = new ArrayList<>();
		for (int i = 0; i < ctx.IDCap().size(); ++i)
		{
			IDCap3.add(ctx.IDCap().get(i).getText());
		}
		this.pops_part.put(ctx, IDCap3);
	}

	@Override public void exitSeqq(LexertoolsParser.SeqqContext ctx)
	{
		this.rexpr.put(ctx, __helper.flattenSeq(this.rexpr.get(ctx.rx_seq()), this.rexpr.get(ctx.rxpiece())));
	}

	@Override public void exitPieceString(LexertoolsParser.PieceStringContext ctx)
	{
		Str __t4 = new Str(__helper.stripQuotes(ctx.STRING().getText()));
		setBoundaryTokens(__t4, ctx);
		this.rexpr.put(ctx, __t4);
	}

	@Override public void exitPushes_part(LexertoolsParser.Pushes_partContext ctx)
	{
		List<String> IDCap2 = new ArrayList<>();
		for (int i = 0; i < ctx.IDCap().size(); ++i)
		{
			IDCap2.add(ctx.IDCap().get(i).getText());
		}
		this.pushes_part.put(ctx, IDCap2);
	}
}
