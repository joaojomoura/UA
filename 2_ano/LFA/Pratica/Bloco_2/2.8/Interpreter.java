public class Interpreter extends CalculatorBaseVisitor<String> {


   @Override public String visitExp(CalculatorParser.ExpContext ctx) {
      String res = null;
      res = visit(ctx.expr());
      if(res != null)
        System.out.println("Result -> " + res);
      return res;
   }

   @Override public String visitAssign(CalculatorParser.AssignContext ctx) {
      String res = null;
      res = visit(ctx.assignment());
      if(res != null)
        System.out.println("Result -> " + res);
      return res;
   }

   @Override public String visitID(CalculatorParser.IDContext ctx) {
      return ctx.ID().getText() + " = " + visit(ctx.expr());
   }

   @Override public String visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      String op = ctx.op.getText();
      if(op.equals("+") || op.equals("-"))
        return visit(ctx.expr(0)) + " " + visit(ctx.expr(1)) + " " + op;
      return null;
   }

   @Override public String visitExprSginal(CalculatorParser.ExprSginalContext ctx) {
      String signal = ctx.signal.getText();
      switch(signal){
        case "+":
          return visit(ctx.expr()) + " !+";
        case "-":
          return visit(ctx.expr()) + " !-";
        default:
          System.err.println("Error!");
          break;
      }
      return null;
   }

   @Override public String visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public String visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return ctx.Integer().getText(); 
   }

   @Override public String visitExprID(CalculatorParser.ExprIDContext ctx) {
      return ctx.ID().getText();
   }

   @Override public String visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      String op = ctx.op.getText();
      if(op.equals("*") || op.equals("/"))
        return visit(ctx.expr(0)) + " " + visit(ctx.expr(1)) + " " + op;
      return null;
   }
}
