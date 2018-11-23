// Generated from Lexertools.g4 by ANTLR 4.5
package generatedparser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class Lexertools extends Parser
{
	static
	{
		RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION);
	}

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
	public static final int KW_WITHIN = 1, KW_PUSHES = 2, KW_POPS = 3, KW_CLASS = 4, ID = 5, INT = 6, STRING = 7,
			COMMA = 8, OPAREN = 9, CPAREN = 10, DOLLAR = 11, PLUS = 12, STAR = 13, BAR = 14, COLON = 15, SEMI = 16,
			COMMENT2 = 17, COMMENT = 18, WS = 19, START_CHARCLASS = 20, END_CHARCLASS = 21, CHAR = 22, DASH = 23;
	public static final int RULE_program = 0, RULE_lexer_rule = 1, RULE_within_part = 2, RULE_pushes_part = 3,
			RULE_pops_part = 4, RULE_rx = 5, RULE_seq = 6, RULE_rxpiece = 7, RULE_charClass = 8, RULE_rangeCh = 9,
			RULE_singleCh = 10;
	public static final String[] ruleNames = { "program", "lexer_rule", "within_part", "pushes_part", "pops_part", "rx",
			"seq", "rxpiece", "charClass", "rangeCh", "singleCh" };

	private static final String[] _LITERAL_NAMES = { null, "'within'", "'pushes'", "'pops'", "'class'", null, null,
			null, "','", "'('", "')'", "'$'", "'+'", "'*'", "'|'", "':'", "';'", null, null, null, "'['", "']'", null,
			"'-'" };
	private static final String[] _SYMBOLIC_NAMES = { null, "KW_WITHIN", "KW_PUSHES", "KW_POPS", "KW_CLASS", "ID",
			"INT", "STRING", "COMMA", "OPAREN", "CPAREN", "DOLLAR", "PLUS", "STAR", "BAR", "COLON", "SEMI", "COMMENT2",
			"COMMENT", "WS", "START_CHARCLASS", "END_CHARCLASS", "CHAR", "DASH" };
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static
	{
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++)
		{
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null)
			{
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null)
			{
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override @Deprecated public String[] getTokenNames()
	{
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary()
	{
		return VOCABULARY;
	}

	@Override public String getGrammarFileName()
	{
		return "Lexertools.g4";
	}

	@Override public String[] getRuleNames()
	{
		return ruleNames;
	}

	@Override public String getSerializedATN()
	{
		return _serializedATN;
	}

	@Override public ATN getATN()
	{
		return _ATN;
	}

	public Lexertools(TokenStream input)
	{
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext
	{
		public List<Lexer_ruleContext> lexer_rule()
		{
			return getRuleContexts(Lexer_ruleContext.class);
		}

		public Lexer_ruleContext lexer_rule(int i)
		{
			return getRuleContext(Lexer_ruleContext.class, i);
		}

		public ProgramContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		@Override public int getRuleIndex()
		{
			return RULE_program;
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterProgram(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException
	{
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == ID)
				{
					{
						{
							setState(22);
							lexer_rule();
						}
					}
					setState(27);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public static class Lexer_ruleContext extends ParserRuleContext
	{
		public List<TerminalNode> ID()
		{
			return getTokens(Lexertools.ID);
		}

		public TerminalNode ID(int i)
		{
			return getToken(Lexertools.ID, i);
		}

		public Within_partContext within_part()
		{
			return getRuleContext(Within_partContext.class, 0);
		}

		public Pushes_partContext pushes_part()
		{
			return getRuleContext(Pushes_partContext.class, 0);
		}

		public Pops_partContext pops_part()
		{
			return getRuleContext(Pops_partContext.class, 0);
		}

		public TerminalNode COLON()
		{
			return getToken(Lexertools.COLON, 0);
		}

		public RxContext rx()
		{
			return getRuleContext(RxContext.class, 0);
		}

		public TerminalNode SEMI()
		{
			return getToken(Lexertools.SEMI, 0);
		}

		public TerminalNode KW_CLASS()
		{
			return getToken(Lexertools.KW_CLASS, 0);
		}

		public Lexer_ruleContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		@Override public int getRuleIndex()
		{
			return RULE_lexer_rule;
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterLexer_rule(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitLexer_rule(this);
		}
	}

	public final Lexer_ruleContext lexer_rule() throws RecognitionException
	{
		Lexer_ruleContext _localctx = new Lexer_ruleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_lexer_rule);
		int _la;
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(28);
				match(ID);
				setState(29);
				within_part();
				setState(30);
				pushes_part();
				setState(31);
				pops_part();
				setState(34);
				_la = _input.LA(1);
				if (_la == KW_CLASS)
				{
					{
						setState(32);
						match(KW_CLASS);
						setState(33);
						match(ID);
					}
				}

				setState(36);
				match(COLON);
				setState(37);
				rx(0);
				setState(38);
				match(SEMI);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public static class Within_partContext extends ParserRuleContext
	{
		public TerminalNode KW_WITHIN()
		{
			return getToken(Lexertools.KW_WITHIN, 0);
		}

		public TerminalNode OPAREN()
		{
			return getToken(Lexertools.OPAREN, 0);
		}

		public List<TerminalNode> ID()
		{
			return getTokens(Lexertools.ID);
		}

		public TerminalNode ID(int i)
		{
			return getToken(Lexertools.ID, i);
		}

		public TerminalNode CPAREN()
		{
			return getToken(Lexertools.CPAREN, 0);
		}

		public List<TerminalNode> COMMA()
		{
			return getTokens(Lexertools.COMMA);
		}

		public TerminalNode COMMA(int i)
		{
			return getToken(Lexertools.COMMA, i);
		}

		public Within_partContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		@Override public int getRuleIndex()
		{
			return RULE_within_part;
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterWithin_part(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitWithin_part(this);
		}
	}

	public final Within_partContext within_part() throws RecognitionException
	{
		Within_partContext _localctx = new Within_partContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_within_part);
		int _la;
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(51);
				_la = _input.LA(1);
				if (_la == KW_WITHIN)
				{
					{
						setState(40);
						match(KW_WITHIN);
						setState(41);
						match(OPAREN);
						setState(42);
						match(ID);
						setState(47);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la == COMMA)
						{
							{
								{
									setState(43);
									match(COMMA);
									setState(44);
									match(ID);
								}
							}
							setState(49);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(50);
						match(CPAREN);
					}
				}

			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public static class Pushes_partContext extends ParserRuleContext
	{
		public TerminalNode KW_PUSHES()
		{
			return getToken(Lexertools.KW_PUSHES, 0);
		}

		public TerminalNode OPAREN()
		{
			return getToken(Lexertools.OPAREN, 0);
		}

		public List<TerminalNode> ID()
		{
			return getTokens(Lexertools.ID);
		}

		public TerminalNode ID(int i)
		{
			return getToken(Lexertools.ID, i);
		}

		public TerminalNode CPAREN()
		{
			return getToken(Lexertools.CPAREN, 0);
		}

		public List<TerminalNode> COMMA()
		{
			return getTokens(Lexertools.COMMA);
		}

		public TerminalNode COMMA(int i)
		{
			return getToken(Lexertools.COMMA, i);
		}

		public Pushes_partContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		@Override public int getRuleIndex()
		{
			return RULE_pushes_part;
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterPushes_part(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitPushes_part(this);
		}
	}

	public final Pushes_partContext pushes_part() throws RecognitionException
	{
		Pushes_partContext _localctx = new Pushes_partContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pushes_part);
		int _la;
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(64);
				_la = _input.LA(1);
				if (_la == KW_PUSHES)
				{
					{
						setState(53);
						match(KW_PUSHES);
						setState(54);
						match(OPAREN);
						setState(55);
						match(ID);
						setState(60);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la == COMMA)
						{
							{
								{
									setState(56);
									match(COMMA);
									setState(57);
									match(ID);
								}
							}
							setState(62);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(63);
						match(CPAREN);
					}
				}

			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public static class Pops_partContext extends ParserRuleContext
	{
		public TerminalNode KW_POPS()
		{
			return getToken(Lexertools.KW_POPS, 0);
		}

		public TerminalNode OPAREN()
		{
			return getToken(Lexertools.OPAREN, 0);
		}

		public List<TerminalNode> ID()
		{
			return getTokens(Lexertools.ID);
		}

		public TerminalNode ID(int i)
		{
			return getToken(Lexertools.ID, i);
		}

		public TerminalNode CPAREN()
		{
			return getToken(Lexertools.CPAREN, 0);
		}

		public List<TerminalNode> COMMA()
		{
			return getTokens(Lexertools.COMMA);
		}

		public TerminalNode COMMA(int i)
		{
			return getToken(Lexertools.COMMA, i);
		}

		public Pops_partContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		@Override public int getRuleIndex()
		{
			return RULE_pops_part;
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterPops_part(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitPops_part(this);
		}
	}

	public final Pops_partContext pops_part() throws RecognitionException
	{
		Pops_partContext _localctx = new Pops_partContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pops_part);
		int _la;
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(77);
				_la = _input.LA(1);
				if (_la == KW_POPS)
				{
					{
						setState(66);
						match(KW_POPS);
						setState(67);
						match(OPAREN);
						setState(68);
						match(ID);
						setState(73);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la == COMMA)
						{
							{
								{
									setState(69);
									match(COMMA);
									setState(70);
									match(ID);
								}
							}
							setState(75);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(76);
						match(CPAREN);
					}
				}

			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public static class RxContext extends ParserRuleContext
	{
		public RxContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		@Override public int getRuleIndex()
		{
			return RULE_rx;
		}

		public RxContext()
		{
		}

		public void copyFrom(RxContext ctx)
		{
			super.copyFrom(ctx);
		}
	}

	public static class OringContext extends RxContext
	{
		public RxContext rx()
		{
			return getRuleContext(RxContext.class, 0);
		}

		public TerminalNode BAR()
		{
			return getToken(Lexertools.BAR, 0);
		}

		public SeqContext seq()
		{
			return getRuleContext(SeqContext.class, 0);
		}

		public OringContext(RxContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterOring(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitOring(this);
		}
	}

	public static class JustSeqContext extends RxContext
	{
		public SeqContext seq()
		{
			return getRuleContext(SeqContext.class, 0);
		}

		public JustSeqContext(RxContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterJustSeq(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitJustSeq(this);
		}
	}

	public final RxContext rx() throws RecognitionException
	{
		return rx(0);
	}

	private RxContext rx(int _p) throws RecognitionException
	{
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RxContext _localctx = new RxContext(_ctx, _parentState);
		RxContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_rx, _p);
		try
		{
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				{
					_localctx = new JustSeqContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;

					setState(80);
					seq(0);
				}
				_ctx.stop = _input.LT(-1);
				setState(87);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 8, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER)
				{
					if (_alt == 1)
					{
						if (_parseListeners != null)
							triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							{
								_localctx = new OringContext(new RxContext(_parentctx, _parentState));
								pushNewRecursionContext(_localctx, _startState, RULE_rx);
								setState(82);
								if (!(precpred(_ctx, 2)))
									throw new FailedPredicateException(this, "precpred(_ctx, 2)");
								setState(83);
								match(BAR);
								setState(84);
								seq(0);
							}
						}
					}
					setState(89);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 8, _ctx);
				}
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SeqContext extends ParserRuleContext
	{
		public SeqContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		@Override public int getRuleIndex()
		{
			return RULE_seq;
		}

		public SeqContext()
		{
		}

		public void copyFrom(SeqContext ctx)
		{
			super.copyFrom(ctx);
		}
	}

	public static class SeqqContext extends SeqContext
	{
		public SeqContext seq()
		{
			return getRuleContext(SeqContext.class, 0);
		}

		public RxpieceContext rxpiece()
		{
			return getRuleContext(RxpieceContext.class, 0);
		}

		public SeqqContext(SeqContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterSeqq(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitSeqq(this);
		}
	}

	public static class JustPieceContext extends SeqContext
	{
		public RxpieceContext rxpiece()
		{
			return getRuleContext(RxpieceContext.class, 0);
		}

		public JustPieceContext(SeqContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterJustPiece(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitJustPiece(this);
		}
	}

	public final SeqContext seq() throws RecognitionException
	{
		return seq(0);
	}

	private SeqContext seq(int _p) throws RecognitionException
	{
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SeqContext _localctx = new SeqContext(_ctx, _parentState);
		SeqContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_seq, _p);
		try
		{
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				{
					_localctx = new JustPieceContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;

					setState(91);
					rxpiece(0);
				}
				_ctx.stop = _input.LT(-1);
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 9, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER)
				{
					if (_alt == 1)
					{
						if (_parseListeners != null)
							triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							{
								_localctx = new SeqqContext(new SeqContext(_parentctx, _parentState));
								pushNewRecursionContext(_localctx, _startState, RULE_seq);
								setState(93);
								if (!(precpred(_ctx, 2)))
									throw new FailedPredicateException(this, "precpred(_ctx, 2)");
								setState(94);
								rxpiece(0);
							}
						}
					}
					setState(99);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 9, _ctx);
				}
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RxpieceContext extends ParserRuleContext
	{
		public RxpieceContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		@Override public int getRuleIndex()
		{
			return RULE_rxpiece;
		}

		public RxpieceContext()
		{
		}

		public void copyFrom(RxpieceContext ctx)
		{
			super.copyFrom(ctx);
		}
	}

	public static class PiecePlusContext extends RxpieceContext
	{
		public RxpieceContext rxpiece()
		{
			return getRuleContext(RxpieceContext.class, 0);
		}

		public TerminalNode PLUS()
		{
			return getToken(Lexertools.PLUS, 0);
		}

		public PiecePlusContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterPiecePlus(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitPiecePlus(this);
		}
	}

	public static class PieceStringContext extends RxpieceContext
	{
		public TerminalNode STRING()
		{
			return getToken(Lexertools.STRING, 0);
		}

		public PieceStringContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterPieceString(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitPieceString(this);
		}
	}

	public static class PieceCharContext extends RxpieceContext
	{
		public CharClassContext charClass()
		{
			return getRuleContext(CharClassContext.class, 0);
		}

		public PieceCharContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterPieceChar(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitPieceChar(this);
		}
	}

	public static class PiecePredefinedContext extends RxpieceContext
	{
		public TerminalNode DOLLAR()
		{
			return getToken(Lexertools.DOLLAR, 0);
		}

		public TerminalNode ID()
		{
			return getToken(Lexertools.ID, 0);
		}

		public PiecePredefinedContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterPiecePredefined(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitPiecePredefined(this);
		}
	}

	public static class PieceParenedContext extends RxpieceContext
	{
		public TerminalNode OPAREN()
		{
			return getToken(Lexertools.OPAREN, 0);
		}

		public RxContext rx()
		{
			return getRuleContext(RxContext.class, 0);
		}

		public TerminalNode CPAREN()
		{
			return getToken(Lexertools.CPAREN, 0);
		}

		public PieceParenedContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterPieceParened(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitPieceParened(this);
		}
	}

	public static class PieceAsteriskContext extends RxpieceContext
	{
		public RxpieceContext rxpiece()
		{
			return getRuleContext(RxpieceContext.class, 0);
		}

		public TerminalNode STAR()
		{
			return getToken(Lexertools.STAR, 0);
		}

		public PieceAsteriskContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterPieceAsterisk(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitPieceAsterisk(this);
		}
	}

	public final RxpieceContext rxpiece() throws RecognitionException
	{
		return rxpiece(0);
	}

	private RxpieceContext rxpiece(int _p) throws RecognitionException
	{
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RxpieceContext _localctx = new RxpieceContext(_ctx, _parentState);
		RxpieceContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_rxpiece, _p);
		try
		{
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(109);
				switch (_input.LA(1)) {
				case STRING: {
					_localctx = new PieceStringContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;

					setState(101);
					match(STRING);
				}
					break;
				case START_CHARCLASS: {
					_localctx = new PieceCharContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(102);
					charClass();
				}
					break;
				case DOLLAR: {
					_localctx = new PiecePredefinedContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(103);
					match(DOLLAR);
					setState(104);
					match(ID);
				}
					break;
				case OPAREN: {
					_localctx = new PieceParenedContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(105);
					match(OPAREN);
					setState(106);
					rx(0);
					setState(107);
					match(CPAREN);
				}
					break;
				default:
					throw new NoViableAltException(this);
				}
				_ctx.stop = _input.LT(-1);
				setState(117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER)
				{
					if (_alt == 1)
					{
						if (_parseListeners != null)
							triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							setState(115);
							switch (getInterpreter().adaptivePredict(_input, 11, _ctx)) {
							case 1: {
								_localctx = new PieceAsteriskContext(new RxpieceContext(_parentctx, _parentState));
								pushNewRecursionContext(_localctx, _startState, RULE_rxpiece);
								setState(111);
								if (!(precpred(_ctx, 3)))
									throw new FailedPredicateException(this, "precpred(_ctx, 3)");
								setState(112);
								match(STAR);
							}
								break;
							case 2: {
								_localctx = new PiecePlusContext(new RxpieceContext(_parentctx, _parentState));
								pushNewRecursionContext(_localctx, _startState, RULE_rxpiece);
								setState(113);
								if (!(precpred(_ctx, 2)))
									throw new FailedPredicateException(this, "precpred(_ctx, 2)");
								setState(114);
								match(PLUS);
							}
								break;
							}
						}
					}
					setState(119);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 12, _ctx);
				}
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CharClassContext extends ParserRuleContext
	{
		public TerminalNode START_CHARCLASS()
		{
			return getToken(Lexertools.START_CHARCLASS, 0);
		}

		public TerminalNode END_CHARCLASS()
		{
			return getToken(Lexertools.END_CHARCLASS, 0);
		}

		public List<RangeChContext> rangeCh()
		{
			return getRuleContexts(RangeChContext.class);
		}

		public RangeChContext rangeCh(int i)
		{
			return getRuleContext(RangeChContext.class, i);
		}

		public List<SingleChContext> singleCh()
		{
			return getRuleContexts(SingleChContext.class);
		}

		public SingleChContext singleCh(int i)
		{
			return getRuleContext(SingleChContext.class, i);
		}

		public CharClassContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		@Override public int getRuleIndex()
		{
			return RULE_charClass;
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterCharClass(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitCharClass(this);
		}
	}

	public final CharClassContext charClass() throws RecognitionException
	{
		CharClassContext _localctx = new CharClassContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_charClass);
		int _la;
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(120);
				match(START_CHARCLASS);
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do
				{
					{
						setState(123);
						switch (getInterpreter().adaptivePredict(_input, 13, _ctx)) {
						case 1: {
							setState(121);
							rangeCh();
						}
							break;
						case 2: {
							setState(122);
							singleCh();
						}
							break;
						}
					}
					setState(125);
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while (_la == CHAR);
				setState(127);
				match(END_CHARCLASS);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public static class RangeChContext extends ParserRuleContext
	{
		public List<TerminalNode> CHAR()
		{
			return getTokens(Lexertools.CHAR);
		}

		public TerminalNode CHAR(int i)
		{
			return getToken(Lexertools.CHAR, i);
		}

		public RangeChContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		@Override public int getRuleIndex()
		{
			return RULE_rangeCh;
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterRangeCh(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitRangeCh(this);
		}
	}

	public final RangeChContext rangeCh() throws RecognitionException
	{
		RangeChContext _localctx = new RangeChContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rangeCh);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(129);
				match(CHAR);
				setState(130);
				match(DASH);
				setState(131);
				match(CHAR);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public static class SingleChContext extends ParserRuleContext
	{
		public TerminalNode CHAR()
		{
			return getToken(Lexertools.CHAR, 0);
		}

		public SingleChContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		@Override public int getRuleIndex()
		{
			return RULE_singleCh;
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).enterSingleCh(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsListener)
				((LexertoolsListener) listener).exitSingleCh(this);
		}
	}

	public final SingleChContext singleCh() throws RecognitionException
	{
		SingleChContext _localctx = new SingleChContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_singleCh);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(133);
				match(CHAR);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex)
	{
		switch (ruleIndex) {
		case 5:
			return rx_sempred((RxContext) _localctx, predIndex);
		case 6:
			return seq_sempred((SeqContext) _localctx, predIndex);
		case 7:
			return rxpiece_sempred((RxpieceContext) _localctx, predIndex);
		}
		return true;
	}

	private boolean rx_sempred(RxContext _localctx, int predIndex)
	{
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	private boolean seq_sempred(SeqContext _localctx, int predIndex)
	{
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	private boolean rxpiece_sempred(RxpieceContext _localctx, int predIndex)
	{
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN = "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31\u008a\4\2\t\2"
			+ "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"
			+ "\t\13\4\f\t\f\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\3\3\3\3\3\3\3\3\3\3\3"
			+ "\5\3%\n\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7\4\60\n\4\f\4\16\4\63\13"
			+ "\4\3\4\5\4\66\n\4\3\5\3\5\3\5\3\5\3\5\7\5=\n\5\f\5\16\5@\13\5\3\5\5\5"
			+ "C\n\5\3\6\3\6\3\6\3\6\3\6\7\6J\n\6\f\6\16\6M\13\6\3\6\5\6P\n\6\3\7\3\7"
			+ "\3\7\3\7\3\7\3\7\7\7X\n\7\f\7\16\7[\13\7\3\b\3\b\3\b\3\b\3\b\7\bb\n\b"
			+ "\f\b\16\be\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\tp\n\t\3\t\3\t\3"
			+ "\t\3\t\7\tv\n\t\f\t\16\ty\13\t\3\n\3\n\3\n\6\n~\n\n\r\n\16\n\177\3\n\3"
			+ "\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\2\5\f\16\20\r\2\4\6\b\n\f\16\20\22"
			+ "\24\26\2\2\u008f\2\33\3\2\2\2\4\36\3\2\2\2\6\65\3\2\2\2\bB\3\2\2\2\nO"
			+ "\3\2\2\2\fQ\3\2\2\2\16\\\3\2\2\2\20o\3\2\2\2\22z\3\2\2\2\24\u0083\3\2"
			+ "\2\2\26\u0087\3\2\2\2\30\32\5\4\3\2\31\30\3\2\2\2\32\35\3\2\2\2\33\31"
			+ "\3\2\2\2\33\34\3\2\2\2\34\3\3\2\2\2\35\33\3\2\2\2\36\37\7\7\2\2\37 \5"
			+ "\6\4\2 !\5\b\5\2!$\5\n\6\2\"#\7\6\2\2#%\7\7\2\2$\"\3\2\2\2$%\3\2\2\2%"
			+ "&\3\2\2\2&\'\7\21\2\2\'(\5\f\7\2()\7\22\2\2)\5\3\2\2\2*+\7\3\2\2+,\7\13"
			+ "\2\2,\61\7\7\2\2-.\7\n\2\2.\60\7\7\2\2/-\3\2\2\2\60\63\3\2\2\2\61/\3\2"
			+ "\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63\61\3\2\2\2\64\66\7\f\2\2\65*\3\2\2"
			+ "\2\65\66\3\2\2\2\66\7\3\2\2\2\678\7\4\2\289\7\13\2\29>\7\7\2\2:;\7\n\2"
			+ "\2;=\7\7\2\2<:\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2"
			+ "\2AC\7\f\2\2B\67\3\2\2\2BC\3\2\2\2C\t\3\2\2\2DE\7\5\2\2EF\7\13\2\2FK\7"
			+ "\7\2\2GH\7\n\2\2HJ\7\7\2\2IG\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3"
			+ "\2\2\2MK\3\2\2\2NP\7\f\2\2OD\3\2\2\2OP\3\2\2\2P\13\3\2\2\2QR\b\7\1\2R"
			+ "S\5\16\b\2SY\3\2\2\2TU\f\4\2\2UV\7\20\2\2VX\5\16\b\2WT\3\2\2\2X[\3\2\2"
			+ "\2YW\3\2\2\2YZ\3\2\2\2Z\r\3\2\2\2[Y\3\2\2\2\\]\b\b\1\2]^\5\20\t\2^c\3"
			+ "\2\2\2_`\f\4\2\2`b\5\20\t\2a_\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\17"
			+ "\3\2\2\2ec\3\2\2\2fg\b\t\1\2gp\7\t\2\2hp\5\22\n\2ij\7\r\2\2jp\7\7\2\2"
			+ "kl\7\13\2\2lm\5\f\7\2mn\7\f\2\2np\3\2\2\2of\3\2\2\2oh\3\2\2\2oi\3\2\2"
			+ "\2ok\3\2\2\2pw\3\2\2\2qr\f\5\2\2rv\7\17\2\2st\f\4\2\2tv\7\16\2\2uq\3\2"
			+ "\2\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\21\3\2\2\2yw\3\2\2\2z}\7"
			+ "\26\2\2{~\5\24\13\2|~\5\26\f\2}{\3\2\2\2}|\3\2\2\2~\177\3\2\2\2\177}\3"
			+ "\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\7\27\2\2\u0082"
			+ "\23\3\2\2\2\u0083\u0084\7\30\2\2\u0084\u0085\7\31\2\2\u0085\u0086\7\30"
			+ "\2\2\u0086\25\3\2\2\2\u0087\u0088\7\30\2\2\u0088\27\3\2\2\2\21\33$\61" + "\65>BKOYcouw}\177";
	public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static
	{
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++)
		{
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}