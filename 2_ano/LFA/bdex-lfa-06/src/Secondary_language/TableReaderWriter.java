package Secondary_language;

import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import org.stringtemplate.v4.*;
import Shared.*;

public class TableReaderWriter 
{
   public static Table ReadTable(String fileName) {
      try {
         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromFileName(fileName);
         // create a lexer that feeds off of input CharStream:
         secondaryLexer lexer = new secondaryLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         secondaryParser parser = new secondaryParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at program rule:
         ParseTree tree = parser.program();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            Visitor visitor0 = new Visitor();
            return (Table)visitor0.visit(tree);
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
      return null;
   }

   public static void SaveTable(Table table, String filename) throws FileNotFoundException
    {
        ST tableST = templates.getInstanceOf("table");
        
        ST table_header = templates.getInstanceOf("table_header");
        ST table_body = templates.getInstanceOf("table_body");
        
        List<KeyValuePair<String, String>> columnInfo = table.GetColumnInfo();

        for(int i = 0; i < columnInfo.size(); i++)
        {
            KeyValuePair<String, String> kvp = columnInfo.get(i);
            
            ST col_declr = templates.getInstanceOf("col_declr");

            col_declr.add("name", kvp.key);
            col_declr.add("type", kvp.value);

            table_header.add("col_declr", col_declr.render());
        }

        tableST.add("header", table_header.render());

        int lineCount = table.GetSize();

        for(int i = 0; i < lineCount; i++)
        {
            Object[] line = table.GetLine(i);

            ST lineST = templates.getInstanceOf("body_line");
            for(int j= 0; j < line.length; j++)
            {
               if(line[j] instanceof String)
               {
                  lineST.add("col", "\"" + line[j].toString() + "\"");
               }
               else
               {
                  lineST.add("col", line[j].toString());
               }
            }

            table_body.add("line", lineST.render());
        }

        tableST.add("body", table_body.render());

        PrintWriter out = new PrintWriter(filename);

        out.println(tableST.render());

        out.close();
    }

    private static STGroup templates = new STGroupFile("Secondary_language/table.stg");
}
