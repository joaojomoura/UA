import java.util.Iterator;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Execute extends HelloBaseVisitor<String> {

   @Override public String visitStat(HelloParser.StatContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
      System.out.println("Ola " + visit(ctx.name()));
      return visitChildren(ctx);
   }

   @Override public String visitFarewell(HelloParser.FarewellContext ctx) {
      System.out.println("Adeus " + visit(ctx.name()));
      return visitChildren(ctx);
   }

   @Override public String visitName(HelloParser.NameContext ctx) {
      Iterator<TerminalNode> iter = ctx.ID().iterator();
      String res = "";
      while(iter.hasNext()){
        res += iter.next() + " ";
        
      }
      return res;
   }
}
