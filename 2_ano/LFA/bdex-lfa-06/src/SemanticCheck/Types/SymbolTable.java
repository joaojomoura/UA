package SemanticCheck.Types;
import java.util.*;
public class SymbolTable {
    protected Map<String, Symbol> symbolTable;
    public SymbolTable(){
        this.symbolTable = new HashMap<String, Symbol>();
    }
    public boolean containsSymbol(String str){
        return symbolTable.containsKey(str);
    }
    public Symbol getSymbol(String str){
        return symbolTable.get(str);
    }
    public void putSymbol(String str, Symbol symbol){
        symbolTable.put(str, symbol);
    }
    public Symbol get(String varName) {
        return null;
    }
}
