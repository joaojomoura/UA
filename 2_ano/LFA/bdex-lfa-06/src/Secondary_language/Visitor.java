package Secondary_language;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.*;
import Shared.*;

public class Visitor extends secondaryBaseVisitor<Object> 
{

   @Override public Object visitProgram(secondaryParser.ProgramContext ctx) { return (Table)visit(ctx.table()); }

   @Override public Object visitTable(secondaryParser.TableContext ctx) 
   {
      //this heavily depends on how the table & column classes are implemented. just a prototype
      
      KeyValuePair<String, Column.Type>[] columns = (KeyValuePair<String, Column.Type>[])visit(ctx.columnDeclr());

      //debug print
      // System.out.println("___ColumnDeclr___");
      // for(KeyValuePair<String, Column.Type> c : columns)
      // {
      //    System.out.println(c.key + " >> " + c.value);
      // }

      //create a table object here
      Table table = new Table(columns);

      //visit lines and insert one-by-one
      List<secondaryParser.LineContext> lines = ctx.line(); //we "cache" this because ctx.line(int) gets slower and slower and slower as int increases. For a table with +-100k lines this takes a couple seconds compared to a couple minutes
      int lineCnt = lines.size();
      for(int i = 0; i < lineCnt; i++)
      {
         //debug print
         //System.out.println("Line: " + i);
         Object[] arr = (Object[])visit(lines.get(i));

         // for(Object obj : arr)
         // {
         //    System.out.print(obj+ ", ");
         // }
         // System.out.println();

         //insertLine
         table.InsertLine(arr);
         
      }

      return table;
   }

   @SuppressWarnings("unchecked")
   @Override public Object visitColumnDeclr(secondaryParser.ColumnDeclrContext ctx) 
   {
      List<secondaryParser.ColumnContext> colunns = ctx.column();

      int size = colunns.size();

      KeyValuePair<String, Column.Type>[] arr = (KeyValuePair<String, Column.Type>[])new KeyValuePair[size];

      for(int i = 0; i < size; i++)
      {
         arr[i] = (KeyValuePair<String, Column.Type>)visit(colunns.get(i));
      }

      return arr;
   }

   @Override public Object visitLine(secondaryParser.LineContext ctx) 
   {
      List<secondaryParser.TypeContext> types = ctx.type();

      int size = types.size();
      
      Object[] arr = new Object[size];

      for(int i = 0; i < size; i++)
      {
         arr[i] = visit(types.get(i));
      }

      return arr;
   }

   @Override public Object visitTypeDouble(secondaryParser.TypeDoubleContext ctx) 
   {
      return Double.parseDouble(ctx.DOUBLE().getText());
   }

   @Override public Object visitTypeInt(secondaryParser.TypeIntContext ctx) 
   {
      return Integer.parseInt(ctx.INTEGER().getText());
   }

   @Override public Object visitTypeString(secondaryParser.TypeStringContext ctx) 
   {
      String str = ctx.STRING().getText();
      return str.substring(1, str.length()-1);
   }

   @Override public Object visitColumn(secondaryParser.ColumnContext ctx) 
   {     
      Column.Type type;

      switch(ctx.varT.getText())
      {
         case "int":
            type = Column.Type.Int;
            break;
         case "double":
            type = Column.Type.Double;
            break;
         default:
            type = Column.Type.String;
            break;
      }
      return new KeyValuePair<String,Column.Type>(ctx.TEXT().getText(), type);
   }
}
