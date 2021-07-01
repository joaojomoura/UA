// Generated from Teste.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TesteParser}.
 */
public interface TesteListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TesteParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(TesteParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link TesteParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(TesteParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link TesteParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(TesteParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link TesteParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(TesteParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprInt}
	 * labeled alternative in {@link TesteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprInt(TesteParser.ExprIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprInt}
	 * labeled alternative in {@link TesteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprInt(TesteParser.ExprIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprString}
	 * labeled alternative in {@link TesteParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprString(TesteParser.ExprStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprString}
	 * labeled alternative in {@link TesteParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprString(TesteParser.ExprStringContext ctx);
}