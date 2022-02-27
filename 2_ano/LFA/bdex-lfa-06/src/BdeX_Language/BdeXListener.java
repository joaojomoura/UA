// Generated from BdeX.g4 by ANTLR 4.9.2

package BdeX_Language;
import SemanticCheck.*;
import SemanticCheck.Types.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BdeXParser}.
 */
public interface BdeXListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BdeXParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(BdeXParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link BdeXParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(BdeXParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link BdeXParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(BdeXParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link BdeXParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(BdeXParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link BdeXParser#declarations}.
	 * @param ctx the parse tree
	 */
	void enterDeclarations(BdeXParser.DeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BdeXParser#declarations}.
	 * @param ctx the parse tree
	 */
	void exitDeclarations(BdeXParser.DeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BdeXParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(BdeXParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BdeXParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(BdeXParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createTable}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCreateTable(BdeXParser.CreateTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createTable}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCreateTable(BdeXParser.CreateTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doubleExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDoubleExpr(BdeXParser.DoubleExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doubleExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDoubleExpr(BdeXParser.DoubleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(BdeXParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(BdeXParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(BdeXParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(BdeXParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code extractTable}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExtractTable(BdeXParser.ExtractTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code extractTable}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExtractTable(BdeXParser.ExtractTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code readExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterReadExpr(BdeXParser.ReadExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code readExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitReadExpr(BdeXParser.ReadExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code joinTable}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterJoinTable(BdeXParser.JoinTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code joinTable}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitJoinTable(BdeXParser.JoinTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(BdeXParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(BdeXParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(BdeXParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(BdeXParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(BdeXParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(BdeXParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code signExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSignExpr(BdeXParser.SignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code signExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSignExpr(BdeXParser.SignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multDivRemExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultDivRemExpr(BdeXParser.MultDivRemExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multDivRemExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultDivRemExpr(BdeXParser.MultDivRemExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code createcolumn}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCreatecolumn(BdeXParser.CreatecolumnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code createcolumn}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCreatecolumn(BdeXParser.CreatecolumnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(BdeXParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link BdeXParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(BdeXParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BdeXParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterInstruction(BdeXParser.InstructionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BdeXParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitInstruction(BdeXParser.InstructionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BdeXParser#createtable}.
	 * @param ctx the parse tree
	 */
	void enterCreatetable(BdeXParser.CreatetableContext ctx);
	/**
	 * Exit a parse tree produced by {@link BdeXParser#createtable}.
	 * @param ctx the parse tree
	 */
	void exitCreatetable(BdeXParser.CreatetableContext ctx);
	/**
	 * Enter a parse tree produced by {@link BdeXParser#createColumn}.
	 * @param ctx the parse tree
	 */
	void enterCreateColumn(BdeXParser.CreateColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link BdeXParser#createColumn}.
	 * @param ctx the parse tree
	 */
	void exitCreateColumn(BdeXParser.CreateColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link BdeXParser#extract}.
	 * @param ctx the parse tree
	 */
	void enterExtract(BdeXParser.ExtractContext ctx);
	/**
	 * Exit a parse tree produced by {@link BdeXParser#extract}.
	 * @param ctx the parse tree
	 */
	void exitExtract(BdeXParser.ExtractContext ctx);
	/**
	 * Enter a parse tree produced by {@link BdeXParser#join}.
	 * @param ctx the parse tree
	 */
	void enterJoin(BdeXParser.JoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link BdeXParser#join}.
	 * @param ctx the parse tree
	 */
	void exitJoin(BdeXParser.JoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inserttoTable}
	 * labeled alternative in {@link BdeXParser#insert}.
	 * @param ctx the parse tree
	 */
	void enterInserttoTable(BdeXParser.InserttoTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inserttoTable}
	 * labeled alternative in {@link BdeXParser#insert}.
	 * @param ctx the parse tree
	 */
	void exitInserttoTable(BdeXParser.InserttoTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insertColumn}
	 * labeled alternative in {@link BdeXParser#insert}.
	 * @param ctx the parse tree
	 */
	void enterInsertColumn(BdeXParser.InsertColumnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insertColumn}
	 * labeled alternative in {@link BdeXParser#insert}.
	 * @param ctx the parse tree
	 */
	void exitInsertColumn(BdeXParser.InsertColumnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code insertIntoCol}
	 * labeled alternative in {@link BdeXParser#insert}.
	 * @param ctx the parse tree
	 */
	void enterInsertIntoCol(BdeXParser.InsertIntoColContext ctx);
	/**
	 * Exit a parse tree produced by the {@code insertIntoCol}
	 * labeled alternative in {@link BdeXParser#insert}.
	 * @param ctx the parse tree
	 */
	void exitInsertIntoCol(BdeXParser.InsertIntoColContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modifyTableColSel}
	 * labeled alternative in {@link BdeXParser#modify}.
	 * @param ctx the parse tree
	 */
	void enterModifyTableColSel(BdeXParser.ModifyTableColSelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modifyTableColSel}
	 * labeled alternative in {@link BdeXParser#modify}.
	 * @param ctx the parse tree
	 */
	void exitModifyTableColSel(BdeXParser.ModifyTableColSelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modifyTablePos}
	 * labeled alternative in {@link BdeXParser#modify}.
	 * @param ctx the parse tree
	 */
	void enterModifyTablePos(BdeXParser.ModifyTablePosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modifyTablePos}
	 * labeled alternative in {@link BdeXParser#modify}.
	 * @param ctx the parse tree
	 */
	void exitModifyTablePos(BdeXParser.ModifyTablePosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code modifyColPos}
	 * labeled alternative in {@link BdeXParser#modify}.
	 * @param ctx the parse tree
	 */
	void enterModifyColPos(BdeXParser.ModifyColPosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code modifyColPos}
	 * labeled alternative in {@link BdeXParser#modify}.
	 * @param ctx the parse tree
	 */
	void exitModifyColPos(BdeXParser.ModifyColPosContext ctx);
	/**
	 * Enter a parse tree produced by {@link BdeXParser#remove}.
	 * @param ctx the parse tree
	 */
	void enterRemove(BdeXParser.RemoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BdeXParser#remove}.
	 * @param ctx the parse tree
	 */
	void exitRemove(BdeXParser.RemoveContext ctx);
	/**
	 * Enter a parse tree produced by {@link BdeXParser#read}.
	 * @param ctx the parse tree
	 */
	void enterRead(BdeXParser.ReadContext ctx);
	/**
	 * Exit a parse tree produced by {@link BdeXParser#read}.
	 * @param ctx the parse tree
	 */
	void exitRead(BdeXParser.ReadContext ctx);
	/**
	 * Enter a parse tree produced by {@link BdeXParser#save}.
	 * @param ctx the parse tree
	 */
	void enterSave(BdeXParser.SaveContext ctx);
	/**
	 * Exit a parse tree produced by {@link BdeXParser#save}.
	 * @param ctx the parse tree
	 */
	void exitSave(BdeXParser.SaveContext ctx);
	/**
	 * Enter a parse tree produced by {@link BdeXParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(BdeXParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link BdeXParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(BdeXParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link BdeXParser#insertStat}.
	 * @param ctx the parse tree
	 */
	void enterInsertStat(BdeXParser.InsertStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link BdeXParser#insertStat}.
	 * @param ctx the parse tree
	 */
	void exitInsertStat(BdeXParser.InsertStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link BdeXParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(BdeXParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BdeXParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(BdeXParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BdeXParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(BdeXParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BdeXParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(BdeXParser.TypeContext ctx);
}