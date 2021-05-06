public class Interpreter extends CalculatorBaseVisitor<Integer> {


   @Override public Integer visitStat(CalculatorParser.StatContext ctx) {
      Integer res = null;
      res = visit(ctx.expr()); 
      if(res != null)
        System.out.println("Result= " + res);
      return res;
   }

   @Override public Integer visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      Integer res = null;
      Integer op1 = visit(ctx.expr(0));
      Integer op2 = visit(ctx.expr(1));
      String op = ctx.op.getText();
      if(op1 != null && op2 != null){
        if(op.equals("+"))
          res = op1 + op2;
        if(op.equals("-"))
          res = op1 - op2;
      }
      return res;
   }

   @Override public Integer visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr()); 
   }

   @Override public Integer visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Integer.parseInt(ctx.Integer().getText());  
   }

   @Override public Integer visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      Integer res = null;
      Integer op1 = visit(ctx.expr(0));
      Integer op2 = visit(ctx.expr(1));
      String op = ctx.op.getText();
      if(op1 != null && op2 != null){
        if(op.equals("*"))
          res = op1 * op2;
        if(op.equals("%"))
          res = op1 % op2;
        if(op.equals("/"))
          if(op2 != 0)
            res = op1 / op2;
          else
            System.err.println("Error: Operand 2 can not be 0");
      }
      return res;
   }
}
