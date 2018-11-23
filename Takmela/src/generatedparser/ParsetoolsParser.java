// Generated from ParsetoolsParser.g4 by ANTLR 4.5
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
public class ParsetoolsParser extends Parser
{
	static
	{
		RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION);
	}

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
	public static final int KW_WITHIN = 1, KW_PUSHES = 2, KW_POPS = 3, KW_CLASS = 4, KW_SKIP = 5, IDSmall = 6,
			IDCap = 7, LABEL = 8, INT = 9, STRING = 10, COMMA = 11, OPAREN = 12, CPAREN = 13, DOLLAR = 14, PLUS = 15,
			STAR = 16, QUESTION = 17, BAR = 18, COLON = 19, SEMI = 20, COMMENT2 = 21, COMMENT = 22, WS = 23,
			START_CHARCLASS = 24, END_CHARCLASS = 25, CHAR = 26, DASH = 27;
	public static final int RULE_program = 0, RULE_grammar_rule = 1, RULE_seq = 2, RULE_piece = 3, RULE_lexer_rule = 4,
			RULE_within_part = 5, RULE_pushes_part = 6, RULE_pops_part = 7, RULE_rx = 8, RULE_rx_seq = 9,
			RULE_rxpiece = 10, RULE_charClass = 11, RULE_charClassPart = 12, RULE_rangeCh = 13, RULE_singleCh = 14;
	public static final String[] ruleNames = { "program", "grammar_rule", "seq", "piece", "lexer_rule", "within_part",
			"pushes_part", "pops_part", "rx", "rx_seq", "rxpiece", "charClass", "charClassPart", "rangeCh",
			"singleCh" };

	private static final String[] _LITERAL_NAMES = { null, "'within'", "'pushes'", "'pops'", "'class'", "'skip'", null,
			null, null, null, null, "','", "'('", "')'", "'$'", "'+'", "'*'", "'?'", "'|'", "':'", "';'", null, null,
			null, "'['", "']'", null, "'-'" };
	private static final String[] _SYMBOLIC_NAMES = { null, "KW_WITHIN", "KW_PUSHES", "KW_POPS", "KW_CLASS", "KW_SKIP",
			"IDSmall", "IDCap", "LABEL", "INT", "STRING", "COMMA", "OPAREN", "CPAREN", "DOLLAR", "PLUS", "STAR",
			"QUESTION", "BAR", "COLON", "SEMI", "COMMENT2", "COMMENT", "WS", "START_CHARCLASS", "END_CHARCLASS", "CHAR",
			"DASH" };
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
		return "ParsetoolsParser.g4";
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

	public ParsetoolsParser(TokenStream input)
	{
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext
	{
		public List<Grammar_ruleContext> grammar_rule()
		{
			return getRuleContexts(Grammar_ruleContext.class);
		}

		public Grammar_ruleContext grammar_rule(int i)
		{
			return getRuleContext(Grammar_ruleContext.class, i);
		}

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
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterProgram(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitProgram(this);
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
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == IDSmall)
				{
					{
						{
							setState(30);
							grammar_rule();
						}
					}
					setState(35);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == IDCap)
				{
					{
						{
							setState(36);
							lexer_rule();
						}
					}
					setState(41);
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

	public static class Grammar_ruleContext extends ParserRuleContext
	{
		public TerminalNode IDSmall()
		{
			return getToken(ParsetoolsParser.IDSmall, 0);
		}

		public TerminalNode COLON()
		{
			return getToken(ParsetoolsParser.COLON, 0);
		}

		public List<SeqContext> seq()
		{
			return getRuleContexts(SeqContext.class);
		}

		public SeqContext seq(int i)
		{
			return getRuleContext(SeqContext.class, i);
		}

		public TerminalNode SEMI()
		{
			return getToken(ParsetoolsParser.SEMI, 0);
		}

		public List<TerminalNode> LABEL()
		{
			return getTokens(ParsetoolsParser.LABEL);
		}

		public TerminalNode LABEL(int i)
		{
			return getToken(ParsetoolsParser.LABEL, i);
		}

		public List<TerminalNode> BAR()
		{
			return getTokens(ParsetoolsParser.BAR);
		}

		public TerminalNode BAR(int i)
		{
			return getToken(ParsetoolsParser.BAR, i);
		}

		public Grammar_ruleContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		@Override public int getRuleIndex()
		{
			return RULE_grammar_rule;
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterGrammar_rule(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitGrammar_rule(this);
		}
	}

	public final Grammar_ruleContext grammar_rule() throws RecognitionException
	{
		Grammar_ruleContext _localctx = new Grammar_ruleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_grammar_rule);
		int _la;
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(42);
				match(IDSmall);
				setState(43);
				match(COLON);
				setState(44);
				seq();
				setState(46);
				_la = _input.LA(1);
				if (_la == LABEL)
				{
					{
						setState(45);
						match(LABEL);
					}
				}

				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == BAR)
				{
					{
						{
							setState(48);
							match(BAR);
							setState(49);
							seq();
							setState(51);
							_la = _input.LA(1);
							if (_la == LABEL)
							{
								{
									setState(50);
									match(LABEL);
								}
							}

						}
					}
					setState(57);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(58);
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

	public static class SeqContext extends ParserRuleContext
	{
		public List<PieceContext> piece()
		{
			return getRuleContexts(PieceContext.class);
		}

		public PieceContext piece(int i)
		{
			return getRuleContext(PieceContext.class, i);
		}

		public SeqContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		@Override public int getRuleIndex()
		{
			return RULE_seq;
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterSeq(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitSeq(this);
		}
	}

	public final SeqContext seq() throws RecognitionException
	{
		SeqContext _localctx = new SeqContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_seq);
		int _la;
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0
						&& ((1L << _la) & ((1L << IDSmall) | (1L << IDCap) | (1L << STRING))) != 0))
				{
					{
						{
							setState(60);
							piece();
						}
					}
					setState(65);
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

	public static class PieceContext extends ParserRuleContext
	{
		public PieceContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		@Override public int getRuleIndex()
		{
			return RULE_piece;
		}

		public PieceContext()
		{
		}

		public void copyFrom(PieceContext ctx)
		{
			super.copyFrom(ctx);
		}
	}

	public static class PieceTokenContext extends PieceContext
	{
		public TerminalNode IDCap()
		{
			return getToken(ParsetoolsParser.IDCap, 0);
		}

		public PieceTokenContext(PieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterPieceToken(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitPieceToken(this);
		}
	}

	public static class PieceTerminalContext extends PieceContext
	{
		public TerminalNode STRING()
		{
			return getToken(ParsetoolsParser.STRING, 0);
		}

		public PieceTerminalContext(PieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterPieceTerminal(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitPieceTerminal(this);
		}
	}

	public static class PieceCallContext extends PieceContext
	{
		public TerminalNode IDSmall()
		{
			return getToken(ParsetoolsParser.IDSmall, 0);
		}

		public PieceCallContext(PieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterPieceCall(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitPieceCall(this);
		}
	}

	public final PieceContext piece() throws RecognitionException
	{
		PieceContext _localctx = new PieceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_piece);
		try
		{
			setState(69);
			switch (_input.LA(1)) {
			case STRING:
				_localctx = new PieceTerminalContext(_localctx);
				enterOuterAlt(_localctx, 1);
			{
				setState(66);
				match(STRING);
			}
				break;
			case IDSmall:
				_localctx = new PieceCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
			{
				setState(67);
				match(IDSmall);
			}
				break;
			case IDCap:
				_localctx = new PieceTokenContext(_localctx);
				enterOuterAlt(_localctx, 3);
			{
				setState(68);
				match(IDCap);
			}
				break;
			default:
				throw new NoViableAltException(this);
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
			return getTokens(ParsetoolsParser.IDCap);
		}

		public TerminalNode IDCap(int i)
		{
			return getToken(ParsetoolsParser.IDCap, i);
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
			return getToken(ParsetoolsParser.COLON, 0);
		}

		public RxContext rx()
		{
			return getRuleContext(RxContext.class, 0);
		}

		public TerminalNode SEMI()
		{
			return getToken(ParsetoolsParser.SEMI, 0);
		}

		public TerminalNode KW_CLASS()
		{
			return getToken(ParsetoolsParser.KW_CLASS, 0);
		}

		public TerminalNode KW_SKIP()
		{
			return getToken(ParsetoolsParser.KW_SKIP, 0);
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
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterLexer_rule(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitLexer_rule(this);
		}
	}

	public final Lexer_ruleContext lexer_rule() throws RecognitionException
	{
		Lexer_ruleContext _localctx = new Lexer_ruleContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_lexer_rule);
		int _la;
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(71);
				match(IDCap);
				setState(72);
				within_part();
				setState(73);
				pushes_part();
				setState(74);
				pops_part();
				setState(77);
				_la = _input.LA(1);
				if (_la == KW_CLASS)
				{
					{
						setState(75);
						match(KW_CLASS);
						setState(76);
						match(IDCap);
					}
				}

				setState(80);
				_la = _input.LA(1);
				if (_la == KW_SKIP)
				{
					{
						setState(79);
						match(KW_SKIP);
					}
				}

				setState(82);
				match(COLON);
				setState(83);
				rx(0);
				setState(84);
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
			return getToken(ParsetoolsParser.KW_WITHIN, 0);
		}

		public TerminalNode OPAREN()
		{
			return getToken(ParsetoolsParser.OPAREN, 0);
		}

		public List<TerminalNode> IDCap()
		{
			return getTokens(ParsetoolsParser.IDCap);
		}

		public TerminalNode IDCap(int i)
		{
			return getToken(ParsetoolsParser.IDCap, i);
		}

		public TerminalNode CPAREN()
		{
			return getToken(ParsetoolsParser.CPAREN, 0);
		}

		public List<TerminalNode> COMMA()
		{
			return getTokens(ParsetoolsParser.COMMA);
		}

		public TerminalNode COMMA(int i)
		{
			return getToken(ParsetoolsParser.COMMA, i);
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
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterWithin_part(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitWithin_part(this);
		}
	}

	public final Within_partContext within_part() throws RecognitionException
	{
		Within_partContext _localctx = new Within_partContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_within_part);
		int _la;
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(97);
				_la = _input.LA(1);
				if (_la == KW_WITHIN)
				{
					{
						setState(86);
						match(KW_WITHIN);
						setState(87);
						match(OPAREN);
						setState(88);
						match(IDCap);
						setState(93);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la == COMMA)
						{
							{
								{
									setState(89);
									match(COMMA);
									setState(90);
									match(IDCap);
								}
							}
							setState(95);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(96);
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
			return getToken(ParsetoolsParser.KW_PUSHES, 0);
		}

		public TerminalNode OPAREN()
		{
			return getToken(ParsetoolsParser.OPAREN, 0);
		}

		public List<TerminalNode> IDCap()
		{
			return getTokens(ParsetoolsParser.IDCap);
		}

		public TerminalNode IDCap(int i)
		{
			return getToken(ParsetoolsParser.IDCap, i);
		}

		public TerminalNode CPAREN()
		{
			return getToken(ParsetoolsParser.CPAREN, 0);
		}

		public List<TerminalNode> COMMA()
		{
			return getTokens(ParsetoolsParser.COMMA);
		}

		public TerminalNode COMMA(int i)
		{
			return getToken(ParsetoolsParser.COMMA, i);
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
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterPushes_part(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitPushes_part(this);
		}
	}

	public final Pushes_partContext pushes_part() throws RecognitionException
	{
		Pushes_partContext _localctx = new Pushes_partContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_pushes_part);
		int _la;
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(110);
				_la = _input.LA(1);
				if (_la == KW_PUSHES)
				{
					{
						setState(99);
						match(KW_PUSHES);
						setState(100);
						match(OPAREN);
						setState(101);
						match(IDCap);
						setState(106);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la == COMMA)
						{
							{
								{
									setState(102);
									match(COMMA);
									setState(103);
									match(IDCap);
								}
							}
							setState(108);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(109);
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
			return getToken(ParsetoolsParser.KW_POPS, 0);
		}

		public TerminalNode OPAREN()
		{
			return getToken(ParsetoolsParser.OPAREN, 0);
		}

		public List<TerminalNode> IDCap()
		{
			return getTokens(ParsetoolsParser.IDCap);
		}

		public TerminalNode IDCap(int i)
		{
			return getToken(ParsetoolsParser.IDCap, i);
		}

		public TerminalNode CPAREN()
		{
			return getToken(ParsetoolsParser.CPAREN, 0);
		}

		public List<TerminalNode> COMMA()
		{
			return getTokens(ParsetoolsParser.COMMA);
		}

		public TerminalNode COMMA(int i)
		{
			return getToken(ParsetoolsParser.COMMA, i);
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
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterPops_part(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitPops_part(this);
		}
	}

	public final Pops_partContext pops_part() throws RecognitionException
	{
		Pops_partContext _localctx = new Pops_partContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pops_part);
		int _la;
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(123);
				_la = _input.LA(1);
				if (_la == KW_POPS)
				{
					{
						setState(112);
						match(KW_POPS);
						setState(113);
						match(OPAREN);
						setState(114);
						match(IDCap);
						setState(119);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la == COMMA)
						{
							{
								{
									setState(115);
									match(COMMA);
									setState(116);
									match(IDCap);
								}
							}
							setState(121);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(122);
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
			return getToken(ParsetoolsParser.BAR, 0);
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
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterOring(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitOring(this);
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
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterJustSeq(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitJustSeq(this);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_rx, _p);
		try
		{
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				{
					_localctx = new JustSeqContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;

					setState(126);
					rx_seq(0);
				}
				_ctx.stop = _input.LT(-1);
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 15, _ctx);
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
								setState(128);
								if (!(precpred(_ctx, 2)))
									throw new FailedPredicateException(this, "precpred(_ctx, 2)");
								setState(129);
								match(BAR);
								setState(130);
								rx_seq(0);
							}
						}
					}
					setState(135);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 15, _ctx);
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
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterSeqq(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitSeqq(this);
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
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterJustPiece(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitJustPiece(this);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_rx_seq, _p);
		try
		{
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				{
					_localctx = new JustPieceContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;

					setState(137);
					rxpiece(0);
				}
				_ctx.stop = _input.LT(-1);
				setState(143);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 16, _ctx);
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
								setState(139);
								if (!(precpred(_ctx, 2)))
									throw new FailedPredicateException(this, "precpred(_ctx, 2)");
								setState(140);
								rxpiece(0);
							}
						}
					}
					setState(145);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 16, _ctx);
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
			return getToken(ParsetoolsParser.PLUS, 0);
		}

		public PiecePlusContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterPiecePlus(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitPiecePlus(this);
		}
	}

	public static class PieceStringContext extends RxpieceContext
	{
		public TerminalNode STRING()
		{
			return getToken(ParsetoolsParser.STRING, 0);
		}

		public PieceStringContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterPieceString(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitPieceString(this);
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
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterPieceChar(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitPieceChar(this);
		}
	}

	public static class PiecePredefinedContext extends RxpieceContext
	{
		public TerminalNode DOLLAR()
		{
			return getToken(ParsetoolsParser.DOLLAR, 0);
		}

		public TerminalNode IDCap()
		{
			return getToken(ParsetoolsParser.IDCap, 0);
		}

		public PiecePredefinedContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterPiecePredefined(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitPiecePredefined(this);
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
			return getToken(ParsetoolsParser.QUESTION, 0);
		}

		public PieceQuestionContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterPieceQuestion(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitPieceQuestion(this);
		}
	}

	public static class PieceParenedContext extends RxpieceContext
	{
		public TerminalNode OPAREN()
		{
			return getToken(ParsetoolsParser.OPAREN, 0);
		}

		public RxContext rx()
		{
			return getRuleContext(RxContext.class, 0);
		}

		public TerminalNode CPAREN()
		{
			return getToken(ParsetoolsParser.CPAREN, 0);
		}

		public PieceParenedContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterPieceParened(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitPieceParened(this);
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
			return getToken(ParsetoolsParser.STAR, 0);
		}

		public PieceAsteriskContext(RxpieceContext ctx)
		{
			copyFrom(ctx);
		}

		@Override public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterPieceAsterisk(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitPieceAsterisk(this);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_rxpiece, _p);
		try
		{
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(155);
				switch (_input.LA(1)) {
				case STRING: {
					_localctx = new PieceStringContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;

					setState(147);
					match(STRING);
				}
					break;
				case START_CHARCLASS: {
					_localctx = new PieceCharContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(148);
					charClass();
				}
					break;
				case DOLLAR: {
					_localctx = new PiecePredefinedContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(149);
					match(DOLLAR);
					setState(150);
					match(IDCap);
				}
					break;
				case OPAREN: {
					_localctx = new PieceParenedContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(151);
					match(OPAREN);
					setState(152);
					rx(0);
					setState(153);
					match(CPAREN);
				}
					break;
				default:
					throw new NoViableAltException(this);
				}
				_ctx.stop = _input.LT(-1);
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 19, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER)
				{
					if (_alt == 1)
					{
						if (_parseListeners != null)
							triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							setState(163);
							switch (getInterpreter().adaptivePredict(_input, 18, _ctx)) {
							case 1: {
								_localctx = new PieceAsteriskContext(new RxpieceContext(_parentctx, _parentState));
								pushNewRecursionContext(_localctx, _startState, RULE_rxpiece);
								setState(157);
								if (!(precpred(_ctx, 4)))
									throw new FailedPredicateException(this, "precpred(_ctx, 4)");
								setState(158);
								match(STAR);
							}
								break;
							case 2: {
								_localctx = new PiecePlusContext(new RxpieceContext(_parentctx, _parentState));
								pushNewRecursionContext(_localctx, _startState, RULE_rxpiece);
								setState(159);
								if (!(precpred(_ctx, 3)))
									throw new FailedPredicateException(this, "precpred(_ctx, 3)");
								setState(160);
								match(PLUS);
							}
								break;
							case 3: {
								_localctx = new PieceQuestionContext(new RxpieceContext(_parentctx, _parentState));
								pushNewRecursionContext(_localctx, _startState, RULE_rxpiece);
								setState(161);
								if (!(precpred(_ctx, 2)))
									throw new FailedPredicateException(this, "precpred(_ctx, 2)");
								setState(162);
								match(QUESTION);
							}
								break;
							}
						}
					}
					setState(167);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 19, _ctx);
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
			return getToken(ParsetoolsParser.START_CHARCLASS, 0);
		}

		public TerminalNode END_CHARCLASS()
		{
			return getToken(ParsetoolsParser.END_CHARCLASS, 0);
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
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterCharClass(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitCharClass(this);
		}
	}

	public final CharClassContext charClass() throws RecognitionException
	{
		CharClassContext _localctx = new CharClassContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_charClass);
		int _la;
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(168);
				match(START_CHARCLASS);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do
				{
					{
						{
							setState(169);
							charClassPart();
						}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while (_la == CHAR);
				setState(174);
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
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterRangeCharClassPart(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitRangeCharClassPart(this);
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
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterSingleCharClassPart(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitSingleCharClassPart(this);
		}
	}

	public final CharClassPartContext charClassPart() throws RecognitionException
	{
		CharClassPartContext _localctx = new CharClassPartContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_charClassPart);
		try
		{
			setState(178);
			switch (getInterpreter().adaptivePredict(_input, 21, _ctx)) {
			case 1:
				_localctx = new RangeCharClassPartContext(_localctx);
				enterOuterAlt(_localctx, 1);
			{
				setState(176);
				rangeCh();
			}
				break;
			case 2:
				_localctx = new SingleCharClassPartContext(_localctx);
				enterOuterAlt(_localctx, 2);
			{
				setState(177);
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
			return getTokens(ParsetoolsParser.CHAR);
		}

		public TerminalNode CHAR(int i)
		{
			return getToken(ParsetoolsParser.CHAR, i);
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
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterRangeCh(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitRangeCh(this);
		}
	}

	public final RangeChContext rangeCh() throws RecognitionException
	{
		RangeChContext _localctx = new RangeChContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_rangeCh);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(180);
				match(CHAR);
				setState(181);
				match(DASH);
				setState(182);
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
			return getToken(ParsetoolsParser.CHAR, 0);
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
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).enterSingleCh(this);
		}

		@Override public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof ParsetoolsParserListener)
				((ParsetoolsParserListener) listener).exitSingleCh(this);
		}
	}

	public final SingleChContext singleCh() throws RecognitionException
	{
		SingleChContext _localctx = new SingleChContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_singleCh);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(184);
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
		case 8:
			return rx_sempred((RxContext) _localctx, predIndex);
		case 9:
			return rx_seq_sempred((Rx_seqContext) _localctx, predIndex);
		case 10:
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

	public static final String _serializedATN = "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\35\u00bd\4\2\t\2"
			+ "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"
			+ "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\7\2\"\n\2\f\2"
			+ "\16\2%\13\2\3\2\7\2(\n\2\f\2\16\2+\13\2\3\3\3\3\3\3\3\3\5\3\61\n\3\3\3"
			+ "\3\3\3\3\5\3\66\n\3\7\38\n\3\f\3\16\3;\13\3\3\3\3\3\3\4\7\4@\n\4\f\4\16"
			+ "\4C\13\4\3\5\3\5\3\5\5\5H\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6P\n\6\3\6\5\6"
			+ "S\n\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7^\n\7\f\7\16\7a\13\7\3\7"
			+ "\5\7d\n\7\3\b\3\b\3\b\3\b\3\b\7\bk\n\b\f\b\16\bn\13\b\3\b\5\bq\n\b\3\t"
			+ "\3\t\3\t\3\t\3\t\7\tx\n\t\f\t\16\t{\13\t\3\t\5\t~\n\t\3\n\3\n\3\n\3\n"
			+ "\3\n\3\n\7\n\u0086\n\n\f\n\16\n\u0089\13\n\3\13\3\13\3\13\3\13\3\13\7"
			+ "\13\u0090\n\13\f\13\16\13\u0093\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"
			+ "\3\f\5\f\u009e\n\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00a6\n\f\f\f\16\f\u00a9"
			+ "\13\f\3\r\3\r\6\r\u00ad\n\r\r\r\16\r\u00ae\3\r\3\r\3\16\3\16\5\16\u00b5"
			+ "\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\2\5\22\24\26\21\2\4\6\b\n\f\16"
			+ "\20\22\24\26\30\32\34\36\2\2\u00c7\2#\3\2\2\2\4,\3\2\2\2\6A\3\2\2\2\b"
			+ "G\3\2\2\2\nI\3\2\2\2\fc\3\2\2\2\16p\3\2\2\2\20}\3\2\2\2\22\177\3\2\2\2"
			+ "\24\u008a\3\2\2\2\26\u009d\3\2\2\2\30\u00aa\3\2\2\2\32\u00b4\3\2\2\2\34"
			+ "\u00b6\3\2\2\2\36\u00ba\3\2\2\2 \"\5\4\3\2! \3\2\2\2\"%\3\2\2\2#!\3\2"
			+ "\2\2#$\3\2\2\2$)\3\2\2\2%#\3\2\2\2&(\5\n\6\2\'&\3\2\2\2(+\3\2\2\2)\'\3"
			+ "\2\2\2)*\3\2\2\2*\3\3\2\2\2+)\3\2\2\2,-\7\b\2\2-.\7\25\2\2.\60\5\6\4\2"
			+ "/\61\7\n\2\2\60/\3\2\2\2\60\61\3\2\2\2\619\3\2\2\2\62\63\7\24\2\2\63\65"
			+ "\5\6\4\2\64\66\7\n\2\2\65\64\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\62\3"
			+ "\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7\26\2\2"
			+ "=\5\3\2\2\2>@\5\b\5\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\7\3\2\2"
			+ "\2CA\3\2\2\2DH\7\f\2\2EH\7\b\2\2FH\7\t\2\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2"
			+ "\2H\t\3\2\2\2IJ\7\t\2\2JK\5\f\7\2KL\5\16\b\2LO\5\20\t\2MN\7\6\2\2NP\7"
			+ "\t\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QS\7\7\2\2RQ\3\2\2\2RS\3\2\2\2ST\3"
			+ "\2\2\2TU\7\25\2\2UV\5\22\n\2VW\7\26\2\2W\13\3\2\2\2XY\7\3\2\2YZ\7\16\2"
			+ "\2Z_\7\t\2\2[\\\7\r\2\2\\^\7\t\2\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2"
			+ "\2\2`b\3\2\2\2a_\3\2\2\2bd\7\17\2\2cX\3\2\2\2cd\3\2\2\2d\r\3\2\2\2ef\7"
			+ "\4\2\2fg\7\16\2\2gl\7\t\2\2hi\7\r\2\2ik\7\t\2\2jh\3\2\2\2kn\3\2\2\2lj"
			+ "\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2oq\7\17\2\2pe\3\2\2\2pq\3\2\2\2"
			+ "q\17\3\2\2\2rs\7\5\2\2st\7\16\2\2ty\7\t\2\2uv\7\r\2\2vx\7\t\2\2wu\3\2"
			+ "\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{y\3\2\2\2|~\7\17\2\2}r\3"
			+ "\2\2\2}~\3\2\2\2~\21\3\2\2\2\177\u0080\b\n\1\2\u0080\u0081\5\24\13\2\u0081"
			+ "\u0087\3\2\2\2\u0082\u0083\f\4\2\2\u0083\u0084\7\24\2\2\u0084\u0086\5"
			+ "\24\13\2\u0085\u0082\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087"
			+ "\u0088\3\2\2\2\u0088\23\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\b\13\1"
			+ "\2\u008b\u008c\5\26\f\2\u008c\u0091\3\2\2\2\u008d\u008e\f\4\2\2\u008e"
			+ "\u0090\5\26\f\2\u008f\u008d\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3"
			+ "\2\2\2\u0091\u0092\3\2\2\2\u0092\25\3\2\2\2\u0093\u0091\3\2\2\2\u0094"
			+ "\u0095\b\f\1\2\u0095\u009e\7\f\2\2\u0096\u009e\5\30\r\2\u0097\u0098\7"
			+ "\20\2\2\u0098\u009e\7\t\2\2\u0099\u009a\7\16\2\2\u009a\u009b\5\22\n\2"
			+ "\u009b\u009c\7\17\2\2\u009c\u009e\3\2\2\2\u009d\u0094\3\2\2\2\u009d\u0096"
			+ "\3\2\2\2\u009d\u0097\3\2\2\2\u009d\u0099\3\2\2\2\u009e\u00a7\3\2\2\2\u009f"
			+ "\u00a0\f\6\2\2\u00a0\u00a6\7\22\2\2\u00a1\u00a2\f\5\2\2\u00a2\u00a6\7"
			+ "\21\2\2\u00a3\u00a4\f\4\2\2\u00a4\u00a6\7\23\2\2\u00a5\u009f\3\2\2\2\u00a5"
			+ "\u00a1\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2"
			+ "\2\2\u00a7\u00a8\3\2\2\2\u00a8\27\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ac"
			+ "\7\32\2\2\u00ab\u00ad\5\32\16\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2"
			+ "\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1"
			+ "\7\33\2\2\u00b1\31\3\2\2\2\u00b2\u00b5\5\34\17\2\u00b3\u00b5\5\36\20\2"
			+ "\u00b4\u00b2\3\2\2\2\u00b4\u00b3\3\2\2\2\u00b5\33\3\2\2\2\u00b6\u00b7"
			+ "\7\34\2\2\u00b7\u00b8\7\35\2\2\u00b8\u00b9\7\34\2\2\u00b9\35\3\2\2\2\u00ba"
			+ "\u00bb\7\34\2\2\u00bb\37\3\2\2\2\30#)\60\659AGOR_clpy}\u0087\u0091\u009d" + "\u00a5\u00a7\u00ae\u00b4";
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