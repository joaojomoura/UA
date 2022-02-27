package SemanticCheck.Types;
import Shared.Table;
public abstract class Value {
    public Type type(){
        assert false;
        return null;
    }
    public void setIntValue(int value){
        assert false;
    }
    public void setDoubleValue(double value){
        assert false;
    }
    public void setStringValue(String value){
        assert false;
    }
    public void setTableValue(Table value){
        assert false;
    }
    public int intValue(){
        assert false;
        return 0;
    }
    public double doubleValue(){
        assert false;
        return 0.0;
    }
    public String stringValue(){
        assert false;
        return "";
    }
    public Table tableValue(){
        assert false;
        return null;
    }
}
