package parser;

import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import generatedparser.ParsetoolsParser;
import generatedparser.ParsetoolsParserBaseListener;
import takmela.ast.Ast;
import takmela.ast.ByName;
import takmela.ast.Call;
import takmela.ast.CharClass;
import takmela.ast.CharClassPart;
import takmela.ast.CharRange;
import takmela.ast.CharSingle;
import takmela.ast.Expr;
import takmela.ast.LexerRule;
import takmela.ast.Plus;
import takmela.ast.Question;
import takmela.ast.RExpr;
import takmela.ast.Rule;
import takmela.ast.Star;
import takmela.ast.Str;
import takmela.ast.Terminal;
import takmela.ast.Tokenz;

public class ParsetoolsParserTreeListener extends ParsetoolsParserBaseListener
{
	private ParsetoolsParserTreeListenerHelper __helper;
	public String __compilationUnit;

	public ParsetoolsParserTreeListener(ParsetoolsParserTreeListenerHelper __helper, String compilationUnit)
	{
		this.__helper = __helper;
		this.__compilationUnit = compilationUnit;
	}

	private ParseTreeProperty<java.util.List<String>> within_part = new ParseTreeProperty<>();
	private ParseTreeProperty<CharClassPart> charClassPart = new ParseTreeProperty<>();
	public java.util.List<Rule> rules = new java.util.ArrayList<>();
	private ParseTreeProperty<Expr> expr = new ParseTreeProperty<>();
	private ParseTreeProperty<RExpr> rexpr = new ParseTreeProperty<>();
	private ParseTreeProperty<java.util.List<String>> pops_part = new ParseTreeProperty<>();
	public java.util.List<LexerRule> lexer_rules = new java.util.ArrayList<>();
	private ParseTreeProperty<java.util.List<String>> pushes_part = new ParseTreeProperty<>();
	public final java.util.Map<takmela.ast.Ast, Token> firstToken = new java.util.HashMap<>();;
	public final java.util.Map<takmela.ast.Ast, Token> lastToken = new java.util.HashMap<>();

	void setBoundaryTokens(Ast ast, ParserRuleContext ctx)
	{
		this.firstToken.put(ast, ctx.getStart());
		this.lastToken.put(ast, ctx.getStop());
	}

	@Override public void exitSingleCharClassPart(ParsetoolsParser.SingleCharClassPartContext ctx)
	{
		this.charClassPart.put(ctx, this.charClassPart.get(ctx.singleCh()));
	}

	@Override public void exitSeq(ParsetoolsParser.SeqContext ctx)
	{
		List<Expr> expr3 = new ArrayList<>();
		for (int i = 0; i < ctx.piece().size(); ++i)
		{
			expr3.add(this.expr.get(ctx.piece(i)));
		}
		this.expr.put(ctx, __helper.flattenSeq(expr3));
	}

	@Override public void exitPiecePlus(ParsetoolsParser.PiecePlusContext ctx)
	{
		Plus __t14 = new Plus(this.rexpr.get(ctx.rxpiece()));
		setBoundaryTokens(__t14, ctx);
		this.rexpr.put(ctx, __t14);
	}

	@Override public void exitJustSeq(ParsetoolsParser.JustSeqContext ctx)
	{
		this.rexpr.put(ctx, this.rexpr.get(ctx.rx_seq()));
	}

	@Override public void exitPops_part(ParsetoolsParser.Pops_partContext ctx)
	{
		List<String> IDCap10 = new ArrayList<>();
		for (int i = 0; i < ctx.IDCap().size(); ++i)
		{
			IDCap10.add(ctx.IDCap().get(i).getText());
		}
		this.pops_part.put(ctx, IDCap10);
	}

	@Override public void exitSeqq(ParsetoolsParser.SeqqContext ctx)
	{
		this.rexpr.put(ctx, __helper.flattenSeq(this.rexpr.get(ctx.rx_seq()), this.rexpr.get(ctx.rxpiece())));
	}

	@Override public void exitPieceChar(ParsetoolsParser.PieceCharContext ctx)
	{
		this.rexpr.put(ctx, this.rexpr.get(ctx.charClass()));
	}

	@Override public void exitWithin_part(ParsetoolsParser.Within_partContext ctx)
	{
		List<String> IDCap8 = new ArrayList<>();
		for (int i = 0; i < ctx.IDCap().size(); ++i)
		{
			IDCap8.add(ctx.IDCap().get(i).getText());
		}
		this.within_part.put(ctx, IDCap8);
	}

	@Override public void exitPieceAsterisk(ParsetoolsParser.PieceAsteriskContext ctx)
	{
		Star __t13 = new Star(this.rexpr.get(ctx.rxpiece()));
		setBoundaryTokens(__t13, ctx);
		this.rexpr.put(ctx, __t13);
	}

	@Override public void exitPieceQuestion(ParsetoolsParser.PieceQuestionContext ctx)
	{
		Question __t15 = new Question(this.rexpr.get(ctx.rxpiece()));
		setBoundaryTokens(__t15, ctx);
		this.rexpr.put(ctx, __t15);
	}

	@Override public void exitRangeCharClassPart(ParsetoolsParser.RangeCharClassPartContext ctx)
	{
		this.charClassPart.put(ctx, this.charClassPart.get(ctx.rangeCh()));
	}

	@Override public void exitSingleCh(ParsetoolsParser.SingleChContext ctx)
	{
		CharSingle __t19 = new CharSingle(__helper.singleChar(ctx.getChild(0).getText()));
		setBoundaryTokens(__t19, ctx);
		this.charClassPart.put(ctx, __t19);
	}

	@Override public void exitOring(ParsetoolsParser.OringContext ctx)
	{
		this.rexpr.put(ctx, __helper.flattenOring(this.rexpr.get(ctx.rx()), this.rexpr.get(ctx.rx_seq())));
	}

	@Override public void exitCharClass(ParsetoolsParser.CharClassContext ctx)
	{
		List<CharClassPart> charClassPart16 = new ArrayList<>();
		for (int i = 0; i < ctx.charClassPart().size(); ++i)
		{
			charClassPart16.add(this.charClassPart.get(ctx.charClassPart(i)));
		}
		CharClass __t17 = new CharClass(charClassPart16);
		setBoundaryTokens(__t17, ctx);
		this.rexpr.put(ctx, __t17);
	}

	@Override public void exitPieceParened(ParsetoolsParser.PieceParenedContext ctx)
	{
		this.rexpr.put(ctx, this.rexpr.get(ctx.rx()));
	}

	@Override public void exitPieceToken(ParsetoolsParser.PieceTokenContext ctx)
	{
		Tokenz __t5 = new Tokenz(ctx.IDCap().getText());
		setBoundaryTokens(__t5, ctx);
		this.expr.put(ctx, __t5);
	}

	@Override public void exitGrammar_rule(ParsetoolsParser.Grammar_ruleContext ctx)
	{
		List<Expr> expr0 = new ArrayList<>();
		for (int i = 0; i < ctx.seq().size(); ++i)
		{
			expr0.add(this.expr.get(ctx.seq(i)));
		}
		List<String> LABEL1 = new ArrayList<>();
		for (int i = 0; i < ctx.LABEL().size(); ++i)
		{
			LABEL1.add(ctx.LABEL().get(i).getText());
		}
		Rule __t2 = new Rule(ctx.IDSmall().getText(), __helper.makeLst(expr0), __helper.stripHashes(LABEL1));
		setBoundaryTokens(__t2, ctx);
		this.rules.add(__t2);
	}

	@Override public void exitJustPiece(ParsetoolsParser.JustPieceContext ctx)
	{
		this.rexpr.put(ctx, this.rexpr.get(ctx.rxpiece()));
	}

	@Override public void exitPieceCall(ParsetoolsParser.PieceCallContext ctx)
	{
		Call __t6 = new Call(ctx.IDSmall().getText());
		setBoundaryTokens(__t6, ctx);
		this.expr.put(ctx, __t6);
	}

	@Override public void exitPieceString(ParsetoolsParser.PieceStringContext ctx)
	{
		Str __t11 = new Str(__helper.stripQuotes(ctx.STRING().getText()));
		setBoundaryTokens(__t11, ctx);
		this.rexpr.put(ctx, __t11);
	}

	@Override public void exitRangeCh(ParsetoolsParser.RangeChContext ctx)
	{
		CharRange __t18 = new CharRange(__helper.singleChar(ctx.getChild(0).getText()),
				__helper.singleChar(ctx.getChild(2).getText()));
		setBoundaryTokens(__t18, ctx);
		this.charClassPart.put(ctx, __t18);
	}

	@Override public void exitLexer_rule(ParsetoolsParser.Lexer_ruleContext ctx)
	{
		LexerRule __t7 = new LexerRule(ctx.IDCap(0).getText(), this.within_part.get(ctx.within_part()),
				this.pushes_part.get(ctx.pushes_part()), this.pops_part.get(ctx.pops_part()), null,
				ctx.KW_SKIP() != null, this.rexpr.get(ctx.rx()));
		setBoundaryTokens(__t7, ctx);
		this.lexer_rules.add(__t7);
	}

	@Override public void exitPieceTerminal(ParsetoolsParser.PieceTerminalContext ctx)
	{
		Terminal __t4 = new Terminal(__helper.stripQuotes(ctx.STRING().getText()));
		setBoundaryTokens(__t4, ctx);
		this.expr.put(ctx, __t4);
	}

	@Override public void exitPiecePredefined(ParsetoolsParser.PiecePredefinedContext ctx)
	{
		ByName __t12 = new ByName(ctx.IDCap().getText());
		setBoundaryTokens(__t12, ctx);
		this.rexpr.put(ctx, __t12);
	}

	@Override public void exitPushes_part(ParsetoolsParser.Pushes_partContext ctx)
	{
		List<String> IDCap9 = new ArrayList<>();
		for (int i = 0; i < ctx.IDCap().size(); ++i)
		{
			IDCap9.add(ctx.IDCap().get(i).getText());
		}
		this.pushes_part.put(ctx, IDCap9);
	}
}
