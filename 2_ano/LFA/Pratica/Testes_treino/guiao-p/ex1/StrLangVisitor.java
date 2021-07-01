// Generated from StrLang.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link StrLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface StrLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link StrLangParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(StrLangParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statPrint}
	 * labeled alternative in {@link StrLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatPrint(StrLangParser.StatPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link StrLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatAssign(StrLangParser.StatAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link StrLangParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(StrLangParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link StrLangParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(StrLangParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprString}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprString(StrLangParser.ExprStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprID}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprID(StrLangParser.ExprIDContext ctx);
}