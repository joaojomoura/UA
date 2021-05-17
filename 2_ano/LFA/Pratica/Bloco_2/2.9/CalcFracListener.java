// Generated from CalcFrac.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcFracParser}.
 */
public interface CalcFracListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalcFracParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(CalcFracParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcFracParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(CalcFracParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatExpr}
	 * labeled alternative in {@link CalcFracParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatExpr(CalcFracParser.StatExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatExpr}
	 * labeled alternative in {@link CalcFracParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatExpr(CalcFracParser.StatExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatPrint}
	 * labeled alternative in {@link CalcFracParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatPrint(CalcFracParser.StatPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatPrint}
	 * labeled alternative in {@link CalcFracParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatPrint(CalcFracParser.StatPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StatAssign}
	 * labeled alternative in {@link CalcFracParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAssign(CalcFracParser.StatAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StatAssign}
	 * labeled alternative in {@link CalcFracParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAssign(CalcFracParser.StatAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcFracParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(CalcFracParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcFracParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(CalcFracParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalcFracParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(CalcFracParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcFracParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(CalcFracParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprAddSub(CalcFracParser.ExprAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAddSub}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprAddSub(CalcFracParser.ExprAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprParent(CalcFracParser.ExprParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParent}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprParent(CalcFracParser.ExprParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNumber(CalcFracParser.ExprNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNumber}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNumber(CalcFracParser.ExprNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDiv(CalcFracParser.ExprMultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDiv(CalcFracParser.ExprMultDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSignal}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSignal(CalcFracParser.ExprSignalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSignal}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSignal(CalcFracParser.ExprSignalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(CalcFracParser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprID}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(CalcFracParser.ExprIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprFraction}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprFraction(CalcFracParser.ExprFractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprFraction}
	 * labeled alternative in {@link CalcFracParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprFraction(CalcFracParser.ExprFractionContext ctx);
}