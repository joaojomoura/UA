// Generated from StrLang.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link StrLangParser}.
 */
public interface StrLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link StrLangParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(StrLangParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link StrLangParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(StrLangParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statPrint}
	 * labeled alternative in {@link StrLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatPrint(StrLangParser.StatPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statPrint}
	 * labeled alternative in {@link StrLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatPrint(StrLangParser.StatPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link StrLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStatAssign(StrLangParser.StatAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statAssign}
	 * labeled alternative in {@link StrLangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStatAssign(StrLangParser.StatAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link StrLangParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(StrLangParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link StrLangParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(StrLangParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link StrLangParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(StrLangParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link StrLangParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(StrLangParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprString}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprString(StrLangParser.ExprStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprString}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprString(StrLangParser.ExprStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprID}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprID(StrLangParser.ExprIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprID}
	 * labeled alternative in {@link StrLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprID(StrLangParser.ExprIDContext ctx);
}