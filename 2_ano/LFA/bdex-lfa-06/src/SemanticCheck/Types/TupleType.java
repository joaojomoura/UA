package SemanticCheck.Types;
public class TupleType extends Type{
    public TupleType(){
        super("tuplo");
    }
    public boolean isNumeric(){
        return false;
    }
}
