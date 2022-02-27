// Generated from secondary.g4 by ANTLR 4.9.2

package Secondary_language;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link secondaryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface secondaryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link secondaryParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(secondaryParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link secondaryParser#table}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable(secondaryParser.TableContext ctx);
	/**
	 * Visit a parse tree produced by {@link secondaryParser#columnDeclr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumnDeclr(secondaryParser.ColumnDeclrContext ctx);
	/**
	 * Visit a parse tree produced by {@link secondaryParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(secondaryParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeDouble}
	 * labeled alternative in {@link secondaryParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDouble(secondaryParser.TypeDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeInt}
	 * labeled alternative in {@link secondaryParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInt(secondaryParser.TypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeString}
	 * labeled alternative in {@link secondaryParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeString(secondaryParser.TypeStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link secondaryParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(secondaryParser.ColumnContext ctx);
}