package SemanticCheck.Types;
public class TextType extends Type{
    public TextType(){
        super("text");
    }
    public boolean isNumber(){
        return false;
    }
}
