// Generated from FracLang.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FracLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FracLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FracLangParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(FracLangParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statDisplay}
	 * labeled alternative in {@link FracLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatDisplay(FracLangParser.StatDisplayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link FracLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssign(FracLangParser.StatAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link FracLangParser#display}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisplay(FracLangParser.DisplayContext ctx);
	/**
	 * Visit a parse tree produced by {@link FracLangParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(FracLangParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprInt}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInt(FracLangParser.ExprIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprRead}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRead(FracLangParser.ExprReadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAddSub}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAddSub(FracLangParser.ExprAddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprParent}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParent(FracLangParser.ExprParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprID}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprID(FracLangParser.ExprIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFrac}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFrac(FracLangParser.ExprFracContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMulDiv}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMulDiv(FracLangParser.ExprMulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprSignal}
	 * labeled alternative in {@link FracLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSignal(FracLangParser.ExprSignalContext ctx);
}