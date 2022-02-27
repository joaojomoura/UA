package SemanticCheck.Types;
public class DoubleType extends Type{
    public DoubleType(){
        super("double");
    }
    public boolean isNumber(){
        return true;
    }
}
