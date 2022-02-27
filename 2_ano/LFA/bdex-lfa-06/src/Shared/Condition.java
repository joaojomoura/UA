package Shared;

public class Condition
{
    private String colName;
    private Operation op;
    
    private Object cValue;
    
    public Condition(String colName, Operation op, Object value)
    {
        this.colName = colName;
        this.op=op;
        
        this.cValue = value;
    }

    public Condition(String colName, String op, Object value)
    {
        this.colName = colName;
        this.op = StringToConditionOp(op);
        
        this.cValue = value;
    }

    public String GetColName()
    {
        return colName;
    }

    public Operation GetOperation()
    {
        return op;
    }

    public Object GetConditionValue()
    {
        return cValue;
    }

    public boolean Process(Object val)
    {
        if(val instanceof Double)
        {
            return NumberEvalaluate((Double)val);
        }
        else if(val instanceof Integer)
        {
            return NumberEvalaluate(Double.valueOf((Integer)val));
        }
        else 
        {
            return TextEvalaluate((String)val);
        }
    }

    private boolean NumberEvalaluate(Double val)
    {
        Double cValue = 0.0;
        if(this.cValue instanceof Integer)
        {
            cValue = Double.valueOf((Integer)this.cValue);
        }
        else if(this.cValue instanceof Double)
        {
            cValue = (Double)this.cValue;
        }
        else //trying to compare string to a number??
        {
            return false; 
        }

        switch(op)
        {
            case GreaterThan:
                return val > cValue;
            case GreaterThanOrEquals:
                return val >= cValue;
            case SmallerThan:
                return val < cValue;
            case SmallerThanOrEquals:
                return val <= cValue;
            case Equals:
                return val.equals(cValue);
            case NotEquals:
                return !val.equals(cValue);
        }
        return false;
    }

    private boolean TextEvalaluate(String val)
    {
        if(!(this.cValue instanceof String)) return false; //trying to compare string to a number??

        String cValue = (String)this.cValue;

        switch(op)
        {
            case GreaterThan:
                return val.compareTo(cValue) > 0;
            case GreaterThanOrEquals:
                return val.compareTo(cValue) >= 0;
            case SmallerThan:
                return val.compareTo(cValue) < 0;
            case SmallerThanOrEquals:
                return val.compareTo(cValue) <= 0;
            case Equals:
                return val.equals(cValue);
            case NotEquals:
                return !val.equals(cValue);
        }
        return false;
    }

    private Condition.Operation StringToConditionOp(String txt)
    {
       switch(txt)
       {
          case "==":
             return Operation.Equals;
          case "!=":
             return Operation.NotEquals;
          case ">":
             return Operation.GreaterThan;
          case ">=":
             return Operation.GreaterThanOrEquals;
          case "<":
             return Operation.SmallerThan;
          case "<=":
             return Operation.SmallerThanOrEquals;
          default:
             return null;
       }
    }

    public enum Operation
    {
        GreaterThan,
        GreaterThanOrEquals,
        SmallerThan,
        SmallerThanOrEquals,
        Equals,
        NotEquals
    }
}
