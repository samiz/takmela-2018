// Generated from LexertoolsParser.g4 by ANTLR 4.5
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
public class LexertoolsParser extends Parser
{
	static
	{
		RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION);
	}

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
	public static final int KW_WITHIN = 1, KW_PUSHES = 2, KW_POPS = 3, KW_CLASS = 4, KW_SKIP = 5, IDCap = 6, INT = 7,
			STRING = 8, COMMA = 9, OPAREN = 10, CPAREN = 11, DOLLAR = 12, PLUS = 13, STAR = 14, QUESTION = 15, BAR = 16,
			COLON = 17, SEMI = 18, COMMENT2 = 19, COMMENT = 20, WS = 21, START_CHARCLASS = 22, END_CHARCLASS = 23,
			CHAR = 24, DASH = 25;
	public static final int RULE_program = 0, RULE_lexer_rule = 1, RULE_within_part = 2, RULE_pushes_part = 3,
			RULE_pops_part = 4, RULE_rx = 5, RULE_rx_seq = 6, RULE_rxpiece = 7, RULE_charClass = 8,
			RULE_charClassPart = 9, RULE_rangeCh = 10, RULE_singleCh = 11;
	public static final String[] ruleNames = { "program", "lexer_rule", "within_part", "pushes_part", "pops_part", "rx",
			"rx_seq", "rxpiece", "charClass", "charClassPart", "rangeCh", "singleCh" };

	private static final String[] _LITERAL_NAMES = { null, "'within'", "'pushes'", "'pops'", "'class'", "'skip'", null,
			null, null, "','", "'('", "')'", "'$'", "'+'", "'*'", "'?'", "'|'", "':'", "';'", null, null, null, "'['",
			"']'", null, "'-'" };
	private static final String[] _SYMBOLIC_NAMES = { null, "KW_WITHIN", "KW_PUSHES", "KW_POPS", "KW_CLASS", "KW_SKIP",
			"IDCap", "INT", "STRING", "COMMA", "OPAREN", "CPAREN", "DOLLAR", "PLUS", "STAR", "QUESTION", "BAR", "COLON",
			"SEMI", "COMMENT2", "COMMENT", "WS", "START_CHARCLASS", "END_CHARCLASS", "CHAR", "DASH" };
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
		return "LexertoolsParser.g4";
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

	public LexertoolsParser(TokenStream input)
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
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterProgram(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitProgram(this);
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
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == IDCap)
				{
					{
						{
							setState(24);
							lexer_rule();
						}
					}
					setState(29);
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
		public List<TerminalNode> IDCap()
		{
			return getTokens(LexertoolsParser.IDCap);
		}

		public TerminalNode IDCap(int i)
		{
			return getToken(LexertoolsParser.IDCap, i);
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
			return getToken(LexertoolsParser.COLON, 0);
		}

		public RxContext rx()
		{
			return getRuleContext(RxContext.class, 0);
		}

		public TerminalNode SEMI()
		{
			return getToken(LexertoolsParser.SEMI, 0);
		}

		public TerminalNode KW_CLASS()
		{
			return getToken(LexertoolsParser.KW_CLASS, 0);
		}

		public TerminalNode KW_SKIP()
		{
			return getToken(LexertoolsParser.KW_SKIP, 0);
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
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterLexer_rule(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitLexer_rule(this);
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
				setState(30);
				match(IDCap);
				setState(31);
				within_part();
				setState(32);
				pushes_part();
				setState(33);
				pops_part();
				setState(36);
				_la = _input.LA(1);
				if (_la == KW_CLASS)
				{
					{
						setState(34);
						match(KW_CLASS);
						setState(35);
						match(IDCap);
					}
				}

				setState(39);
				_la = _input.LA(1);
				if (_la == KW_SKIP)
				{
					{
						setState(38);
						match(KW_SKIP);
					}
				}

				setState(41);
				match(COLON);
				setState(42);
				rx(0);
				setState(43);
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
			return getToken(LexertoolsParser.KW_WITHIN, 0);
		}

		public TerminalNode OPAREN()
		{
			return getToken(LexertoolsParser.OPAREN, 0);
		}

		public List<TerminalNode> IDCap()
		{
			return getTokens(LexertoolsParser.IDCap);
		}

		public TerminalNode IDCap(int i)
		{
			return getToken(LexertoolsParser.IDCap, i);
		}

		public TerminalNode CPAREN()
		{
			return getToken(LexertoolsParser.CPAREN, 0);
		}

		public List<TerminalNode> COMMA()
		{
			return getTokens(LexertoolsParser.COMMA);
		}

		public TerminalNode COMMA(int i)
		{
			return getToken(LexertoolsParser.COMMA, i);
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
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterWithin_part(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitWithin_part(this);
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
				setState(56);
				_la = _input.LA(1);
				if (_la == KW_WITHIN)
				{
					{
						setState(45);
						match(KW_WITHIN);
						setState(46);
						match(OPAREN);
						setState(47);
						match(IDCap);
						setState(52);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la == COMMA)
						{
							{
								{
									setState(48);
									match(COMMA);
									setState(49);
									match(IDCap);
								}
							}
							setState(54);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(55);
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
			return getToken(LexertoolsParser.KW_PUSHES, 0);
		}

		public TerminalNode OPAREN()
		{
			return getToken(LexertoolsParser.OPAREN, 0);
		}

		public List<TerminalNode> IDCap()
		{
			return getTokens(LexertoolsParser.IDCap);
		}

		public TerminalNode IDCap(int i)
		{
			return getToken(LexertoolsParser.IDCap, i);
		}

		public TerminalNode CPAREN()
		{
			return getToken(LexertoolsParser.CPAREN, 0);
		}

		public List<TerminalNode> COMMA()
		{
			return getTokens(LexertoolsParser.COMMA);
		}

		public TerminalNode COMMA(int i)
		{
			return getToken(LexertoolsParser.COMMA, i);
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
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterPushes_part(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitPushes_part(this);
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
				setState(69);
				_la = _input.LA(1);
				if (_la == KW_PUSHES)
				{
					{
						setState(58);
						match(KW_PUSHES);
						setState(59);
						match(OPAREN);
						setState(60);
						match(IDCap);
						setState(65);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la == COMMA)
						{
							{
								{
									setState(61);
									match(COMMA);
									setState(62);
									match(IDCap);
								}
							}
							setState(67);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(68);
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
			return getToken(LexertoolsParser.KW_POPS, 0);
		}

		public TerminalNode OPAREN()
		{
			return getToken(LexertoolsParser.OPAREN, 0);
		}

		public List<TerminalNode> IDCap()
		{
			return getTokens(LexertoolsParser.IDCap);
		}

		public TerminalNode IDCap(int i)
		{
			return getToken(LexertoolsParser.IDCap, i);
		}

		public TerminalNode CPAREN()
		{
			return getToken(LexertoolsParser.CPAREN, 0);
		}

		public List<TerminalNode> COMMA()
		{
			return getTokens(LexertoolsParser.COMMA);
		}

		public TerminalNode COMMA(int i)
		{
			return getToken(LexertoolsParser.COMMA, i);
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
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterPops_part(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitPops_part(this);
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
				setState(82);
				_la = _input.LA(1);
				if (_la == KW_POPS)
				{
					{
						setState(71);
						match(KW_POPS);
						setState(72);
						match(OPAREN);
						setState(73);
						match(IDCap);
						setState(78);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la == COMMA)
						{
							{
								{
									setState(74);
									match(COMMA);
									setState(75);
									match(IDCap);
								}
							}
							setState(80);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(81);
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
			return getToken(LexertoolsParser.BAR, 0);
		}

		public Rx_seqContext rx_seq()
		{
			return getRuleContext(Rx_seqContext.class, 0);
		}

		public OringContext(RxContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterOring(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitOring(this);
		}
	}

	public static class JustSeqContext extends RxContext
	{
		public Rx_seqContext rx_seq()
		{
			return getRuleContext(Rx_seqContext.class, 0);
		}

		public JustSeqContext(RxContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterJustSeq(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitJustSeq(this);
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

					setState(85);
					rx_seq(0);
				}
				_ctx.stop = _input.LT(-1);
				setState(92);
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
								_localctx = new OringContext(new RxContext(_parentctx, _parentState));
								pushNewRecursionContext(_localctx, _startState, RULE_rx);
								setState(87);
								if (!(precpred(_ctx, 2)))
									throw new FailedPredicateException(this, "precpred(_ctx, 2)");
								setState(88);
								match(BAR);
								setState(89);
								rx_seq(0);
							}
						}
					}
					setState(94);
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

	public static class Rx_seqContext extends ParserRuleContext
	{
		public Rx_seqContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		@Override public int getRuleIndex()
		{
			return RULE_rx_seq;
		}

		public Rx_seqContext()
		{
		}

		public void copyFrom(Rx_seqContext ctx)
		{
			super.copyFrom(ctx);
		}
	}

	public static class SeqqContext extends Rx_seqContext
	{
		public Rx_seqContext rx_seq()
		{
			return getRuleContext(Rx_seqContext.class, 0);
		}

		public RxpieceContext rxpiece()
		{
			return getRuleContext(RxpieceContext.class, 0);
		}

		public SeqqContext(Rx_seqContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterSeqq(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitSeqq(this);
		}
	}

	public static class JustPieceContext extends Rx_seqContext
	{
		public RxpieceContext rxpiece()
		{
			return getRuleContext(RxpieceContext.class, 0);
		}

		public JustPieceContext(Rx_seqContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterJustPiece(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitJustPiece(this);
		}
	}

	public final Rx_seqContext rx_seq() throws RecognitionException
	{
		return rx_seq(0);
	}

	private Rx_seqContext rx_seq(int _p) throws RecognitionException
	{
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Rx_seqContext _localctx = new Rx_seqContext(_ctx, _parentState);
		Rx_seqContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_rx_seq, _p);
		try
		{
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				{
					_localctx = new JustPieceContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;

					setState(96);
					rxpiece(0);
				}
				_ctx.stop = _input.LT(-1);
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 10, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER)
				{
					if (_alt == 1)
					{
						if (_parseListeners != null)
							triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							{
								_localctx = new SeqqContext(new Rx_seqContext(_parentctx, _parentState));
								pushNewRecursionContext(_localctx, _startState, RULE_rx_seq);
								setState(98);
								if (!(precpred(_ctx, 2)))
									throw new FailedPredicateException(this, "precpred(_ctx, 2)");
								setState(99);
								rxpiece(0);
							}
						}
					}
					setState(104);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 10, _ctx);
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
			return getToken(LexertoolsParser.PLUS, 0);
		}

		public PiecePlusContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterPiecePlus(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitPiecePlus(this);
		}
	}

	public static class PieceStringContext extends RxpieceContext
	{
		public TerminalNode STRING()
		{
			return getToken(LexertoolsParser.STRING, 0);
		}

		public PieceStringContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterPieceString(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitPieceString(this);
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
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterPieceChar(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitPieceChar(this);
		}
	}

	public static class PiecePredefinedContext extends RxpieceContext
	{
		public TerminalNode DOLLAR()
		{
			return getToken(LexertoolsParser.DOLLAR, 0);
		}

		public TerminalNode IDCap()
		{
			return getToken(LexertoolsParser.IDCap, 0);
		}

		public PiecePredefinedContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterPiecePredefined(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitPiecePredefined(this);
		}
	}

	public static class PieceQuestionContext extends RxpieceContext
	{
		public RxpieceContext rxpiece()
		{
			return getRuleContext(RxpieceContext.class, 0);
		}

		public TerminalNode QUESTION()
		{
			return getToken(LexertoolsParser.QUESTION, 0);
		}

		public PieceQuestionContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterPieceQuestion(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitPieceQuestion(this);
		}
	}

	public static class PieceParenedContext extends RxpieceContext
	{
		public TerminalNode OPAREN()
		{
			return getToken(LexertoolsParser.OPAREN, 0);
		}

		public RxContext rx()
		{
			return getRuleContext(RxContext.class, 0);
		}

		public TerminalNode CPAREN()
		{
			return getToken(LexertoolsParser.CPAREN, 0);
		}

		public PieceParenedContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterPieceParened(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitPieceParened(this);
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
			return getToken(LexertoolsParser.STAR, 0);
		}

		public PieceAsteriskContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterPieceAsterisk(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitPieceAsterisk(this);
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
				setState(114);
				switch (_input.LA(1)) {
				case STRING: {
					_localctx = new PieceStringContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;

					setState(106);
					match(STRING);
				}
					break;
				case START_CHARCLASS: {
					_localctx = new PieceCharContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(107);
					charClass();
				}
					break;
				case DOLLAR: {
					_localctx = new PiecePredefinedContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(108);
					match(DOLLAR);
					setState(109);
					match(IDCap);
				}
					break;
				case OPAREN: {
					_localctx = new PieceParenedContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(110);
					match(OPAREN);
					setState(111);
					rx(0);
					setState(112);
					match(CPAREN);
				}
					break;
				default:
					throw new NoViableAltException(this);
				}
				_ctx.stop = _input.LT(-1);
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 13, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER)
				{
					if (_alt == 1)
					{
						if (_parseListeners != null)
							triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							setState(122);
							switch (getInterpreter().adaptivePredict(_input, 12, _ctx)) {
							case 1: {
								_localctx = new PieceAsteriskContext(new RxpieceContext(_parentctx, _parentState));
								pushNewRecursionContext(_localctx, _startState, RULE_rxpiece);
								setState(116);
								if (!(precpred(_ctx, 4)))
									throw new FailedPredicateException(this, "precpred(_ctx, 4)");
								setState(117);
								match(STAR);
							}
								break;
							case 2: {
								_localctx = new PiecePlusContext(new RxpieceContext(_parentctx, _parentState));
								pushNewRecursionContext(_localctx, _startState, RULE_rxpiece);
								setState(118);
								if (!(precpred(_ctx, 3)))
									throw new FailedPredicateException(this, "precpred(_ctx, 3)");
								setState(119);
								match(PLUS);
							}
								break;
							case 3: {
								_localctx = new PieceQuestionContext(new RxpieceContext(_parentctx, _parentState));
								pushNewRecursionContext(_localctx, _startState, RULE_rxpiece);
								setState(120);
								if (!(precpred(_ctx, 2)))
									throw new FailedPredicateException(this, "precpred(_ctx, 2)");
								setState(121);
								match(QUESTION);
							}
								break;
							}
						}
					}
					setState(126);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 13, _ctx);
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
			return getToken(LexertoolsParser.START_CHARCLASS, 0);
		}

		public TerminalNode END_CHARCLASS()
		{
			return getToken(LexertoolsParser.END_CHARCLASS, 0);
		}

		public List<CharClassPartContext> charClassPart()
		{
			return getRuleContexts(CharClassPartContext.class);
		}

		public CharClassPartContext charClassPart(int i)
		{
			return getRuleContext(CharClassPartContext.class, i);
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
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterCharClass(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitCharClass(this);
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
				setState(127);
				match(START_CHARCLASS);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do
				{
					{
						{
							setState(128);
							charClassPart();
						}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while (_la == CHAR);
				setState(133);
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

	public static class CharClassPartContext extends ParserRuleContext
	{
		public CharClassPartContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		@Override public int getRuleIndex()
		{
			return RULE_charClassPart;
		}

		public CharClassPartContext()
		{
		}

		public void copyFrom(CharClassPartContext ctx)
		{
			super.copyFrom(ctx);
		}
	}

	public static class RangeCharClassPartContext extends CharClassPartContext
	{
		public RangeChContext rangeCh()
		{
			return getRuleContext(RangeChContext.class, 0);
		}

		public RangeCharClassPartContext(CharClassPartContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterRangeCharClassPart(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitRangeCharClassPart(this);
		}
	}

	public static class SingleCharClassPartContext extends CharClassPartContext
	{
		public SingleChContext singleCh()
		{
			return getRuleContext(SingleChContext.class, 0);
		}

		public SingleCharClassPartContext(CharClassPartContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterSingleCharClassPart(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitSingleCharClassPart(this);
		}
	}

	public final CharClassPartContext charClassPart() throws RecognitionException
	{
		CharClassPartContext _localctx = new CharClassPartContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_charClassPart);
		try
		{
			setState(137);
			switch (getInterpreter().adaptivePredict(_input, 15, _ctx)) {
			case 1:
				_localctx = new RangeCharClassPartContext(_localctx);
				enterOuterAlt(_localctx, 1);
			{
				setState(135);
				rangeCh();
			}
				break;
			case 2:
				_localctx = new SingleCharClassPartContext(_localctx);
				enterOuterAlt(_localctx, 2);
			{
				setState(136);
				singleCh();
			}
				break;
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
			return getTokens(LexertoolsParser.CHAR);
		}

		public TerminalNode CHAR(int i)
		{
			return getToken(LexertoolsParser.CHAR, i);
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
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterRangeCh(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitRangeCh(this);
		}
	}

	public final RangeChContext rangeCh() throws RecognitionException
	{
		RangeChContext _localctx = new RangeChContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rangeCh);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(139);
				match(CHAR);
				setState(140);
				match(DASH);
				setState(141);
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
			return getToken(LexertoolsParser.CHAR, 0);
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
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).enterSingleCh(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof LexertoolsParserListener)
				((LexertoolsParserListener) listener).exitSingleCh(this);
		}
	}

	public final SingleChContext singleCh() throws RecognitionException
	{
		SingleChContext _localctx = new SingleChContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_singleCh);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(143);
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
			return rx_seq_sempred((Rx_seqContext) _localctx, predIndex);
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

	private boolean rx_seq_sempred(Rx_seqContext _localctx, int predIndex)
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
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN = "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33\u0094\4\2\t\2"
			+ "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"
			+ "\t\13\4\f\t\f\4\r\t\r\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\3\3\3\3\3\3\3"
			+ "\3\3\3\3\5\3\'\n\3\3\3\5\3*\n\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\7"
			+ "\4\65\n\4\f\4\16\48\13\4\3\4\5\4;\n\4\3\5\3\5\3\5\3\5\3\5\7\5B\n\5\f\5"
			+ "\16\5E\13\5\3\5\5\5H\n\5\3\6\3\6\3\6\3\6\3\6\7\6O\n\6\f\6\16\6R\13\6\3"
			+ "\6\5\6U\n\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7]\n\7\f\7\16\7`\13\7\3\b\3\b\3"
			+ "\b\3\b\3\b\7\bg\n\b\f\b\16\bj\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"
			+ "\5\tu\n\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t}\n\t\f\t\16\t\u0080\13\t\3\n\3\n"
			+ "\6\n\u0084\n\n\r\n\16\n\u0085\3\n\3\n\3\13\3\13\5\13\u008c\n\13\3\f\3"
			+ "\f\3\f\3\f\3\r\3\r\3\r\2\5\f\16\20\16\2\4\6\b\n\f\16\20\22\24\26\30\2"
			+ "\2\u009a\2\35\3\2\2\2\4 \3\2\2\2\6:\3\2\2\2\bG\3\2\2\2\nT\3\2\2\2\fV\3"
			+ "\2\2\2\16a\3\2\2\2\20t\3\2\2\2\22\u0081\3\2\2\2\24\u008b\3\2\2\2\26\u008d"
			+ "\3\2\2\2\30\u0091\3\2\2\2\32\34\5\4\3\2\33\32\3\2\2\2\34\37\3\2\2\2\35"
			+ "\33\3\2\2\2\35\36\3\2\2\2\36\3\3\2\2\2\37\35\3\2\2\2 !\7\b\2\2!\"\5\6"
			+ "\4\2\"#\5\b\5\2#&\5\n\6\2$%\7\6\2\2%\'\7\b\2\2&$\3\2\2\2&\'\3\2\2\2\'"
			+ ")\3\2\2\2(*\7\7\2\2)(\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\7\23\2\2,-\5\f\7\2"
			+ "-.\7\24\2\2.\5\3\2\2\2/\60\7\3\2\2\60\61\7\f\2\2\61\66\7\b\2\2\62\63\7"
			+ "\13\2\2\63\65\7\b\2\2\64\62\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3"
			+ "\2\2\2\679\3\2\2\28\66\3\2\2\29;\7\r\2\2:/\3\2\2\2:;\3\2\2\2;\7\3\2\2"
			+ "\2<=\7\4\2\2=>\7\f\2\2>C\7\b\2\2?@\7\13\2\2@B\7\b\2\2A?\3\2\2\2BE\3\2"
			+ "\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2FH\7\r\2\2G<\3\2\2\2GH\3\2"
			+ "\2\2H\t\3\2\2\2IJ\7\5\2\2JK\7\f\2\2KP\7\b\2\2LM\7\13\2\2MO\7\b\2\2NL\3"
			+ "\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2\2SU\7\r\2\2TI\3"
			+ "\2\2\2TU\3\2\2\2U\13\3\2\2\2VW\b\7\1\2WX\5\16\b\2X^\3\2\2\2YZ\f\4\2\2"
			+ "Z[\7\22\2\2[]\5\16\b\2\\Y\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\r\3"
			+ "\2\2\2`^\3\2\2\2ab\b\b\1\2bc\5\20\t\2ch\3\2\2\2de\f\4\2\2eg\5\20\t\2f"
			+ "d\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\17\3\2\2\2jh\3\2\2\2kl\b\t\1"
			+ "\2lu\7\n\2\2mu\5\22\n\2no\7\16\2\2ou\7\b\2\2pq\7\f\2\2qr\5\f\7\2rs\7\r"
			+ "\2\2su\3\2\2\2tk\3\2\2\2tm\3\2\2\2tn\3\2\2\2tp\3\2\2\2u~\3\2\2\2vw\f\6"
			+ "\2\2w}\7\20\2\2xy\f\5\2\2y}\7\17\2\2z{\f\4\2\2{}\7\21\2\2|v\3\2\2\2|x"
			+ "\3\2\2\2|z\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\21\3\2\2"
			+ "\2\u0080~\3\2\2\2\u0081\u0083\7\30\2\2\u0082\u0084\5\24\13\2\u0083\u0082"
			+ "\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086"
			+ "\u0087\3\2\2\2\u0087\u0088\7\31\2\2\u0088\23\3\2\2\2\u0089\u008c\5\26"
			+ "\f\2\u008a\u008c\5\30\r\2\u008b\u0089\3\2\2\2\u008b\u008a\3\2\2\2\u008c"
			+ "\25\3\2\2\2\u008d\u008e\7\32\2\2\u008e\u008f\7\33\2\2\u008f\u0090\7\32"
			+ "\2\2\u0090\27\3\2\2\2\u0091\u0092\7\32\2\2\u0092\31\3\2\2\2\22\35&)\66" + ":CGPT^ht|~\u0085\u008b";
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