package SemanticCheck.Types;
public abstract class Symbol {
    private Type type;
    private String name;
    private Value value;
    private boolean valueDefined;
    private String varName;
    private Type subType; 

    public Symbol(String name, Type type){
        assert type != null && name != null;
        this.type = type;
        this.name = name;
    }
    public Type getSubType() {
        return subType;
    }
    public String getVarName() {
        return varName;
    }
    public boolean isValueDefined() {
        return valueDefined;
    }
    public Value getValue() {
        return value;
    }
    public String getName() {
        return name;
    }
    public Type getType() {
        return type;
    }
    public void setSubType(Type subType) {
        assert subType != null;
        this.subType = subType;
    }
    public void setVarName(String varName) {
        assert varName != null;
        this.varName = varName;
    }
    public void setValueDefined(boolean valueDefined) {
        this.valueDefined = valueDefined;
    }
    public void setValue(Value value) {
        assert value != null;
        this.value = value;
    }
}
