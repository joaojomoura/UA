import java.util.HashMap;

public class Interpreter extends StrLangBaseVisitor<String> {
    
   HashMap <String,String> map =  new HashMap<>();
  
   @Override public String visitStatPrint(StrLangParser.StatPrintContext ctx) {
      String res = visit(ctx.print());
      if(res != null){
        System.out.println(res);
      }
      return res;
   }

   @Override public String visitStatAssign(StrLangParser.StatAssignContext ctx) {
      String res = visit(ctx.assign());
      return res;
  }

   @Override public String visitPrint(StrLangParser.PrintContext ctx) {
      String res = visit(ctx.expr());
      return res;
   }

   @Override public String visitAssign(StrLangParser.AssignContext ctx) {
     String id = ctx.ID().getText();
     String res = visit(ctx.expr());
     if(res.isEmpty())
       return null;
     map.put(id,res);
     return res;
   }

   @Override public String visitExprString(StrLangParser.ExprStringContext ctx) {
      return ctx.STRING().getText();
   }

   @Override public String visitExprID(StrLangParser.ExprIDContext ctx) {
      String id = ctx.ID().getText();
      if(map.containsKey(id))
        return map.get(id);
      else
        System.err.println(id + " not initialized");
      return null;
   }
}
