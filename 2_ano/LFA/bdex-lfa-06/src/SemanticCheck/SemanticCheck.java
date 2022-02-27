package SemanticCheck;

import java.util.List;
import java.util.*;

import org.stringtemplate.v4.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import SemanticCheck.*;
import SemanticCheck.Types.*;
import BdeX_Language.*;

public class SemanticCheck extends BdeXBaseVisitor<Boolean> 
{
   private TypeChecker checker = new TypeChecker();


   @Override public Boolean visitMain(BdeXParser.MainContext ctx) {
      Iterator<BdeXParser.StatContext> list = ctx.stat().iterator();
      Boolean res = true;
      while(list.hasNext()){
         res &= visit(list.next()); 
      }

      return res;
   }

   @Override public Boolean visitStat(BdeXParser.StatContext ctx) {
      Boolean res;
      if(ctx.assignment() != null)
      {
         BdeXParser.AssignmentContext assignment = ctx.assignment();
         res = visit(assignment);
         Type varType = checker.GetVariableType(assignment.varName);

         if(varType == null) return false;

         if(!varType.name().equals(assignment.eType.name()))
         {
            ErrorHandling.printError(ctx, "Resulting expression type (" + assignment.eType.name() +") doesn't match variable type (" + varType.name()+")");
            res = false;
         }
      }
      else if(ctx.declarations() != null)
      {
         res = visit(ctx.declarations());
      }
      else
      {
         res = visit(ctx.instruction());
      }
      
      return res;
   }

   @Override public Boolean visitDeclarations(BdeXParser.DeclarationsContext ctx) 
   {
      Type varType = convert(ctx.type().getText());
      Boolean res = true;
      if(ctx.assignment() != null)
      {
         res &= visit(ctx.assignment());
         Type exprType= ctx.assignment().eType;

         if(exprType == null) return false;

         if(!varType.name().equals(exprType.name()))
         {
            ErrorHandling.printError(ctx, "Resulting expression type (" + exprType.name() +") doesn't match variable type (" + varType.name()+")");
            res = false;
         }

         if(!checker.CreateVariable(ctx.assignment().varName, varType))
         {
            ErrorHandling.printError(ctx, "Variable " + ctx.assignment().varName + " already declared!");
            res = false;
         }
      }
      else
      {
         if(!checker.CreateVariable(ctx.IDENTIFIER().getText(), varType))
         {
            ErrorHandling.printError(ctx, "Variable " + ctx.IDENTIFIER().getText() + " already declared!");
            res = false;
         }
      }

      return res;
   }

   @Override public Boolean visitAssignment(BdeXParser.AssignmentContext ctx) {
      Boolean res = visit(ctx.expression());

      // if(res)
      // {
      //    ctx.eType = ctx.expression().eType;
      //    ctx.varName = ctx.IDENTIFIER().getText();
      // }
      ctx.eType = ctx.expression().eType;
      ctx.varName = ctx.IDENTIFIER().getText();
      
      return res;
   }

   @Override public Boolean visitCreateTable(BdeXParser.CreateTableContext ctx) {
      Boolean res = visit(ctx.createtable());
      ctx.eType = ctx.createtable().eType;
      return res;
   }

   @Override public Boolean visitDoubleExpr(BdeXParser.DoubleExprContext ctx) {
      ctx.eType = doubleType;
      ctx.isVar = false;
      ctx.varName = ctx.DOUBLE().getText();

      return true;
   }

   @Override public Boolean visitIntExpr(BdeXParser.IntExprContext ctx) {
      ctx.eType = integerType;
      ctx.isVar = false;
      ctx.varName = ctx.INT().getText();

      return true;
   }

   @Override public Boolean visitAddSubExpr(BdeXParser.AddSubExprContext ctx) {

      Boolean res = visit(ctx.e1) && checkNumericType(ctx, ctx.e1.eType) &&
                    visit(ctx.e2) && checkNumericType(ctx, ctx.e2.eType);
      
      // if(res)
      // {
      //    ctx.eType = numericOpResult(ctx.e1.eType, ctx.e2.eType);
      // }
      ctx.eType = numericOpResult(ctx.e1.eType, ctx.e2.eType);
      
      return res;
   }

   @Override public Boolean visitExtractTable(BdeXParser.ExtractTableContext ctx) {
      Boolean res = visit(ctx.extract());
      ctx.eType = ctx.extract().eType;
      return res;
   }

   @Override public Boolean visitReadExpr(BdeXParser.ReadExprContext ctx) {
      Boolean res = visit(ctx.read());
      ctx.eType = ctx.read().eType;
      return res;
   }

   @Override public Boolean visitJoinTable(BdeXParser.JoinTableContext ctx) {
      Boolean res = visit(ctx.join());
      ctx.eType = ctx.join().eType;
      return res;
   }

   @Override public Boolean visitParenExpr(BdeXParser.ParenExprContext ctx) {  
      Boolean res = visit(ctx.e);
      ctx.eType = ctx.e.eType;

      return res;
   }

   @Override public Boolean visitStringExpr(BdeXParser.StringExprContext ctx) {
      ctx.eType = textType;
      ctx.varName = ctx.STRING().getText();
      ctx.isVar = false;

      return true;
   }

   @Override public Boolean visitVarExpr(BdeXParser.VarExprContext ctx) {
      String varName = ctx.IDENTIFIER().getText();
      
      Boolean res = checker.DoesVariableExist(varName);

      if(!res)
      {
         ErrorHandling.printError(ctx, "Variable " + varName + " undeclared!");
      }
      // else
      // {
      //    ctx.eType = checker.GetVariableType(varName);
      // }
      ctx.eType = checker.GetVariableType(varName);
      ctx.varName = varName;
      ctx.isVar = true;

      return res;
   }

   @Override public Boolean visitSignExpr(BdeXParser.SignExprContext ctx) {
      Boolean res = visit(ctx.e) && checkNumericType(ctx, ctx.e.eType);
      
      ctx.eType = ctx.e.eType;

      return res;
   }

   @Override public Boolean visitMultDivRemExpr(BdeXParser.MultDivRemExprContext ctx) {
      Boolean res = visit(ctx.e1) && checkNumericType(ctx, ctx.e1.eType) &&
                    visit(ctx.e2) && checkNumericType(ctx, ctx.e2.eType);

      // if(res)
      // {
      //    ctx.eType = numericOpResult(ctx.e1.eType, ctx.e2.eType);
      // }
      ctx.eType = numericOpResult(ctx.e1.eType, ctx.e2.eType);   

      return res;
   }

   @Override public Boolean visitCreatecolumn(BdeXParser.CreatecolumnContext ctx) {
      Boolean res = visit(ctx.createColumn());
      ctx.eType = ctx.createColumn().eType;
      return res;
   }

   @Override public Boolean visitPowExpr(BdeXParser.PowExprContext ctx) {
      Boolean res = visit(ctx.e1) && checkNumericType(ctx, ctx.e1.eType) &&
                    visit(ctx.e2) && checkNumericType(ctx, ctx.e2.eType);

      // if(res)
      // {
      //    ctx.eType = numericOpResult(ctx.e1.eType, ctx.e2.eType);
      // }
      ctx.eType = numericOpResult(ctx.e1.eType, ctx.e2.eType);
      
      return res;
   }

   // @Override public Boolean visitInstruction(BdeXParser.InstructionContext ctx) {
   //    return visitChildren(ctx);
   // }

   @Override public Boolean visitCreatetable(BdeXParser.CreatetableContext ctx) {
      List<BdeXParser.ExpressionContext> expressions = ctx.expression();
      List<BdeXParser.TypeContext> types = ctx.type();
      HashSet<String> colNames = new HashSet<String>();

      Boolean res = true;
      
      for(BdeXParser.ExpressionContext expr : expressions)
      {
         res &= visit(expr) && isText(ctx, expr.eType, expr.varName);
         if(colNames.contains(expr.varName))
         {
            if(expr.isVar)
            {
               ErrorHandling.printWarning(ctx, "Duplicate column name! Variable (" + expr.varName + ") appearing multiple times as a column name!");
            }
            else
            {
               ErrorHandling.printWarning(ctx, "Duplicate column name " + expr.varName + "!");
            }
         }
         else
         {
            colNames.add(expr.varName);
         }
      }
      ctx.eType = tableType;

      return res;
   }

   @Override public Boolean visitCreateColumn(BdeXParser.CreateColumnContext ctx) {
      ctx.eType = columnType;

      return true;
   }

   @Override public Boolean visitExtract(BdeXParser.ExtractContext ctx) {
      List<BdeXParser.ExpressionContext> expressions = ctx.expression();
      HashSet<String> colNames = new HashSet<String>();
      HashSet<String> condColNames = new HashSet<String>();

      Boolean res = true;

      ctx.eType = tableType;

      res &= visit(ctx.table) && isTable(ctx, ctx.table.eType, ctx.table.varName, ctx.table.isVar);

      for(int i = 1; i < expressions.size(); i++)
      {
         BdeXParser.ExpressionContext expr = expressions.get(i);
         res &= visit(expr) && isText(ctx, expr.eType, expr.varName);
         if(colNames.contains(expr.varName))
         {
            if(expr.isVar)
            {
               ErrorHandling.printWarning(ctx, "Duplicate column name! Variable (" + expr.varName + ") appearing multiple times as a column name!");
            }
            else
            {
               ErrorHandling.printWarning(ctx, "Duplicate column name " + expr.varName + "!");
            }
         }
         else
         {
            colNames.add(expr.varName);
         }
      }

      List<BdeXParser.SelectionContext> conditions = ctx.selection();

      for(BdeXParser.SelectionContext cond : conditions)
      {
         res &= visit(cond);
         if(condColNames.contains(cond.varName))
         {
            if(cond.isVar)
            {
               ErrorHandling.printWarning(ctx, "Duplicate column name in condition! Variable (" + cond.varName + ") appearing multiple times as a column name! If these contradict each other no line will pass! This will slow down execution!");
            }
            else
            {
               ErrorHandling.printWarning(ctx, "Duplicate column name " + cond.varName + " in condition! If these contradict each other no line will pass! This will slow down execution!");
            }
         }
         else
         {
            condColNames.add(cond.varName);
         }
      }

      return res;
   }

   @Override public Boolean visitJoin(BdeXParser.JoinContext ctx) {
      BdeXParser.ExpressionContext expr0 = ctx.expression(0);
      BdeXParser.ExpressionContext expr1 = ctx.expression(1);

      ctx.eType = tableType;

      Boolean res = visit(expr0) && visit(expr1) && isTable(ctx, expr0.eType, expr0.varName, expr0.isVar) && isTable(ctx, expr1.eType, expr1.varName, expr1.isVar);
      
      return res;
   }

   @Override public Boolean visitInserttoTable(BdeXParser.InserttoTableContext ctx) {
      Boolean res = visit(ctx.table) && isTable(ctx, ctx.table.eType, ctx.table.varName, ctx.table.isVar);

      if(ctx.column != null)//one value
      {
         res &= visit(ctx.column) && isText(ctx, ctx.column.eType, ctx.column.varName);
      }
      else if(ctx.insertStat().size() == 0)//second mode (all in order)
      {
         List<BdeXParser.ExpressionContext> values = ctx.expression();

         for(int i = 1; i < values.size(); i++)
         {
            BdeXParser.ExpressionContext value = values.get(i);
            res &= visit(value) && isNotTableOrColumn(ctx, value.eType, value.varName);
         }
      }
      else //third mode
      {
         List<BdeXParser.InsertStatContext> inserts = ctx.insertStat();
         HashSet<String> insertNames = new HashSet<String>();

         for(BdeXParser.InsertStatContext insert : inserts)
         {
            res &= visit(insert);
            if(insertNames.contains(insert.varName))
            {
               if(insert.isVar)
               {
                  ErrorHandling.printWarning(ctx, "Duplicate column name a table insert! Variable (" + insert.varName + ") appearing multiple times as a column name!");
               }
               else
               {
                  ErrorHandling.printWarning(ctx, "Duplicate column name " + insert.varName + " in table insertion!");
               }
            }
            else
            {
               insertNames.add(insert.varName);
            }
         }
      }
      
      return res;
   }

   @Override public Boolean visitInsertColumn(BdeXParser.InsertColumnContext ctx) {
      Boolean res = visit(ctx.table) && isTable(ctx, ctx.table.eType, ctx.table.varName, ctx.table.isVar)&&
                    visit(ctx.colName) && isText(ctx, ctx.colName.eType, ctx.colName.varName) &&
                    visit(ctx.column) && isColumn(ctx, ctx.column.eType, ctx.column.varName, ctx.column.isVar);
      
      return res;
   }

   @Override public Boolean visitInsertIntoCol(BdeXParser.InsertIntoColContext ctx) {
      Boolean res = visit(ctx.column) && isColumn(ctx, ctx.column.eType, ctx.column.varName, ctx.column.isVar);
      
      return res;
   }

   @Override public Boolean visitModifyTableColSel(BdeXParser.ModifyTableColSelContext ctx) {
      Boolean res = visit(ctx.table) && isTable(ctx, ctx.table.eType, ctx.table.varName, ctx.table.isVar);

      List<BdeXParser.InsertStatContext> values = ctx.insertStat();
      List<BdeXParser.SelectionContext> conditions = ctx.selection();
      HashSet<String> condColNames = new HashSet<String>();

      for(BdeXParser.InsertStatContext value : values)
      {
         res &= visit(value);
      }

      for(BdeXParser.SelectionContext condition : conditions)
      {
         res &= visit(condition);
         if(condColNames.contains(condition.varName))
         {
            if(condition.isVar)
            {
               ErrorHandling.printWarning(ctx, "Duplicate column name in condition! Variable (" + condition.varName + ") appearing multiple times as a column name! This will slow down execution!");
            }
            else
            {
               ErrorHandling.printWarning(ctx, "Duplicate column name " + condition.varName + " in condition! This will slow down execution!");
            }
         }
         else
         {
            condColNames.add(condition.varName);
         }
      }
      
      return res;
   }

   @Override public Boolean visitModifyTablePos(BdeXParser.ModifyTablePosContext ctx) {
      Boolean res = visit(ctx.table) && isTable(ctx, ctx.table.eType, ctx.table.varName, ctx.table.isVar)&&
                    visit(ctx.col) && isText(ctx, ctx.col.eType, ctx.col.varName) &&
                    visit(ctx.position) && isInteger(ctx, ctx.position.eType, ctx.position.varName);
      
      return res;
   }

   @Override public Boolean visitModifyColPos(BdeXParser.ModifyColPosContext ctx) {
      Boolean res = visit(ctx.column) && isColumn(ctx, ctx.column.eType, ctx.column.varName, ctx.column.isVar) && 
                    visit(ctx.position) && isInteger(ctx, ctx.position.eType, ctx.position.varName);

      return res;
   }

   @Override public Boolean visitRemove(BdeXParser.RemoveContext ctx) {
      Boolean res = visit(ctx.table) && isTable(ctx, ctx.table.eType, ctx.table.varName, ctx.table.isVar);
      
      if(ctx.column != null)
      {
         res &= visit(ctx.column) && isText(ctx, ctx.column.eType, ctx.column.varName);
      }
      else
      {    
         List<BdeXParser.SelectionContext> conditions = ctx.selection();
         HashSet<String> condColNames = new HashSet<String>();

         for(BdeXParser.SelectionContext condition : conditions)
         {
            res &= visit(condition);
            if(condColNames.contains(condition.varName))
            {
               if(condition.isVar)
               {
                  ErrorHandling.printWarning(ctx, "Duplicate column name in condition! Variable (" + condition.varName + ") appearing multiple times as a column name! This will slow down execution!");
               }
               else
               {
                  ErrorHandling.printWarning(ctx, "Duplicate column name " + condition.varName + " in condition! This will slow down execution!");
               }
            }
            else
            {
               condColNames.add(condition.varName);
            }
         }
      }

      return res;
   }

   @Override public Boolean visitRead(BdeXParser.ReadContext ctx) {
      Boolean res;
      if(ctx.expression() != null)
      {
         res = visit(ctx.expression()) && isText(ctx, ctx.expression().eType, ctx.expression().varName);
         ctx.eType = tableType;
      }
      else
      {
         res = true;;
         ctx.eType = convert(ctx.type().getText());
      }
      return res;
   }

   @Override public Boolean visitSave(BdeXParser.SaveContext ctx) {
      Boolean res = visit(ctx.expression(0)) &&  visit(ctx.expression(1)) && isText(ctx.expression(1), ctx.expression(1).eType, ctx.expression(1).varName);

      return res;
   }

   @Override public Boolean visitPrint(BdeXParser.PrintContext ctx) {
      return visit(ctx.expression());
   }

   @Override public Boolean visitInsertStat(BdeXParser.InsertStatContext ctx) {
      Boolean res = visit(ctx.expression(0)) && isText(ctx.expression(0), ctx.expression(0).eType, ctx.expression(0).varName) && 
                    visit(ctx.expression(1)) && isNotTableOrColumn(ctx.expression(1), ctx.expression(1).eType, ctx.expression(1).varName);

      ctx.varName = ctx.expression(0).varName;
      ctx.isVar = ctx.expression(0).isVar;

      return res;
   }

   @Override public Boolean visitSelection(BdeXParser.SelectionContext ctx) {
      Boolean res = visit(ctx.expression(0)) && isText(ctx.expression(0), ctx.expression(0).eType, ctx.expression(0).varName) && 
                    visit(ctx.expression(1)) && isNotTableOrColumn(ctx.expression(1), ctx.expression(1).eType, ctx.expression(1).varName);

      ctx.varName = ctx.expression(0).varName;
      ctx.isVar = ctx.expression(0).isVar;

      return res;
   }

   @Override public Boolean visitType(BdeXParser.TypeContext ctx) {
      return visitChildren(ctx);
   }

   private Type convert(String txt)
   {
      switch(txt)
      {
         case "int":
            return integerType;
         case "double":
            return doubleType;
         case "Table":
            return tableType;
         case "text":
            return textType;
         case "column":
            return columnType;
         default:
            return null;
      }
   }

   private Boolean checkNumericType(ParserRuleContext ctx, Type t)
   {
      Boolean res = true;
      if (!t.isNumber())
      {
         ErrorHandling.printError(ctx, "Numeric operator applied to a non-numeric operand!");
         res = false;
      }
      return res;
   }

   private Type numericOpResult(Type t1, Type t2)
   {
      if(t1 == null || t2 == null) return null;
      if(t1.name().equals("double"))
      {
         return doubleType;
      }
      if(t2.name().equals("double"))
      {
         return doubleType;
      }
      if(t1.name().equals("int") && t2.name().equals("int"))
      {
         return integerType;
      }
      return null;
   }

   private Boolean isText(ParserRuleContext ctx, Type t, String varName)
   {
      if(!t.name().equals("text"))
      {
         if(varName == null)
         {
            ErrorHandling.printError(ctx, "Value must be text");
         }
         else
         {
            ErrorHandling.printError(ctx, "Variable " + varName + " must be a text variable!");
         }
         return false;
      }
      return true;
   }

   private Boolean isInteger(ParserRuleContext ctx, Type t, String varName)
   {
      if(!t.name().equals("int"))
      {
         if(varName == null)
         {
            ErrorHandling.printError(ctx, "Value must be an int");
         }
         else
         {
            ErrorHandling.printError(ctx, "Variable " + varName + " must be of type int!");
         }
         return false;
      }
      return true;
   }

   private Boolean isTable(ParserRuleContext ctx, Type t, String varName, Boolean isVar)
   {
      if(!t.name().equals("table"))
      {
         if(!isVar)
         {
            ErrorHandling.printError(ctx, t.name() + " " + varName + " is not a variable of type table");
         }
         else
         {
            ErrorHandling.printError(ctx, "Variable " + varName + " must be of type table!");
         }
         return false;
      }
      return true;
   }

   private Boolean isColumn(ParserRuleContext ctx, Type t, String varName, Boolean isVar)
   {
      if(!t.name().equals("column"))
      {
         if(!isVar)
         {
            ErrorHandling.printError(ctx, t.name() + " " + varName + " is not a variable of type column");
         }
         else
         {
            ErrorHandling.printError(ctx, "Variable " + varName + " must be of type column!");
         }
         return false;
      }
      return true;
   }

   private Boolean isNotTableOrColumn(ParserRuleContext ctx, Type t, String varName)
   {
      if(t.name().equals("table") || t.name().equals("column"))
      {
         ErrorHandling.printError(ctx, "Variable "+ varName +" cannot be a table or column!");
         
         return false;
      }
      return true;
   }
   private Boolean isDouble(ParserRuleContext ctx, Type t, String varName)
   {
      if(!t.name().equals("double"))
      {
          if(varName == null)
          {
              ErrorHandling.printError(ctx, "Value must be a double");
          }
          else
          {
              ErrorHandling.printError(ctx, "Variable " + varName + " must be of type double!");
          }
          return false;
      }
      return true;
  }
  private Boolean isDouble(ParserRuleContext ctx, Type t, String varName, Boolean isVar)
  {
      if(!t.name().equals("tuplo"))
      {
          if(!isVar)
           {
              ErrorHandling.printError(ctx, t.name() + " " + varName + " is not a variable of type tuple");
           }
           else
           {
              ErrorHandling.printError(ctx, "Variable " + varName + " must be of type tuple!");
           }
           return false;
      }
      return true;
  }

  private Boolean isBoolean(ParserRuleContext ctx, Type t, String varName)
  {
      if(!t.name().equals("boolean"))
      {
          if(varName == null)
          {
              ErrorHandling.printError(ctx, "Value must be a boolean");
          }
          else
          {
              ErrorHandling.printError(ctx, "Variable " + varName + " must be of type boolean!");
          }
          return false;
      }
      return true;
  }

   private final IntegerType integerType = new IntegerType();
    private final DoubleType doubleType = new DoubleType();
    private final TextType textType = new TextType();
    private final TableType tableType = new TableType();
    private final BooleanType booleanType = new BooleanType();
    private final TupleType tupleType = new TupleType();
    private final ColumnType columnType = new ColumnType();
}
