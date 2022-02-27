// Generated from BdeX.g4 by ANTLR 4.9.2

package BdeX_Language;
import SemanticCheck.*;
import SemanticCheck.Types.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BdeXParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BdeXVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BdeXParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(BdeXParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link BdeXParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(BdeXParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link BdeXParser#declarations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarations(BdeXParser.DeclarationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BdeXParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(BdeXParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createTable}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTable(BdeXParser.CreateTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doubleExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoubleExpr(BdeXParser.DoubleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(BdeXParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(BdeXParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code extractTable}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtractTable(BdeXParser.ExtractTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code readExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadExpr(BdeXParser.ReadExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code joinTable}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinTable(BdeXParser.JoinTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(BdeXParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(BdeXParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(BdeXParser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code signExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignExpr(BdeXParser.SignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multDivRemExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivRemExpr(BdeXParser.MultDivRemExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code createcolumn}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatecolumn(BdeXParser.CreatecolumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(BdeXParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BdeXParser#instruction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruction(BdeXParser.InstructionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BdeXParser#createtable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatetable(BdeXParser.CreatetableContext ctx);
	/**
	 * Visit a parse tree produced by {@link BdeXParser#createColumn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateColumn(BdeXParser.CreateColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link BdeXParser#extract}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtract(BdeXParser.ExtractContext ctx);
	/**
	 * Visit a parse tree produced by {@link BdeXParser#join}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoin(BdeXParser.JoinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inserttoTable}
	 * labeled alternative in {@link BdeXParser#insert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInserttoTable(BdeXParser.InserttoTableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insertColumn}
	 * labeled alternative in {@link BdeXParser#insert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertColumn(BdeXParser.InsertColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code insertIntoCol}
	 * labeled alternative in {@link BdeXParser#insert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertIntoCol(BdeXParser.InsertIntoColContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modifyTableColSel}
	 * labeled alternative in {@link BdeXParser#modify}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyTableColSel(BdeXParser.ModifyTableColSelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modifyTablePos}
	 * labeled alternative in {@link BdeXParser#modify}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyTablePos(BdeXParser.ModifyTablePosContext ctx);
	/**
	 * Visit a parse tree produced by the {@code modifyColPos}
	 * labeled alternative in {@link BdeXParser#modify}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyColPos(BdeXParser.ModifyColPosContext ctx);
	/**
	 * Visit a parse tree produced by {@link BdeXParser#remove}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemove(BdeXParser.RemoveContext ctx);
	/**
	 * Visit a parse tree produced by {@link BdeXParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(BdeXParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link BdeXParser#save}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSave(BdeXParser.SaveContext ctx);
	/**
	 * Visit a parse tree produced by {@link BdeXParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(BdeXParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link BdeXParser#insertStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStat(BdeXParser.InsertStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link BdeXParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(BdeXParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BdeXParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(BdeXParser.TypeContext ctx);
}