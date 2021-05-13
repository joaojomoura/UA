import java.util.HashMap;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class LInterpreter extends NumbersBaseListener {

   HashMap <Integer, String> map = new HashMap<>();

   @Override public void exitProgram(NumbersParser.ProgramContext ctx) {
   }


   @Override public void exitLine(NumbersParser.LineContext ctx) {
    int number = Integer.parseInt(ctx.INT().getText());
    String id = ctx.ID().getText();
    map.put(number, id);
    System.out.println("Number = " + number + "\nExtenso: " + map.get(number));
    ctx.res = "";
   }



}
