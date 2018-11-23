// Generated from LexertoolsLexer.g4 by ANTLR 4.5
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
public class LexertoolsLexer extends Lexer
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
	public static final int IN_CHARCLASS = 1;
	public static String[] modeNames = { "DEFAULT_MODE", "IN_CHARCLASS" };

	public static final String[] ruleNames = { "KW_WITHIN", "KW_PUSHES", "KW_POPS", "KW_CLASS", "KW_SKIP", "IDCap",
			"INT", "STRING", "COMMA", "OPAREN", "CPAREN", "DOLLAR", "PLUS", "STAR", "QUESTION", "BAR", "COLON", "SEMI",
			"COMMENT2", "COMMENT", "WS", "START_CHARCLASS", "END_CHARCLASS", "CHAR", "DASH" };

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

	public LexertoolsLexer(CharStream input)
	{
		super(input);
		_interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	@Override public String getGrammarFileName()
	{
		return "LexertoolsLexer.g4";
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

	public static final String _serializedATN = "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u00bf\b\1\b\1"
			+ "\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t"
			+ "\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4"
			+ "\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4"
			+ "\31\t\31\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"
			+ "\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"
			+ "\7\3\7\7\7W\n\7\f\7\16\7Z\13\7\3\b\6\b]\n\b\r\b\16\b^\3\t\3\t\3\t\3\t"
			+ "\7\te\n\t\f\t\16\th\13\t\3\t\3\t\3\t\3\t\3\t\7\to\n\t\f\t\16\tr\13\t\3"
			+ "\t\5\tu\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"
			+ "\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u008f\n\24"
			+ "\f\24\16\24\u0092\13\24\3\24\5\24\u0095\n\24\3\24\5\24\u0098\n\24\3\24"
			+ "\3\24\3\25\3\25\3\25\3\25\7\25\u00a0\n\25\f\25\16\25\u00a3\13\25\3\25"
			+ "\3\25\3\25\3\25\3\25\3\26\6\26\u00ab\n\26\r\26\16\26\u00ac\3\26\3\26\3"
			+ "\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\5\31\u00bc\n\31"
			+ "\3\32\3\32\6fp\u0090\u00a1\2\33\4\3\6\4\b\5\n\6\f\7\16\b\20\t\22\n\24"
			+ "\13\26\f\30\r\32\16\34\17\36\20 \21\"\22$\23&\24(\25*\26,\27.\30\60\31"
			+ "\62\32\64\33\4\2\3\t\4\2C\\aa\6\2\62;C\\aac|\3\2\62;\3\3\f\f\5\2\13\f"
			+ "\17\17\"\"\t\2$$))//^^ppttvv\6\2$$))//^^\u00c9\2\4\3\2\2\2\2\6\3\2\2\2"
			+ "\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3\2\2\2\2\20\3\2\2\2\2\22\3"
			+ "\2\2\2\2\24\3\2\2\2\2\26\3\2\2\2\2\30\3\2\2\2\2\32\3\2\2\2\2\34\3\2\2"
			+ "\2\2\36\3\2\2\2\2 \3\2\2\2\2\"\3\2\2\2\2$\3\2\2\2\2&\3\2\2\2\2(\3\2\2"
			+ "\2\2*\3\2\2\2\2,\3\2\2\2\2.\3\2\2\2\3\60\3\2\2\2\3\62\3\2\2\2\3\64\3\2"
			+ "\2\2\4\66\3\2\2\2\6=\3\2\2\2\bD\3\2\2\2\nI\3\2\2\2\fO\3\2\2\2\16T\3\2"
			+ "\2\2\20\\\3\2\2\2\22t\3\2\2\2\24v\3\2\2\2\26x\3\2\2\2\30z\3\2\2\2\32|"
			+ "\3\2\2\2\34~\3\2\2\2\36\u0080\3\2\2\2 \u0082\3\2\2\2\"\u0084\3\2\2\2$"
			+ "\u0086\3\2\2\2&\u0088\3\2\2\2(\u008a\3\2\2\2*\u009b\3\2\2\2,\u00aa\3\2"
			+ "\2\2.\u00b0\3\2\2\2\60\u00b4\3\2\2\2\62\u00bb\3\2\2\2\64\u00bd\3\2\2\2"
			+ "\66\67\7y\2\2\678\7k\2\289\7v\2\29:\7j\2\2:;\7k\2\2;<\7p\2\2<\5\3\2\2"
			+ "\2=>\7r\2\2>?\7w\2\2?@\7u\2\2@A\7j\2\2AB\7g\2\2BC\7u\2\2C\7\3\2\2\2DE"
			+ "\7r\2\2EF\7q\2\2FG\7r\2\2GH\7u\2\2H\t\3\2\2\2IJ\7e\2\2JK\7n\2\2KL\7c\2"
			+ "\2LM\7u\2\2MN\7u\2\2N\13\3\2\2\2OP\7u\2\2PQ\7m\2\2QR\7k\2\2RS\7r\2\2S"
			+ "\r\3\2\2\2TX\t\2\2\2UW\t\3\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2"
			+ "Y\17\3\2\2\2ZX\3\2\2\2[]\t\4\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2"
			+ "\2\2_\21\3\2\2\2`f\7$\2\2ab\7^\2\2be\7$\2\2ce\13\2\2\2da\3\2\2\2dc\3\2"
			+ "\2\2eh\3\2\2\2fg\3\2\2\2fd\3\2\2\2gi\3\2\2\2hf\3\2\2\2iu\7$\2\2jp\7)\2"
			+ "\2kl\7^\2\2lo\7)\2\2mo\13\2\2\2nk\3\2\2\2nm\3\2\2\2or\3\2\2\2pq\3\2\2"
			+ "\2pn\3\2\2\2qs\3\2\2\2rp\3\2\2\2su\7)\2\2t`\3\2\2\2tj\3\2\2\2u\23\3\2"
			+ "\2\2vw\7.\2\2w\25\3\2\2\2xy\7*\2\2y\27\3\2\2\2z{\7+\2\2{\31\3\2\2\2|}"
			+ "\7&\2\2}\33\3\2\2\2~\177\7-\2\2\177\35\3\2\2\2\u0080\u0081\7,\2\2\u0081"
			+ "\37\3\2\2\2\u0082\u0083\7A\2\2\u0083!\3\2\2\2\u0084\u0085\7~\2\2\u0085"
			+ "#\3\2\2\2\u0086\u0087\7<\2\2\u0087%\3\2\2\2\u0088\u0089\7=\2\2\u0089\'"
			+ "\3\2\2\2\u008a\u008b\7\61\2\2\u008b\u008c\7\61\2\2\u008c\u0090\3\2\2\2"
			+ "\u008d\u008f\13\2\2\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u0091"
			+ "\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0093"
			+ "\u0095\7\17\2\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3"
			+ "\2\2\2\u0096\u0098\t\5\2\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099"
			+ "\u009a\b\24\2\2\u009a)\3\2\2\2\u009b\u009c\7\61\2\2\u009c\u009d\7,\2\2"
			+ "\u009d\u00a1\3\2\2\2\u009e\u00a0\13\2\2\2\u009f\u009e\3\2\2\2\u00a0\u00a3"
			+ "\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3"
			+ "\u00a1\3\2\2\2\u00a4\u00a5\7,\2\2\u00a5\u00a6\7\61\2\2\u00a6\u00a7\3\2"
			+ "\2\2\u00a7\u00a8\b\25\2\2\u00a8+\3\2\2\2\u00a9\u00ab\t\6\2\2\u00aa\u00a9"
			+ "\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"
			+ "\u00ae\3\2\2\2\u00ae\u00af\b\26\2\2\u00af-\3\2\2\2\u00b0\u00b1\7]\2\2"
			+ "\u00b1\u00b2\3\2\2\2\u00b2\u00b3\b\27\3\2\u00b3/\3\2\2\2\u00b4\u00b5\7"
			+ "_\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b\30\4\2\u00b7\61\3\2\2\2\u00b8"
			+ "\u00b9\7^\2\2\u00b9\u00bc\t\7\2\2\u00ba\u00bc\n\b\2\2\u00bb\u00b8\3\2"
			+ "\2\2\u00bb\u00ba\3\2\2\2\u00bc\63\3\2\2\2\u00bd\u00be\7/\2\2\u00be\65"
			+ "\3\2\2\2\21\2\3X^dfnpt\u0090\u0094\u0097\u00a1\u00ac\u00bb\5\b\2\2\4\3" + "\2\4\2\2";
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