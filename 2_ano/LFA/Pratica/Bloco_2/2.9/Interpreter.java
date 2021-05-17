import java.util.HashMap;
public class Interpreter extends CalcFracBaseVisitor<Fraction> {
    
  HashMap <String, Fraction> map = new HashMap <>();

   @Override public Fraction visitStatExpr(CalcFracParser.StatExprContext ctx) {
      Fraction res = null;
      res = visit(ctx.expr());
      if(res != null)
        return res;
      return null;
   }

   @Override public Fraction visitStatPrint(CalcFracParser.StatPrintContext ctx) {
      return visit(ctx.print());
   }

   @Override public Fraction visitStatAssign(CalcFracParser.StatAssignContext ctx) {
      return visit(ctx.assign());
   }

   @Override public Fraction visitPrint(CalcFracParser.PrintContext ctx) {
      Fraction f = visit(ctx.expr());
      System.out.println(f);
      return null;
   }

   @Override public Fraction visitAssign(CalcFracParser.AssignContext ctx) {
      String var = ctx.ID().getText();
      Fraction f = visit(ctx.expr());
      map.put(var,f);
      return f;
   }

   @Override public Fraction visitExprAddSub(CalcFracParser.ExprAddSubContext ctx) {
      switch(ctx.op.getText()){
        case "+":
          return visit(ctx.expr(0)).addFraction(visit(ctx.expr(1)));
        case "-":
          return visit(ctx.expr(0)).subFraction(visit(ctx.expr(1)));
      }
      return null;
   }

   @Override public Fraction visitExprParent(CalcFracParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Fraction visitExprNumber(CalcFracParser.ExprNumberContext ctx) {
      return new Fraction (Integer.parseInt(ctx.Number().getText()));
   }

   @Override public Fraction visitExprMultDiv(CalcFracParser.ExprMultDivContext ctx) {
      switch(ctx.op.getText()){
        case "*":
          return visit(ctx.op1).mulFraction(visit(ctx.op2));
        case ":":
          return visit(ctx.op1).divFraction(visit(ctx.op2));
      }
      return null; 
   }

   @Override public Fraction visitExprSignal(CalcFracParser.ExprSignalContext ctx) {
      String signal = ctx.signal.getText();
      Fraction f = visit(ctx.expr());
      if(signal.equals("-")){
        return (new Fraction().subFraction(f));
      }
      return f;
   }

   @Override public Fraction visitExprID(CalcFracParser.ExprIDContext ctx) {
      return map.get(ctx.ID().getText());
   }

   @Override public Fraction visitExprFraction(CalcFracParser.ExprFractionContext ctx) {
      return new Fraction(Integer.parseInt(ctx.Number(0).getText()),Integer.parseInt(ctx.Number(1).getText()));
   }
}
