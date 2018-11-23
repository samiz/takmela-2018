// Generated from ParsetoolsParser.g4 by ANTLR 4.5
package generatedparser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ParsetoolsParser}.
 */
public interface ParsetoolsParserListener extends ParseTreeListener
{
	/**
	 * Enter a parse tree produced by {@link ParsetoolsParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ParsetoolsParser.ProgramContext ctx);

	/**
	 * Exit a parse tree produced by {@link ParsetoolsParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ParsetoolsParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link ParsetoolsParser#grammar_rule}.
	 * @param ctx the parse tree
	 */
	void enterGrammar_rule(ParsetoolsParser.Grammar_ruleContext ctx);

	/**
	 * Exit a parse tree produced by {@link ParsetoolsParser#grammar_rule}.
	 * @param ctx the parse tree
	 */
	void exitGrammar_rule(ParsetoolsParser.Grammar_ruleContext ctx);

	/**
	 * Enter a parse tree produced by {@link ParsetoolsParser#seq}.
	 * @param ctx the parse tree
	 */
	void enterSeq(ParsetoolsParser.SeqContext ctx);

	/**
	 * Exit a parse tree produced by {@link ParsetoolsParser#seq}.
	 * @param ctx the parse tree
	 */
	void exitSeq(ParsetoolsParser.SeqContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceTerminal}
	 * labeled alternative in {@link ParsetoolsParser#piece}.
	 * @param ctx the parse tree
	 */
	void enterPieceTerminal(ParsetoolsParser.PieceTerminalContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceTerminal}
	 * labeled alternative in {@link ParsetoolsParser#piece}.
	 * @param ctx the parse tree
	 */
	void exitPieceTerminal(ParsetoolsParser.PieceTerminalContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceCall}
	 * labeled alternative in {@link ParsetoolsParser#piece}.
	 * @param ctx the parse tree
	 */
	void enterPieceCall(ParsetoolsParser.PieceCallContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceCall}
	 * labeled alternative in {@link ParsetoolsParser#piece}.
	 * @param ctx the parse tree
	 */
	void exitPieceCall(ParsetoolsParser.PieceCallContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceToken}
	 * labeled alternative in {@link ParsetoolsParser#piece}.
	 * @param ctx the parse tree
	 */
	void enterPieceToken(ParsetoolsParser.PieceTokenContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceToken}
	 * labeled alternative in {@link ParsetoolsParser#piece}.
	 * @param ctx the parse tree
	 */
	void exitPieceToken(ParsetoolsParser.PieceTokenContext ctx);

	/**
	 * Enter a parse tree produced by {@link ParsetoolsParser#lexer_rule}.
	 * @param ctx the parse tree
	 */
	void enterLexer_rule(ParsetoolsParser.Lexer_ruleContext ctx);

	/**
	 * Exit a parse tree produced by {@link ParsetoolsParser#lexer_rule}.
	 * @param ctx the parse tree
	 */
	void exitLexer_rule(ParsetoolsParser.Lexer_ruleContext ctx);

	/**
	 * Enter a parse tree produced by {@link ParsetoolsParser#within_part}.
	 * @param ctx the parse tree
	 */
	void enterWithin_part(ParsetoolsParser.Within_partContext ctx);

	/**
	 * Exit a parse tree produced by {@link ParsetoolsParser#within_part}.
	 * @param ctx the parse tree
	 */
	void exitWithin_part(ParsetoolsParser.Within_partContext ctx);

	/**
	 * Enter a parse tree produced by {@link ParsetoolsParser#pushes_part}.
	 * @param ctx the parse tree
	 */
	void enterPushes_part(ParsetoolsParser.Pushes_partContext ctx);

	/**
	 * Exit a parse tree produced by {@link ParsetoolsParser#pushes_part}.
	 * @param ctx the parse tree
	 */
	void exitPushes_part(ParsetoolsParser.Pushes_partContext ctx);

	/**
	 * Enter a parse tree produced by {@link ParsetoolsParser#pops_part}.
	 * @param ctx the parse tree
	 */
	void enterPops_part(ParsetoolsParser.Pops_partContext ctx);

	/**
	 * Exit a parse tree produced by {@link ParsetoolsParser#pops_part}.
	 * @param ctx the parse tree
	 */
	void exitPops_part(ParsetoolsParser.Pops_partContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Oring}
	 * labeled alternative in {@link ParsetoolsParser#rx}.
	 * @param ctx the parse tree
	 */
	void enterOring(ParsetoolsParser.OringContext ctx);

	/**
	 * Exit a parse tree produced by the {@code Oring}
	 * labeled alternative in {@link ParsetoolsParser#rx}.
	 * @param ctx the parse tree
	 */
	void exitOring(ParsetoolsParser.OringContext ctx);

	/**
	 * Enter a parse tree produced by the {@code JustSeq}
	 * labeled alternative in {@link ParsetoolsParser#rx}.
	 * @param ctx the parse tree
	 */
	void enterJustSeq(ParsetoolsParser.JustSeqContext ctx);

	/**
	 * Exit a parse tree produced by the {@code JustSeq}
	 * labeled alternative in {@link ParsetoolsParser#rx}.
	 * @param ctx the parse tree
	 */
	void exitJustSeq(ParsetoolsParser.JustSeqContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Seqq}
	 * labeled alternative in {@link ParsetoolsParser#rx_seq}.
	 * @param ctx the parse tree
	 */
	void enterSeqq(ParsetoolsParser.SeqqContext ctx);

	/**
	 * Exit a parse tree produced by the {@code Seqq}
	 * labeled alternative in {@link ParsetoolsParser#rx_seq}.
	 * @param ctx the parse tree
	 */
	void exitSeqq(ParsetoolsParser.SeqqContext ctx);

	/**
	 * Enter a parse tree produced by the {@code JustPiece}
	 * labeled alternative in {@link ParsetoolsParser#rx_seq}.
	 * @param ctx the parse tree
	 */
	void enterJustPiece(ParsetoolsParser.JustPieceContext ctx);

	/**
	 * Exit a parse tree produced by the {@code JustPiece}
	 * labeled alternative in {@link ParsetoolsParser#rx_seq}.
	 * @param ctx the parse tree
	 */
	void exitJustPiece(ParsetoolsParser.JustPieceContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PiecePlus}
	 * labeled alternative in {@link ParsetoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPiecePlus(ParsetoolsParser.PiecePlusContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PiecePlus}
	 * labeled alternative in {@link ParsetoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPiecePlus(ParsetoolsParser.PiecePlusContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceString}
	 * labeled alternative in {@link ParsetoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPieceString(ParsetoolsParser.PieceStringContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceString}
	 * labeled alternative in {@link ParsetoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPieceString(ParsetoolsParser.PieceStringContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceChar}
	 * labeled alternative in {@link ParsetoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPieceChar(ParsetoolsParser.PieceCharContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceChar}
	 * labeled alternative in {@link ParsetoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPieceChar(ParsetoolsParser.PieceCharContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PiecePredefined}
	 * labeled alternative in {@link ParsetoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPiecePredefined(ParsetoolsParser.PiecePredefinedContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PiecePredefined}
	 * labeled alternative in {@link ParsetoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPiecePredefined(ParsetoolsParser.PiecePredefinedContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceQuestion}
	 * labeled alternative in {@link ParsetoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPieceQuestion(ParsetoolsParser.PieceQuestionContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceQuestion}
	 * labeled alternative in {@link ParsetoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPieceQuestion(ParsetoolsParser.PieceQuestionContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceParened}
	 * labeled alternative in {@link ParsetoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPieceParened(ParsetoolsParser.PieceParenedContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceParened}
	 * labeled alternative in {@link ParsetoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPieceParened(ParsetoolsParser.PieceParenedContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceAsterisk}
	 * labeled alternative in {@link ParsetoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPieceAsterisk(ParsetoolsParser.PieceAsteriskContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceAsterisk}
	 * labeled alternative in {@link ParsetoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPieceAsterisk(ParsetoolsParser.PieceAsteriskContext ctx);

	/**
	 * Enter a parse tree produced by {@link ParsetoolsParser#charClass}.
	 * @param ctx the parse tree
	 */
	void enterCharClass(ParsetoolsParser.CharClassContext ctx);

	/**
	 * Exit a parse tree produced by {@link ParsetoolsParser#charClass}.
	 * @param ctx the parse tree
	 */
	void exitCharClass(ParsetoolsParser.CharClassContext ctx);

	/**
	 * Enter a parse tree produced by the {@code RangeCharClassPart}
	 * labeled alternative in {@link ParsetoolsParser#charClassPart}.
	 * @param ctx the parse tree
	 */
	void enterRangeCharClassPart(ParsetoolsParser.RangeCharClassPartContext ctx);

	/**
	 * Exit a parse tree produced by the {@code RangeCharClassPart}
	 * labeled alternative in {@link ParsetoolsParser#charClassPart}.
	 * @param ctx the parse tree
	 */
	void exitRangeCharClassPart(ParsetoolsParser.RangeCharClassPartContext ctx);

	/**
	 * Enter a parse tree produced by the {@code SingleCharClassPart}
	 * labeled alternative in {@link ParsetoolsParser#charClassPart}.
	 * @param ctx the parse tree
	 */
	void enterSingleCharClassPart(ParsetoolsParser.SingleCharClassPartContext ctx);

	/**
	 * Exit a parse tree produced by the {@code SingleCharClassPart}
	 * labeled alternative in {@link ParsetoolsParser#charClassPart}.
	 * @param ctx the parse tree
	 */
	void exitSingleCharClassPart(ParsetoolsParser.SingleCharClassPartContext ctx);

	/**
	 * Enter a parse tree produced by {@link ParsetoolsParser#rangeCh}.
	 * @param ctx the parse tree
	 */
	void enterRangeCh(ParsetoolsParser.RangeChContext ctx);

	/**
	 * Exit a parse tree produced by {@link ParsetoolsParser#rangeCh}.
	 * @param ctx the parse tree
	 */
	void exitRangeCh(ParsetoolsParser.RangeChContext ctx);

	/**
	 * Enter a parse tree produced by {@link ParsetoolsParser#singleCh}.
	 * @param ctx the parse tree
	 */
	void enterSingleCh(ParsetoolsParser.SingleChContext ctx);

	/**
	 * Exit a parse tree produced by {@link ParsetoolsParser#singleCh}.
	 * @param ctx the parse tree
	 */
	void exitSingleCh(ParsetoolsParser.SingleChContext ctx);
}