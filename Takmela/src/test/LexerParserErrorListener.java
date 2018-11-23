package test;

import java.util.BitSet;
import java.util.function.Consumer;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class LexerParserErrorListener implements ANTLRErrorListener
{
	private Consumer<String> onError;

	public LexerParserErrorListener(Consumer<String> onError)
	{
		this.onError = onError;
	}

	@Override public void reportAmbiguity(Parser arg0, DFA arg1, int arg2, int arg3, boolean arg4, BitSet arg5,
			ATNConfigSet arg6)
	{

	}

	@Override public void reportAttemptingFullContext(Parser arg0, DFA arg1, int arg2, int arg3, BitSet arg4,
			ATNConfigSet arg5)
	{
		// TODO Auto-generated method stub

	}

	@Override public void reportContextSensitivity(Parser arg0, DFA arg1, int arg2, int arg3, int arg4,
			ATNConfigSet arg5)
	{
		// TODO Auto-generated method stub

	}

	@Override public void syntaxError(Recognizer<?, ?> lexerObj, Object arg1, int line, int col, String msg,
			RecognitionException ex)
	{
		// String errmsg = String.format("%s|%s|%s|%s|%s|%s", lexerObj, arg1, line, col,
		// msg, ex);
		String errmsg = msg;
		onError.accept(msg);
		System.out.println(errmsg);
	}
}
