 import java.util.HashMap;

import java.util.Scanner;

public class Interpreter extends FracLangBaseVisitor<Fraction> {

  HashMap <String,Fraction> map = new HashMap<>();
  Scanner sc = new Scanner (System.in);

   @Override public Fraction visitStatDisplay(FracLangParser.StatDisplayContext ctx) {
     Fraction res = visit(ctx.display());
     if(res != null)
       System.out.println(res);
     return res;
   }

   @Override public Fraction visitStatAssign(FracLangParser.StatAssignContext ctx) {
      Fraction res = visit(ctx.assign());
      return res;
   }

   @Override public Fraction visitDisplay(FracLangParser.DisplayContext ctx) {
      Fraction res = visit(ctx.expr());
      return res;
   }

   @Override public Fraction visitAssign(FracLangParser.AssignContext ctx) {
     Fraction res = visit(ctx.expr());
     String id = ctx.ID().getText();
     if(res == null)
       return null;
     map.put(id,res);
     return res;
   }

   @Override public Fraction visitExprInt(FracLangParser.ExprIntContext ctx) {
     return new Fraction(Integer.parseInt(ctx.INT().getText()));
   }

   @Override public Fraction visitExprAddSub(FracLangParser.ExprAddSubContext ctx) {
      switch(ctx.op.getText()){
        case "+":
          return visit(ctx.expr(0)).addFraction(visit(ctx.expr(1)));
        case "-":
          return visit(ctx.expr(0)).subFraction(visit(ctx.expr(1)));
      }
      return null;
   }

   @Override public Fraction visitExprParent(FracLangParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Fraction visitExprID(FracLangParser.ExprIDContext ctx) {
      String id = ctx.ID().getText();
      if(map.containsKey(id))
        return map.get(id);
      else
        System.err.println("Error: Variable not initialized!");
      return null;
   }

   @Override public Fraction visitExprFrac(FracLangParser.ExprFracContext ctx) {
      int num = Integer.parseInt(ctx.INT(0).getText());
      int dem = Integer.parseInt(ctx.INT(1).getText());
      return new Fraction(num,dem);
   }

   @Override public Fraction visitExprMulDiv(FracLangParser.ExprMulDivContext ctx) {
      switch(ctx.op.getText()){
        case "*":
          return visit(ctx.expr(0)).mulFraction(visit(ctx.expr(1)));
        case ":":
          return visit(ctx.expr(0)).divFraction(visit(ctx.expr(1)));
      }
      return null;
   }

   @Override public Fraction visitExprSignal(FracLangParser.ExprSignalContext ctx) {
      String signal = ctx.signal.getText();
      Fraction res = visit(ctx.expr());
      if(signal.equals("-")){
        return (new Fraction().subFraction(res));
      }
      return res;
   }


   @Override public Fraction visitExprRead(FracLangParser.ExprReadContext ctx){
      String s = ctx.STRING().getText();
      System.out.print(s + ": ");
      String sf = sc.next();
      
      map.put(s,f);
      return f;


   }
}
