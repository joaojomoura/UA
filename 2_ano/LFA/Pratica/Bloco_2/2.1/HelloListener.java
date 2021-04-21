// Generated from Hello.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(HelloParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(HelloParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#greetings}.
	 * @param ctx the parse tree
	 */
	void enterGreetings(HelloParser.GreetingsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#greetings}.
	 * @param ctx the parse tree
	 */
	void exitGreetings(HelloParser.GreetingsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#farewell}.
	 * @param ctx the parse tree
	 */
	void enterFarewell(HelloParser.FarewellContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#farewell}.
	 * @param ctx the parse tree
	 */
	void exitFarewell(HelloParser.FarewellContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(HelloParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(HelloParser.NameContext ctx);
}