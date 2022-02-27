package SemanticCheck.Types;
public class SymbolType extends Symbol{
    public SymbolType(String name, Type type){
        super(name, type);
    }
    public boolean isNumeric(){
        return false;
    }
}
