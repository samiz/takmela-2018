// Generated from ParsetoolsLexer.g4 by ANTLR 4.5
package generatedparser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class ParsetoolsLexer extends Lexer
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
	public static final int IN_CHARCLASS = 1;
	public static String[] modeNames = { "DEFAULT_MODE", "IN_CHARCLASS" };

	public static final String[] ruleNames = { "KW_WITHIN", "KW_PUSHES", "KW_POPS", "KW_CLASS", "KW_SKIP", "IDSmall",
			"IDCap", "LABEL", "INT", "STRING", "COMMA", "OPAREN", "CPAREN", "DOLLAR", "PLUS", "STAR", "QUESTION", "BAR",
			"COLON", "SEMI", "COMMENT2", "COMMENT", "WS", "START_CHARCLASS", "END_CHARCLASS", "CHAR", "DASH" };

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

	public ParsetoolsLexer(CharStream input)
	{
		super(input);
		_interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	@Override public String getGrammarFileName()
	{
		return "ParsetoolsLexer.g4";
	}

	@Override public String[] getRuleNames()
	{
		return ruleNames;
	}

	@Override public String getSerializedATN()
	{
		return _serializedATN;
	}

	@Override public String[] getModeNames()
	{
		return modeNames;
	}

	@Override public ATN getATN()
	{
		return _ATN;
	}

	public static final String _serializedATN = "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u00cd\b\1\b\1"
			+ "\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t"
			+ "\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4"
			+ "\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4"
			+ "\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3"
			+ "\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"
			+ "\6\3\6\3\6\3\6\3\6\3\7\3\7\7\7[\n\7\f\7\16\7^\13\7\3\b\3\b\7\bb\n\b\f"
			+ "\b\16\be\13\b\3\t\3\t\3\t\3\n\6\nk\n\n\r\n\16\nl\3\13\3\13\3\13\3\13\7"
			+ "\13s\n\13\f\13\16\13v\13\13\3\13\3\13\3\13\3\13\3\13\7\13}\n\13\f\13\16"
			+ "\13\u0080\13\13\3\13\5\13\u0083\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3"
			+ "\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3"
			+ "\26\3\26\3\26\7\26\u009d\n\26\f\26\16\26\u00a0\13\26\3\26\5\26\u00a3\n"
			+ "\26\3\26\5\26\u00a6\n\26\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u00ae\n\27"
			+ "\f\27\16\27\u00b1\13\27\3\27\3\27\3\27\3\27\3\27\3\30\6\30\u00b9\n\30"
			+ "\r\30\16\30\u00ba\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3"
			+ "\33\3\33\3\33\5\33\u00ca\n\33\3\34\3\34\6t~\u009e\u00af\2\35\4\3\6\4\b"
			+ "\5\n\6\f\7\16\b\20\t\22\n\24\13\26\f\30\r\32\16\34\17\36\20 \21\"\22$"
			+ "\23&\24(\25*\26,\27.\30\60\31\62\32\64\33\66\348\35\4\2\3\n\3\2c|\6\2"
			+ "\62;C\\aac|\4\2C\\aa\3\2\62;\3\3\f\f\5\2\13\f\17\17\"\"\t\2$$))//^^pp"
			+ "ttvv\6\2$$))//^^\u00d8\2\4\3\2\2\2\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2"
			+ "\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3\2\2\2\2\24\3\2\2\2\2\26"
			+ "\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2\2\2\36\3\2\2\2\2 \3\2\2"
			+ "\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2\2\2*\3\2\2\2\2,\3\2\2\2"
			+ "\2.\3\2\2\2\2\60\3\2\2\2\2\62\3\2\2\2\3\64\3\2\2\2\3\66\3\2\2\2\38\3\2"
			+ "\2\2\4:\3\2\2\2\6A\3\2\2\2\bH\3\2\2\2\nM\3\2\2\2\fS\3\2\2\2\16X\3\2\2"
			+ "\2\20_\3\2\2\2\22f\3\2\2\2\24j\3\2\2\2\26\u0082\3\2\2\2\30\u0084\3\2\2"
			+ "\2\32\u0086\3\2\2\2\34\u0088\3\2\2\2\36\u008a\3\2\2\2 \u008c\3\2\2\2\""
			+ "\u008e\3\2\2\2$\u0090\3\2\2\2&\u0092\3\2\2\2(\u0094\3\2\2\2*\u0096\3\2"
			+ "\2\2,\u0098\3\2\2\2.\u00a9\3\2\2\2\60\u00b8\3\2\2\2\62\u00be\3\2\2\2\64"
			+ "\u00c2\3\2\2\2\66\u00c9\3\2\2\28\u00cb\3\2\2\2:;\7y\2\2;<\7k\2\2<=\7v"
			+ "\2\2=>\7j\2\2>?\7k\2\2?@\7p\2\2@\5\3\2\2\2AB\7r\2\2BC\7w\2\2CD\7u\2\2"
			+ "DE\7j\2\2EF\7g\2\2FG\7u\2\2G\7\3\2\2\2HI\7r\2\2IJ\7q\2\2JK\7r\2\2KL\7"
			+ "u\2\2L\t\3\2\2\2MN\7e\2\2NO\7n\2\2OP\7c\2\2PQ\7u\2\2QR\7u\2\2R\13\3\2"
			+ "\2\2ST\7u\2\2TU\7m\2\2UV\7k\2\2VW\7r\2\2W\r\3\2\2\2X\\\t\2\2\2Y[\t\3\2"
			+ "\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\17\3\2\2\2^\\\3\2\2\2_c"
			+ "\t\4\2\2`b\t\3\2\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\21\3\2\2\2"
			+ "ec\3\2\2\2fg\7%\2\2gh\5\20\b\2h\23\3\2\2\2ik\t\5\2\2ji\3\2\2\2kl\3\2\2"
			+ "\2lj\3\2\2\2lm\3\2\2\2m\25\3\2\2\2nt\7$\2\2op\7^\2\2ps\7$\2\2qs\13\2\2"
			+ "\2ro\3\2\2\2rq\3\2\2\2sv\3\2\2\2tu\3\2\2\2tr\3\2\2\2uw\3\2\2\2vt\3\2\2"
			+ "\2w\u0083\7$\2\2x~\7)\2\2yz\7^\2\2z}\7)\2\2{}\13\2\2\2|y\3\2\2\2|{\3\2"
			+ "\2\2}\u0080\3\2\2\2~\177\3\2\2\2~|\3\2\2\2\177\u0081\3\2\2\2\u0080~\3"
			+ "\2\2\2\u0081\u0083\7)\2\2\u0082n\3\2\2\2\u0082x\3\2\2\2\u0083\27\3\2\2"
			+ "\2\u0084\u0085\7.\2\2\u0085\31\3\2\2\2\u0086\u0087\7*\2\2\u0087\33\3\2"
			+ "\2\2\u0088\u0089\7+\2\2\u0089\35\3\2\2\2\u008a\u008b\7&\2\2\u008b\37\3"
			+ "\2\2\2\u008c\u008d\7-\2\2\u008d!\3\2\2\2\u008e\u008f\7,\2\2\u008f#\3\2"
			+ "\2\2\u0090\u0091\7A\2\2\u0091%\3\2\2\2\u0092\u0093\7~\2\2\u0093\'\3\2"
			+ "\2\2\u0094\u0095\7<\2\2\u0095)\3\2\2\2\u0096\u0097\7=\2\2\u0097+\3\2\2"
			+ "\2\u0098\u0099\7\61\2\2\u0099\u009a\7\61\2\2\u009a\u009e\3\2\2\2\u009b"
			+ "\u009d\13\2\2\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009f\3"
			+ "\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1"
			+ "\u00a3\7\17\2\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3"
			+ "\2\2\2\u00a4\u00a6\t\6\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"
			+ "\u00a8\b\26\2\2\u00a8-\3\2\2\2\u00a9\u00aa\7\61\2\2\u00aa\u00ab\7,\2\2"
			+ "\u00ab\u00af\3\2\2\2\u00ac\u00ae\13\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1"
			+ "\3\2\2\2\u00af\u00b0\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1"
			+ "\u00af\3\2\2\2\u00b2\u00b3\7,\2\2\u00b3\u00b4\7\61\2\2\u00b4\u00b5\3\2"
			+ "\2\2\u00b5\u00b6\b\27\2\2\u00b6/\3\2\2\2\u00b7\u00b9\t\7\2\2\u00b8\u00b7"
			+ "\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"
			+ "\u00bc\3\2\2\2\u00bc\u00bd\b\30\2\2\u00bd\61\3\2\2\2\u00be\u00bf\7]\2"
			+ "\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\b\31\3\2\u00c1\63\3\2\2\2\u00c2\u00c3"
			+ "\7_\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\b\32\4\2\u00c5\65\3\2\2\2\u00c6"
			+ "\u00c7\7^\2\2\u00c7\u00ca\t\b\2\2\u00c8\u00ca\n\t\2\2\u00c9\u00c6\3\2"
			+ "\2\2\u00c9\u00c8\3\2\2\2\u00ca\67\3\2\2\2\u00cb\u00cc\7/\2\2\u00cc9\3"
			+ "\2\2\2\22\2\3\\clrt|~\u0082\u009e\u00a2\u00a5\u00af\u00ba\u00c9\5\b\2" + "\2\4\3\2\4\2\2";
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