package BdeX_Language;

import java.util.List;
import java.util.*;

import org.stringtemplate.v4.*;

public class BdeXCompiler extends BdeXBaseVisitor<ST> 
{

   @Override public ST visitMain(BdeXParser.MainContext ctx) 
   {
      ST res = templates.getInstanceOf("main");
      Iterator<BdeXParser.StatContext> list = ctx.stat().iterator();
      while(list.hasNext()){
         res.add("stat", visit(list.next()).render());   
      }

      return res;
   }

   @Override public ST visitStat(BdeXParser.StatContext ctx) 
   {
      ST res = templates.getInstanceOf("stats");
      if(ctx.assignment() != null)
      {
         res.add("stat", visit(ctx.assignment()).render());
      }
      else if(ctx.declarations() != null)
      {
         res.add("stat", visit(ctx.declarations()).render());
      }
      else
      {
         res.add("stat", visit(ctx.instruction()).render());
      }
      
      return res;
   }

   @Override public ST visitDeclarations(BdeXParser.DeclarationsContext ctx) 
   {    
      ST res = templates.getInstanceOf("stats");
      ST declr = templates.getInstanceOf("declaration");

      declr.add("type", bdexTypeToJavaType(ctx.type().getText()));
      if(ctx.assignment() != null)
      {
         declr.add("assignment", visit(ctx.assignment()).render());
      }
      else
      {
         ST res2 = templates.getInstanceOf("assignment");

         res2.add("name", ctx.IDENTIFIER().getText());
         res2.add("expression", getBdexTypeDefault(ctx.type().getText()));

         declr.add("assignment", res2.render());
      }
      res.add("stat", declr.render());
      return res;

   }

   @Override public ST visitAssignment(BdeXParser.AssignmentContext ctx) 
   {     
      ST res = templates.getInstanceOf("assignment");

      res.add("name", ctx.IDENTIFIER().getText());
      res.add("expression", visit(ctx.expression()).render());
      return res;
   }

   // @Override public ST visitCreateTable(BdeXParser.CreateTableContext ctx) {
   //    return visitChildren(ctx);
   // }

   @Override public ST visitDoubleExpr(BdeXParser.DoubleExprContext ctx) 
   {     
      ST res = templates.getInstanceOf("plain");
      res.add("text", ctx.DOUBLE().getText());
      return res;
   }

   @Override public ST visitIntExpr(BdeXParser.IntExprContext ctx) 
   {
      ST res = templates.getInstanceOf("plain");
      res.add("text", ctx.INT().getText());
      return res;

   }

   @Override public ST visitAddSubExpr(BdeXParser.AddSubExprContext ctx) 
   {
      ST res = templates.getInstanceOf("operation");
      res.add("op1", visit(ctx.e1).render());
      res.add("op2", visit(ctx.e2).render());

      if(ctx.op.getText().equals("+"))
      {
         res.add("opType", "+");
      }
      else
      {
         res.add("opType", "-");
      }

      return res;    
   }

   // @Override public ST visitExtractTable(BdeXParser.ExtractTableContext ctx) {
   //    return visitChildren(ctx);
   // }

   // @Override public ST visitReadExpr(BdeXParser.ReadExprContext ctx) {
   //    return visitChildren(ctx);
   // }

   // @Override public ST visitJoinTable(BdeXParser.JoinTableContext ctx) {
   //    return visitChildren(ctx);
   // }

   @Override public ST visitParenExpr(BdeXParser.ParenExprContext ctx) 
   {
      ST res = templates.getInstanceOf("parentExpression");
      res.add("expression", visit(ctx.expression()).render());
      return res;
   }

   @Override public ST visitStringExpr(BdeXParser.StringExprContext ctx) 
   {     
      ST res = templates.getInstanceOf("plain");
      res.add("text", ctx.STRING().getText());
      return res;
   }

   @Override public ST visitVarExpr(BdeXParser.VarExprContext ctx) 
   {
      ST res = templates.getInstanceOf("plain");
      res.add("text", ctx.IDENTIFIER().getText());
      return res;
   }

   @Override public ST visitSignExpr(BdeXParser.SignExprContext ctx) 
   {
      ST res = templates.getInstanceOf("signExpression");
      res.add("sign", ctx.sign.getText());
      res.add("expression", visit(ctx.e).render());
      return res;
   }

   @Override public ST visitMultDivRemExpr(BdeXParser.MultDivRemExprContext ctx) 
   {
      ST res = templates.getInstanceOf("operation");
      res.add("op1", visit(ctx.e1).render());
      res.add("op2", visit(ctx.e2).render());

      if(ctx.op.getText().equals("*"))
      {
         res.add("opType", "*");
      }
      else if(ctx.op.getText().equals("/"))
      {
         res.add("opType", "/");
      }
      else
      {
         res.add("opType", "%");
      }

      return res;  
   }

   // @Override public ST visitCreatecolumn(BdeXParser.CreatecolumnContext ctx) {
   //    return visitChildren(ctx);
   // }

   @Override public ST visitPowExpr(BdeXParser.PowExprContext ctx) 
   {
      ST res = templates.getInstanceOf("pow");

      res.add("e1", visit(ctx.e1).render());
      res.add("e2", visit(ctx.e2).render());
      
      return res;
   }

   // @Override public ST visitInstruction(BdeXParser.InstructionContext ctx) {
   //    return visitChildren(ctx);
   // }

   @Override public ST visitCreatetable(BdeXParser.CreatetableContext ctx) 
   {
      List<BdeXParser.ExpressionContext> expressions = ctx.expression();
      List<BdeXParser.TypeContext> types = ctx.type();

      ST create = templates.getInstanceOf("tableCreate");
      for(int i = 0; i < expressions.size(); i++)
      {
         ST colD = templates.getInstanceOf("colDeclr");
         
         colD.add("name", visit(expressions.get(i)));
         colD.add("type", typeToColType(types.get(i).getText()));

         create.add("colDeclr", colD.render());
      }
      
      return create;
   }

   @Override public ST visitCreateColumn(BdeXParser.CreateColumnContext ctx) 
   {
      ST res = templates.getInstanceOf("columnCreate");

      res.add("type", typeToJavaColType(ctx.type().getText()));
      res.add("colType", typeToColType(ctx.type().getText()));
      
      return res;
   }

   @Override public ST visitExtract(BdeXParser.ExtractContext ctx) 
   {
      ST res = templates.getInstanceOf("extract");

      res.add("table", visit(ctx.table).render());

      List<BdeXParser.ExpressionContext> cols = ctx.expression();
      for(int i = 1; i < cols.size(); i++)
      {
         res.add("cols", visit(cols.get(i)).render());
      }

      List<BdeXParser.SelectionContext> conditions = ctx.selection();

      for(BdeXParser.SelectionContext cond : conditions)
      {
         res.add("conditions", visit(cond).render());
      }
      
      return res;
   }

   @Override public ST visitJoin(BdeXParser.JoinContext ctx) {
      ST res = templates.getInstanceOf("join"); 
      res.add("t1", visit(ctx.expression(0)).render());
      res.add("t2", visit(ctx.expression(1)).render());
      
      return res;
   }

   @Override public ST visitInserttoTable(BdeXParser.InserttoTableContext ctx) 
   {
      ST res = templates.getInstanceOf("insert");

      if(ctx.column != null)//one value
      {
         res.add("type", "KeyValuePair");
         
         ST kvp = templates.getInstanceOf("insertStat");
      
         kvp.add("colName", visit(ctx.column).render());
         kvp.add("value", visit(ctx.value).render());

         res.add("values", kvp.render());
      }
      else if(ctx.insertStat().size() == 0)//second mode (all in order)
      {
         res.add("type", "Object");
         
         List<BdeXParser.ExpressionContext> values = ctx.expression();

         for(int i = 1; i < values.size(); i++)
         {
            BdeXParser.ExpressionContext value = values.get(i);
            res.add("values", visit(value).render());
         }
      }
      else //third mode
      {
         res.add("type", "KeyValuePair");
         
         List<BdeXParser.InsertStatContext> values = ctx.insertStat();

         for(BdeXParser.InsertStatContext value : values)
         {
            res.add("values", visit(value).render());
         }
      }
      
      res.add("table", visit(ctx.table).render());

      return res;
   }

   @Override public ST visitInsertColumn(BdeXParser.InsertColumnContext ctx) 
   {
      ST res = templates.getInstanceOf("insertCol");

      res.add("table", visit(ctx.table).render());
      res.add("colName", visit(ctx.colName).render());
      res.add("column", visit(ctx.column).render());
      
      return res;
   }

   @Override public ST visitInsertIntoCol(BdeXParser.InsertIntoColContext ctx) 
   {
      ST res = templates.getInstanceOf("colInsert");

      res.add("column", visit(ctx.column).render());
      res.add("value", visit(ctx.value).render());
      
      return res;
   }

   @Override public ST visitModifyTableColSel(BdeXParser.ModifyTableColSelContext ctx) 
   {
      ST res = templates.getInstanceOf("modify");

      res.add("table", visit(ctx.table).render());

      List<BdeXParser.InsertStatContext> values = ctx.insertStat();
      List<BdeXParser.SelectionContext> conditions = ctx.selection();

      for(BdeXParser.InsertStatContext value : values)
      {
         res.add("insertStats", visit(value).render());
      }

      for(BdeXParser.SelectionContext condition : conditions)
      {
         res.add("conditions", visit(condition).render());
      }
      
      return res;
   }

   @Override public ST visitModifyTablePos(BdeXParser.ModifyTablePosContext ctx) 
   {
      ST res = templates.getInstanceOf("modifyPos");

      res.add("table", visit(ctx.table).render());
      res.add("colName", visit(ctx.col).render());
      res.add("position", visit(ctx.position).render());
      res.add("value", visit(ctx.value).render());

      return res;
   }

   @Override public ST visitModifyColPos(BdeXParser.ModifyColPosContext ctx) 
   {
      ST res = templates.getInstanceOf("modifyColPos");

      res.add("column", visit(ctx.column).render());
      res.add("pos", visit(ctx.position).render());
      res.add("value", visit(ctx.value).render());

      return res;
   }

   @Override public ST visitRemove(BdeXParser.RemoveContext ctx) 
   {
      ST res;

      if(ctx.column != null)
      {
         res = templates.getInstanceOf("removeCol");
         res.add("table", visit(ctx.table).render());
         res.add("col", visit(ctx.column).render());
      }
      else
      {
         res = templates.getInstanceOf("remove");
         res.add("table", visit(ctx.table).render());
         
         List<BdeXParser.SelectionContext> conditions = ctx.selection();

         for(BdeXParser.SelectionContext cond : conditions)
         {
            res.add("conditions", visit(cond).render());
         }
      }
      
      return res;
   }

   @Override public ST visitRead(BdeXParser.ReadContext ctx) 
   {
      ST res;
      if(ctx.expression() != null)
      {
         res = templates.getInstanceOf("readTable");
         res.add("filename", visit(ctx.expression()).render());
      }
      else
      {
         res = templates.getInstanceOf("readScanner");
         res.add("type", TranlateRead(ctx.type().getText()));
      }
      return res;
   }

   @Override public ST visitSave(BdeXParser.SaveContext ctx) 
   {
      ST res = templates.getInstanceOf("save");
      res.add("expression", visit(ctx.expression(0)).render());
      res.add("filename", visit(ctx.expression(1)).render());
      return res;
   }

   @Override public ST visitPrint(BdeXParser.PrintContext ctx) 
   {
      ST res = templates.getInstanceOf("print");
      res.add("expression", visit(ctx.expression()).render());
      return res;
   }

   @Override public ST visitInsertStat(BdeXParser.InsertStatContext ctx) 
   {
      ST res = templates.getInstanceOf("insertStat");
      
      res.add("colName", visit(ctx.expression(0)).render());
      res.add("value", visit(ctx.expression(1)).render());

      return res;
   }

   @Override public ST visitSelection(BdeXParser.SelectionContext ctx) 
   {
      ST res = templates.getInstanceOf("condition");

      res.add("colName", visit(ctx.expression(0)).render());
      res.add("op", ctx.SELECOP().getText());
      res.add("value", visit(ctx.expression(1)).render());
      
      return res;
   }

   @Override public ST visitType(BdeXParser.TypeContext ctx) 
   {
      return visitChildren(ctx);
   }

   private String typeToColType(String txt)
   {
      if(txt.equals("int"))
      {
         return "Column.Type.Int";
      }
      else if(txt.equals("double"))
      {
         return "Column.Type.Double";
      }
      else 
      {
         return "Column.Type.String";
      }
   }

   //come up with a better name
   private String typeToJavaColType(String txt)
   {
      if(txt.equals("int"))
      {
         return "Integer";
      }
      else if(txt.equals("double"))
      {
         return "Double";
      }
      else 
      {
         return "String";
      }
   }

   private String bdexTypeToJavaType(String txt)
   {
      switch(txt)
      {
         case "int":
         case "double":
         case "Table":
            return txt;
         case "text":
            return "String";
         case "column":
            return "Column";
         default:
            return null;
      }
   }

   private String getBdexTypeDefault(String txt)
   {
      switch(txt)
      {
         case "int":
            return "0";
         case "double":
            return "0.0";
         case "Table":
            return "null";
         case "text":
            return "\"\"";
         case "column":
            return "null";
         default:
            return null;
      }
   }

   private String TranlateRead(String txt)
   {
      switch(txt)
      {
         case "int":
            return "Int";
         case "double":
            return "Double";
         case "text":
            return "Line";
         default:
            return null;
      }
   }

   private STGroup templates = new STGroupFile("BdeX_Language/java.stg");
}
