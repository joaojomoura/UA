import java.util.Iterator;

import org.stringtemplate.v4.*;
public class Compiler extends TesteBaseVisitor<ST> {

   @Override public ST visitMain(TesteParser.MainContext ctx) {
      ST res = templates.getInstanceOf("module");
      Iterator<TesteParser.StatContext> list = ctx.stat().iterator();
      while(list.hasNext()){
        res.add("stat",visit(list.next()).render());
      }
      return res;
   }

   @Override public ST visitStat(TesteParser.StatContext ctx) {
      ST res = templates.getInstanceOf("show");
      res.add("expr",visit(ctx.expr()).render());
      return res;
   }

   @Override public ST visitExprInt(TesteParser.ExprIntContext ctx) {
      ST res = templates.getInstanceOf("plain");
      res.add("text", ctx.INT().getText());
      return res;
   }

   @Override public ST visitExprString(TesteParser.ExprStringContext ctx) {
      ST res = templates.getInstanceOf("plain");
      res.add("text", ctx.STRING().getText());
      return res;
   }
   private STGroup templates = new STGroupFile("java.stg");
}
