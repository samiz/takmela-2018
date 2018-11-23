// Generated from LexertoolsParser.g4 by ANTLR 4.5
package generatedparser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LexertoolsParser}.
 */
public interface LexertoolsParserListener extends ParseTreeListener
{
	/**
	 * Enter a parse tree produced by {@link LexertoolsParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LexertoolsParser.ProgramContext ctx);

	/**
	 * Exit a parse tree produced by {@link LexertoolsParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LexertoolsParser.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link LexertoolsParser#lexer_rule}.
	 * @param ctx the parse tree
	 */
	void enterLexer_rule(LexertoolsParser.Lexer_ruleContext ctx);

	/**
	 * Exit a parse tree produced by {@link LexertoolsParser#lexer_rule}.
	 * @param ctx the parse tree
	 */
	void exitLexer_rule(LexertoolsParser.Lexer_ruleContext ctx);

	/**
	 * Enter a parse tree produced by {@link LexertoolsParser#within_part}.
	 * @param ctx the parse tree
	 */
	void enterWithin_part(LexertoolsParser.Within_partContext ctx);

	/**
	 * Exit a parse tree produced by {@link LexertoolsParser#within_part}.
	 * @param ctx the parse tree
	 */
	void exitWithin_part(LexertoolsParser.Within_partContext ctx);

	/**
	 * Enter a parse tree produced by {@link LexertoolsParser#pushes_part}.
	 * @param ctx the parse tree
	 */
	void enterPushes_part(LexertoolsParser.Pushes_partContext ctx);

	/**
	 * Exit a parse tree produced by {@link LexertoolsParser#pushes_part}.
	 * @param ctx the parse tree
	 */
	void exitPushes_part(LexertoolsParser.Pushes_partContext ctx);

	/**
	 * Enter a parse tree produced by {@link LexertoolsParser#pops_part}.
	 * @param ctx the parse tree
	 */
	void enterPops_part(LexertoolsParser.Pops_partContext ctx);

	/**
	 * Exit a parse tree produced by {@link LexertoolsParser#pops_part}.
	 * @param ctx the parse tree
	 */
	void exitPops_part(LexertoolsParser.Pops_partContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Oring}
	 * labeled alternative in {@link LexertoolsParser#rx}.
	 * @param ctx the parse tree
	 */
	void enterOring(LexertoolsParser.OringContext ctx);

	/**
	 * Exit a parse tree produced by the {@code Oring}
	 * labeled alternative in {@link LexertoolsParser#rx}.
	 * @param ctx the parse tree
	 */
	void exitOring(LexertoolsParser.OringContext ctx);

	/**
	 * Enter a parse tree produced by the {@code JustSeq}
	 * labeled alternative in {@link LexertoolsParser#rx}.
	 * @param ctx the parse tree
	 */
	void enterJustSeq(LexertoolsParser.JustSeqContext ctx);

	/**
	 * Exit a parse tree produced by the {@code JustSeq}
	 * labeled alternative in {@link LexertoolsParser#rx}.
	 * @param ctx the parse tree
	 */
	void exitJustSeq(LexertoolsParser.JustSeqContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Seqq}
	 * labeled alternative in {@link LexertoolsParser#rx_seq}.
	 * @param ctx the parse tree
	 */
	void enterSeqq(LexertoolsParser.SeqqContext ctx);

	/**
	 * Exit a parse tree produced by the {@code Seqq}
	 * labeled alternative in {@link LexertoolsParser#rx_seq}.
	 * @param ctx the parse tree
	 */
	void exitSeqq(LexertoolsParser.SeqqContext ctx);

	/**
	 * Enter a parse tree produced by the {@code JustPiece}
	 * labeled alternative in {@link LexertoolsParser#rx_seq}.
	 * @param ctx the parse tree
	 */
	void enterJustPiece(LexertoolsParser.JustPieceContext ctx);

	/**
	 * Exit a parse tree produced by the {@code JustPiece}
	 * labeled alternative in {@link LexertoolsParser#rx_seq}.
	 * @param ctx the parse tree
	 */
	void exitJustPiece(LexertoolsParser.JustPieceContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PiecePlus}
	 * labeled alternative in {@link LexertoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPiecePlus(LexertoolsParser.PiecePlusContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PiecePlus}
	 * labeled alternative in {@link LexertoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPiecePlus(LexertoolsParser.PiecePlusContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceString}
	 * labeled alternative in {@link LexertoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPieceString(LexertoolsParser.PieceStringContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceString}
	 * labeled alternative in {@link LexertoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPieceString(LexertoolsParser.PieceStringContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceChar}
	 * labeled alternative in {@link LexertoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPieceChar(LexertoolsParser.PieceCharContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceChar}
	 * labeled alternative in {@link LexertoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPieceChar(LexertoolsParser.PieceCharContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PiecePredefined}
	 * labeled alternative in {@link LexertoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPiecePredefined(LexertoolsParser.PiecePredefinedContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PiecePredefined}
	 * labeled alternative in {@link LexertoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPiecePredefined(LexertoolsParser.PiecePredefinedContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceQuestion}
	 * labeled alternative in {@link LexertoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPieceQuestion(LexertoolsParser.PieceQuestionContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceQuestion}
	 * labeled alternative in {@link LexertoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPieceQuestion(LexertoolsParser.PieceQuestionContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceParened}
	 * labeled alternative in {@link LexertoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPieceParened(LexertoolsParser.PieceParenedContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceParened}
	 * labeled alternative in {@link LexertoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPieceParened(LexertoolsParser.PieceParenedContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceAsterisk}
	 * labeled alternative in {@link LexertoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPieceAsterisk(LexertoolsParser.PieceAsteriskContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceAsterisk}
	 * labeled alternative in {@link LexertoolsParser#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPieceAsterisk(LexertoolsParser.PieceAsteriskContext ctx);

	/**
	 * Enter a parse tree produced by {@link LexertoolsParser#charClass}.
	 * @param ctx the parse tree
	 */
	void enterCharClass(LexertoolsParser.CharClassContext ctx);

	/**
	 * Exit a parse tree produced by {@link LexertoolsParser#charClass}.
	 * @param ctx the parse tree
	 */
	void exitCharClass(LexertoolsParser.CharClassContext ctx);

	/**
	 * Enter a parse tree produced by the {@code RangeCharClassPart}
	 * labeled alternative in {@link LexertoolsParser#charClassPart}.
	 * @param ctx the parse tree
	 */
	void enterRangeCharClassPart(LexertoolsParser.RangeCharClassPartContext ctx);

	/**
	 * Exit a parse tree produced by the {@code RangeCharClassPart}
	 * labeled alternative in {@link LexertoolsParser#charClassPart}.
	 * @param ctx the parse tree
	 */
	void exitRangeCharClassPart(LexertoolsParser.RangeCharClassPartContext ctx);

	/**
	 * Enter a parse tree produced by the {@code SingleCharClassPart}
	 * labeled alternative in {@link LexertoolsParser#charClassPart}.
	 * @param ctx the parse tree
	 */
	void enterSingleCharClassPart(LexertoolsParser.SingleCharClassPartContext ctx);

	/**
	 * Exit a parse tree produced by the {@code SingleCharClassPart}
	 * labeled alternative in {@link LexertoolsParser#charClassPart}.
	 * @param ctx the parse tree
	 */
	void exitSingleCharClassPart(LexertoolsParser.SingleCharClassPartContext ctx);

	/**
	 * Enter a parse tree produced by {@link LexertoolsParser#rangeCh}.
	 * @param ctx the parse tree
	 */
	void enterRangeCh(LexertoolsParser.RangeChContext ctx);

	/**
	 * Exit a parse tree produced by {@link LexertoolsParser#rangeCh}.
	 * @param ctx the parse tree
	 */
	void exitRangeCh(LexertoolsParser.RangeChContext ctx);

	/**
	 * Enter a parse tree produced by {@link LexertoolsParser#singleCh}.
	 * @param ctx the parse tree
	 */
	void enterSingleCh(LexertoolsParser.SingleChContext ctx);

	/**
	 * Exit a parse tree produced by {@link LexertoolsParser#singleCh}.
	 * @param ctx the parse tree
	 */
	void exitSingleCh(LexertoolsParser.SingleChContext ctx);
}