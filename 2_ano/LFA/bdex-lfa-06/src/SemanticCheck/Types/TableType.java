package SemanticCheck.Types;
public class TableType extends Type{
    public TableType(){
        super("table");
    }
    public boolean isNumeric(){
        return false;
    }
}
