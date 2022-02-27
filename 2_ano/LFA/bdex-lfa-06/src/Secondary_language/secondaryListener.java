// Generated from secondary.g4 by ANTLR 4.9.2

package Secondary_language;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link secondaryParser}.
 */
public interface secondaryListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link secondaryParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(secondaryParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link secondaryParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(secondaryParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link secondaryParser#table}.
	 * @param ctx the parse tree
	 */
	void enterTable(secondaryParser.TableContext ctx);
	/**
	 * Exit a parse tree produced by {@link secondaryParser#table}.
	 * @param ctx the parse tree
	 */
	void exitTable(secondaryParser.TableContext ctx);
	/**
	 * Enter a parse tree produced by {@link secondaryParser#columnDeclr}.
	 * @param ctx the parse tree
	 */
	void enterColumnDeclr(secondaryParser.ColumnDeclrContext ctx);
	/**
	 * Exit a parse tree produced by {@link secondaryParser#columnDeclr}.
	 * @param ctx the parse tree
	 */
	void exitColumnDeclr(secondaryParser.ColumnDeclrContext ctx);
	/**
	 * Enter a parse tree produced by {@link secondaryParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(secondaryParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link secondaryParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(secondaryParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeDouble}
	 * labeled alternative in {@link secondaryParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeDouble(secondaryParser.TypeDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeDouble}
	 * labeled alternative in {@link secondaryParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeDouble(secondaryParser.TypeDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link secondaryParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeInt(secondaryParser.TypeIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link secondaryParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeInt(secondaryParser.TypeIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeString}
	 * labeled alternative in {@link secondaryParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeString(secondaryParser.TypeStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeString}
	 * labeled alternative in {@link secondaryParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeString(secondaryParser.TypeStringContext ctx);
	/**
	 * Enter a parse tree produced by {@link secondaryParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(secondaryParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link secondaryParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(secondaryParser.ColumnContext ctx);
}