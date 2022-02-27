package SemanticCheck;
import org.antlr.v4.runtime.*;
import java.util.*;
public class ErrorHandlingListener extends BaseErrorListener {
    @Override public void syntaxError(Recognizer<?, ?> recognizer,
          Object offendingSymbol,
          int line, int charPositionInLine,
          String msg,
          RecognitionException e)
    {
       ErrorHandling.printError(line, msg);
    }
 }
 