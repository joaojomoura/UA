package SemanticCheck.Types;
public class IntegerType extends Type {
    public IntegerType(){
        super("int");
    }
    public boolean isNumber(){
        return true;
    }
    @Override public boolean subType(Type other) {
        return super.subType(other) || other.name().equals("real");
     }  
}
