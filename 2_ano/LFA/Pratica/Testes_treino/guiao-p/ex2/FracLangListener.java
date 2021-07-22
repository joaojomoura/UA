// Generated from FracLang.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FracLangParser}.
 */
public interface FracLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FracLangParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(FracLangParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link FracLangParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(FracLangParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statDisplay}
	 * labeled alternative in {@link FracLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatDisplay(FracLangParser.StatDisplayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statDisplay}
	 * labeled alternative in {@link FracLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatDisplay(FracLangParser.StatDisplayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link FracLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAssign(FracLangParser.StatAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link FracLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAssign(FracLangParser.StatAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link FracLangParser#display}.
	 * @param ctx the parse tree
	 */
	void enterDisplay(FracLangParser.DisplayContext ctx);
	/**
	 * Exit a parse tree produced by {@link FracLangParser#display}.
	 * @param ctx the parse tree
	 */
	void exitDisplay(FracLangParser.DisplayContext ctx);
	/**
	 * Enter a parse tree produced by {@link FracLangParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(FracLangParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link FracLangParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(FracLangParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprInt}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprInt(FracLangParser.ExprIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprInt}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprInt(FracLangParser.ExprIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprRead}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprRead(FracLangParser.ExprReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprRead}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprRead(FracLangParser.ExprReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAddSub}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAddSub(FracLangParser.ExprAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAddSub}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAddSub(FracLangParser.ExprAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprParent}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParent(FracLangParser.ExprParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprParent}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParent(FracLangParser.ExprParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprID}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(FracLangParser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprID}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(FracLangParser.ExprIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprFrac}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprFrac(FracLangParser.ExprFracContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprFrac}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprFrac(FracLangParser.ExprFracContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMulDiv}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMulDiv(FracLangParser.ExprMulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMulDiv}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMulDiv(FracLangParser.ExprMulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSignal}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSignal(FracLangParser.ExprSignalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSignal}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSignal(FracLangParser.ExprSignalContext ctx);
}