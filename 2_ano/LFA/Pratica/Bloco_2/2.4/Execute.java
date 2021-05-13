public class Execute extends PrefixCalculatorBaseVisitor<Double> {


   @Override public Double visitStat(PrefixCalculatorParser.StatContext ctx) {
    Double res = visit(ctx.expr());
    if(res != null)
      System.out.println("Result: " + res);
    return res; 
   }

   @Override public Double visitExpPrefix(PrefixCalculatorParser.ExpPrefixContext ctx) {
    double res = 0;
    Double op1 = visit(ctx.expr(0));
    Double op2 = visit(ctx.expr(1));
    if(op1 != null && op2 != null)
      switch(ctx.op.getText()){
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
          if(op2 != 0)
            res = op1 + op2;
          else
            System.out.println("Error!!");
          break;
        default:
          System.out.println("Wrong operator");
          break;
      }
    return res;
   }

   @Override public Double visitExprNumber(PrefixCalculatorParser.ExprNumberContext ctx) {
      return Double.parseDouble(ctx.Number().getText());
   }
}
