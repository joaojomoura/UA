import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.*;

import BdeX_Language.*;
import Shared.*;
import Secondary_language.*;
import SemanticCheck.*;
import SemanticCheck.Types.*;

public class BdeXMain {
   public static void main(String[] args) throws FileNotFoundException
   {
      if(args.length != 1)
      {
         System.err.println("Usage java BdeXMain filename");
         System.exit(-1);
      }
      
      try {
         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromFileName(args[0]);
         // create a lexer that feeds off of input CharStream:
         BdeXLexer lexer = new BdeXLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         BdeXParser parser = new BdeXParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at main rule:
         ParseTree tree = parser.main();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            SemanticCheck check = new SemanticCheck();
            Boolean result = (Boolean)check.visit(tree);

            if(result)
            {
               BdeXCompiler visitor0 = new BdeXCompiler();
               ST res = (ST)visitor0.visit(tree);

               PrintWriter out = new PrintWriter("Program.java");

               out.println(res.render());

               out.close();
            }
         }
      }
      catch(IOException e) {
         e.printStackTrace();
         System.exit(1);
      }
      catch(RecognitionException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }
}
