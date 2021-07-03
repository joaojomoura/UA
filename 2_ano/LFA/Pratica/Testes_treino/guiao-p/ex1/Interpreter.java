import java.util.HashMap;

import java.util.Scanner;

public class Interpreter extends StrLangBaseVisitor<String> {
   static Scanner sc = new Scanner(System.in);
   HashMap <String,String> map = new HashMap<>();
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
      String res = visit(ctx.expr());
      String id = ctx.ID().getText();
      if(res == null)
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
        System.out.println("Variable not initialized!");
      return null;
   }

  @Override public String visitExprRead(StrLangParser.ExprReadContext ctx) {
      String res = visit(ctx.expr());
      System.out.print(res);
      String s = sc.nextLine();
      return s;

   }

  @Override public String visitExprAdd(StrLangParser.ExprAddContext ctx) {
    String op1 = visit(ctx.op1);
    String op2 = visit(ctx.op2);
    return op1.concat(op2);
   }

  @Override public String visitExprParent(StrLangParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

  @Override public String visitExprSub(StrLangParser.ExprSubContext ctx) {
      String op1 = visit(ctx.op1);
      String op2 = visit(ctx.op2);
      return op1.replace(op2,"");
   }

  @Override public String visitExprTrim(StrLangParser.ExprTrimContext ctx) {
      String s = visit(ctx.expr());
      return s.trim();
   }
  @Override public String visitExprSubst(StrLangParser.ExprSubstContext ctx) {
      String s1 = visit(ctx.expr(0));
      String s2 = visit(ctx.expr(1));
      String s3 = visit(ctx.expr(2));

      return s1.replace(s2,s3);

   }
}
