package SemanticCheck;

import java.util.*;
import SemanticCheck.Types.*;

public class TypeChecker 
{
    private HashMap<String, Type> map;

    public TypeChecker()
    {
        map = new HashMap<String, Type>();
    }

    public boolean CreateVariable(String variableName, Type target)
    {
        if(map.containsKey(variableName))
        {
            return false;
        }

        map.put(variableName, target);

        return true;
    }

    // public boolean CheckTypeAssignment(String variableName, Type target)
    // {
    //     if(!map.containsKey(variableName))
    //     {
    //         ErrorHandling.printError("Undefined variable " + variableName + "!");
    //         return false;
    //     }

    //     Type variableType = map.get(variableName);

    //     if(variableType.isNumber() && !target.isNumber())
    //     {
    //         ErrorHandling.printError("Cannot assign a numeric type to a non numeric type");
    //         return false;
    //     }

    //     if(!variableType.compareTo(target))
    //     {
    //         ErrorHandling.printError("Cannot assign a " + target.name() + " to a " + variableType.name() + "!");
    //         return false;
    //     }

    //     return true;
    // }

    public boolean DoesVariableExist(String varName)
    {
        return map.containsKey(varName);
    }

    public Type GetVariableType(String varName)
    {
        return map.get(varName);
    }

    // public enum Type
    // {
    //     Int,
    //     Double,
    //     Column,
    //     Table,
    //     text
    // }
}
