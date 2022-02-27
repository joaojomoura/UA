package SemanticCheck.Types;
public abstract class Type {
    protected final String name;

    protected Type(String name){
        assert name != null;
        this.name = name;
    }

    public boolean compareTo(Type other){
        return name.equals(other.name());
    }
    public String name(){
        return name;
    }
    public boolean isNumber(){
        return false;
    }
    public boolean subType(Type other){
        assert other != null;
        return name.equals(other.name());
    }
    @Override 
    public String toString(){
        return name;
    }
}
