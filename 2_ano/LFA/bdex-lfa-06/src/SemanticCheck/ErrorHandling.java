package SemanticCheck;
import static java.lang.System.*;
import java.io.PrintStream;
import org.antlr.v4.runtime.ParserRuleContext;

public class ErrorHandling{
    protected static PrintStream logFile = out;
    protected static int warningCont = 0;
    protected static int errorCont = 0;
    public static final String red = "\033[0;31m";
    public static final String green = "\033[0;32m";
    public static final String yellow = "\033[0;33m";
    public static final String reset = "\033[0m";
    protected static final String[] types = {"Info", "Warning", "Error"};
    protected static final String[] typeColors = {green, yellow, red};
    
    public static void newLine(){
        logFile.println();
        logFile.flush();
    }
    public static void printInfo(String text){
        assert text != null && text.length() > 0;
        printMessage(text, 1);
    }
    public static void printWarning(String text){
        assert text != null && text.length() > 0;
        warningCont++;
        printMessage(text, 2);
    } 
    public static void printError(String text){
        assert text != null && text.length() > 0;
        errorCont++;
        printMessage(text, 3);
    }

    public static void printInfo(int line, String text){
        assert line > 0;
        assert text != null && text.length() > 0;
        printMessage(line, text, 1);
    }
    public static void printWarning(int line, String text){
        assert line > 0;
        assert text != null && text.length() > 0;
        warningCont++;
        printMessage(line, text, 2);
    } 
    public static void printError(int line, String text){
        assert line > 0;
        assert text != null && text.length() > 0;
        errorCont++;
        printMessage(line, text, 3);
    }

    public static void printInfo(ParserRuleContext ctx, String text){
        assert ctx != null;
        assert text != null && text.length() > 0;
        printMessage(ctx, text, 1);
    }
    public static void printWarning(ParserRuleContext ctx, String text){
        assert ctx != null;
        assert text != null && text.length() > 0;
        warningCont++;
        printMessage(ctx, text, 2);
    } 
    public static void printError(ParserRuleContext ctx, String text){
        assert ctx != null;
        assert text != null && text.length() > 0;
        errorCont++;
        printMessage(ctx, text, 3);
    }

    public static void printMessage(String text, int type){
        logFile.printf("[%s %s %s] %s\n", typeColors[type-1], types[type-1], reset, text);
        logFile.flush();
    }
    public static void printMessage(int line, String text, int type){
        logFile.printf("[%s %s %s at line %d] %s\n", typeColors[type-1], types[type-1], reset, line, text);
        logFile.flush();
    }
    public static void printMessage(ParserRuleContext ctx, String text, int type){
        printMessage(ctx.getStart().getLine(), text, type);
    }


    public static void redirectLogFile(PrintStream logFile){
        assert logFile != null;
        ErrorHandling.logFile = logFile;
    }

    public static int errorCont(){
        return errorCont;
    }
    public static void registerError(){
        errorCont++;
    }
    public static boolean error(){
        return errorCont > 0;
    }
    public static int warningCont(){
        return warningCont;
    }

    public static void reset(){
        errorCont = 0;
        warningCont = 0;
    }
}