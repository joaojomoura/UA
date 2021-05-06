public class Interpreter extends SuffixCalculatorBaseVisitor<Double> {

   @Override public Double visitStat(SuffixCalculatorParser.StatContext ctx) {
      Double res = null;
      res = visit(ctx.expr());
      if(res != null)
        System.out.println("Result: " + res);
      return res;
   }

   @Override public Double visitExprNumber(SuffixCalculatorParser.ExprNumberContext ctx) {
      return Double.parseDouble(ctx.Number().getText()); 
   }

   @Override public Double visitExprSuffix(SuffixCalculatorParser.ExprSuffixContext ctx) {
      Double res = null;
      Double op1 =  visit(ctx.expr(0));
      Double op2 =  visit(ctx.expr(1));
      if(op1 != null && op2 != null){
        switch (ctx.op.getText()){
          case "+":
            res = op1 + op2;
            break;
          case "-":
            res = op1 - op2;
            break;
          case "*":
            res = op1 * op2;
            break;
        
          case "/":
            if(op2 == 0)
              System.err.println("Error: Operand 2 cannot be 0!");
            else{
              res = op1 / op2;
            }
            break;
        }
      }
      return res;
   }
}
