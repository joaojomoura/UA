package SemanticCheck.Types;
public class ColumnType extends Type{
    public ColumnType(){
        super("column");
    }
    public boolean isNumeric(){
        return false;
    }
}
