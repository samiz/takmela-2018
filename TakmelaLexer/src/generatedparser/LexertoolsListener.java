// Generated from Lexertools.g4 by ANTLR 4.5
package generatedparser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Lexertools}.
 */
public interface LexertoolsListener extends ParseTreeListener
{
	/**
	 * Enter a parse tree produced by {@link Lexertools#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(Lexertools.ProgramContext ctx);

	/**
	 * Exit a parse tree produced by {@link Lexertools#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(Lexertools.ProgramContext ctx);

	/**
	 * Enter a parse tree produced by {@link Lexertools#lexer_rule}.
	 * @param ctx the parse tree
	 */
	void enterLexer_rule(Lexertools.Lexer_ruleContext ctx);

	/**
	 * Exit a parse tree produced by {@link Lexertools#lexer_rule}.
	 * @param ctx the parse tree
	 */
	void exitLexer_rule(Lexertools.Lexer_ruleContext ctx);

	/**
	 * Enter a parse tree produced by {@link Lexertools#within_part}.
	 * @param ctx the parse tree
	 */
	void enterWithin_part(Lexertools.Within_partContext ctx);

	/**
	 * Exit a parse tree produced by {@link Lexertools#within_part}.
	 * @param ctx the parse tree
	 */
	void exitWithin_part(Lexertools.Within_partContext ctx);

	/**
	 * Enter a parse tree produced by {@link Lexertools#pushes_part}.
	 * @param ctx the parse tree
	 */
	void enterPushes_part(Lexertools.Pushes_partContext ctx);

	/**
	 * Exit a parse tree produced by {@link Lexertools#pushes_part}.
	 * @param ctx the parse tree
	 */
	void exitPushes_part(Lexertools.Pushes_partContext ctx);

	/**
	 * Enter a parse tree produced by {@link Lexertools#pops_part}.
	 * @param ctx the parse tree
	 */
	void enterPops_part(Lexertools.Pops_partContext ctx);

	/**
	 * Exit a parse tree produced by {@link Lexertools#pops_part}.
	 * @param ctx the parse tree
	 */
	void exitPops_part(Lexertools.Pops_partContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Oring}
	 * labeled alternative in {@link Lexertools#rx}.
	 * @param ctx the parse tree
	 */
	void enterOring(Lexertools.OringContext ctx);

	/**
	 * Exit a parse tree produced by the {@code Oring}
	 * labeled alternative in {@link Lexertools#rx}.
	 * @param ctx the parse tree
	 */
	void exitOring(Lexertools.OringContext ctx);

	/**
	 * Enter a parse tree produced by the {@code JustSeq}
	 * labeled alternative in {@link Lexertools#rx}.
	 * @param ctx the parse tree
	 */
	void enterJustSeq(Lexertools.JustSeqContext ctx);

	/**
	 * Exit a parse tree produced by the {@code JustSeq}
	 * labeled alternative in {@link Lexertools#rx}.
	 * @param ctx the parse tree
	 */
	void exitJustSeq(Lexertools.JustSeqContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Seqq}
	 * labeled alternative in {@link Lexertools#seq}.
	 * @param ctx the parse tree
	 */
	void enterSeqq(Lexertools.SeqqContext ctx);

	/**
	 * Exit a parse tree produced by the {@code Seqq}
	 * labeled alternative in {@link Lexertools#seq}.
	 * @param ctx the parse tree
	 */
	void exitSeqq(Lexertools.SeqqContext ctx);

	/**
	 * Enter a parse tree produced by the {@code JustPiece}
	 * labeled alternative in {@link Lexertools#seq}.
	 * @param ctx the parse tree
	 */
	void enterJustPiece(Lexertools.JustPieceContext ctx);

	/**
	 * Exit a parse tree produced by the {@code JustPiece}
	 * labeled alternative in {@link Lexertools#seq}.
	 * @param ctx the parse tree
	 */
	void exitJustPiece(Lexertools.JustPieceContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PiecePlus}
	 * labeled alternative in {@link Lexertools#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPiecePlus(Lexertools.PiecePlusContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PiecePlus}
	 * labeled alternative in {@link Lexertools#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPiecePlus(Lexertools.PiecePlusContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceString}
	 * labeled alternative in {@link Lexertools#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPieceString(Lexertools.PieceStringContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceString}
	 * labeled alternative in {@link Lexertools#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPieceString(Lexertools.PieceStringContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceChar}
	 * labeled alternative in {@link Lexertools#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPieceChar(Lexertools.PieceCharContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceChar}
	 * labeled alternative in {@link Lexertools#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPieceChar(Lexertools.PieceCharContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PiecePredefined}
	 * labeled alternative in {@link Lexertools#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPiecePredefined(Lexertools.PiecePredefinedContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PiecePredefined}
	 * labeled alternative in {@link Lexertools#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPiecePredefined(Lexertools.PiecePredefinedContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceParened}
	 * labeled alternative in {@link Lexertools#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPieceParened(Lexertools.PieceParenedContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceParened}
	 * labeled alternative in {@link Lexertools#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPieceParened(Lexertools.PieceParenedContext ctx);

	/**
	 * Enter a parse tree produced by the {@code PieceAsterisk}
	 * labeled alternative in {@link Lexertools#rxpiece}.
	 * @param ctx the parse tree
	 */
	void enterPieceAsterisk(Lexertools.PieceAsteriskContext ctx);

	/**
	 * Exit a parse tree produced by the {@code PieceAsterisk}
	 * labeled alternative in {@link Lexertools#rxpiece}.
	 * @param ctx the parse tree
	 */
	void exitPieceAsterisk(Lexertools.PieceAsteriskContext ctx);

	/**
	 * Enter a parse tree produced by {@link Lexertools#charClass}.
	 * @param ctx the parse tree
	 */
	void enterCharClass(Lexertools.CharClassContext ctx);

	/**
	 * Exit a parse tree produced by {@link Lexertools#charClass}.
	 * @param ctx the parse tree
	 */
	void exitCharClass(Lexertools.CharClassContext ctx);

	/**
	 * Enter a parse tree produced by {@link Lexertools#rangeCh}.
	 * @param ctx the parse tree
	 */
	void enterRangeCh(Lexertools.RangeChContext ctx);

	/**
	 * Exit a parse tree produced by {@link Lexertools#rangeCh}.
	 * @param ctx the parse tree
	 */
	void exitRangeCh(Lexertools.RangeChContext ctx);

	/**
	 * Enter a parse tree produced by {@link Lexertools#singleCh}.
	 * @param ctx the parse tree
	 */
	void enterSingleCh(Lexertools.SingleChContext ctx);

	/**
	 * Exit a parse tree produced by {@link Lexertools#singleCh}.
	 * @param ctx the parse tree
	 */
	void exitSingleCh(Lexertools.SingleChContext ctx);
}