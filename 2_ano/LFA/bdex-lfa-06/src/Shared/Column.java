package Shared;

import java.util.*;

public class Column<T>
{
    public List<T> column;
    private Type type;
    
    public Column(Type type)
    {
        this.column = new ArrayList<T>();
        this.type = type;
    }

    public Column(List<T> column, Type type)
    {
        this.column = column;
        this.type = type;
    }
    
    public T Get(int i)
    {
        return column.get(i);
    }

    public void Insert(T e)
    {
        column.add(e);
    }

    public void Remove(int i)
    {
        column.remove(i);
    }

    public void Replace(int i, T rElem)
    {
        column.set(i, rElem);
    }

    public int GetSize()
    {
        return column.size();
    }

    public Type GetType()
    {
        return type;
    }

    public Column<T> Clone()
    {
        return new Column<T>(new ArrayList<T>(this.column), this.type);
    }

    public int GetMaxSize()
    {
        int max = 10;
        for(T value : this.column)
        {
            int curr = (value.toString()).length();
            if(curr > max) max = curr;
        }
        return max;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        int size = this.GetMaxSize()+2;

        if(size > 20) size = 20;

        StringBuilder sb2 = new StringBuilder(size+3);
        for(int i = 0; i < size+2; i++)
        {
            sb2.append('-');
        }
        sb2.append('\n');

        sb.append(sb2);

        for(T value : this.column)
        {
            sb.append('|');
            if(value instanceof String)
            {
                String vStr = "\""+value.toString()+"\"";
                int len = vStr.length();
                if(len > size)
                {
                    vStr = vStr.substring(0, size-4);
                    vStr += "...\"";
                }
                sb.append(StringUtils.centerString(size, vStr));
            }
            else
            {
                sb.append(StringUtils.centerString(size, value.toString()));
            }
            sb.append("|\n");
        }

        sb.append(sb2);

        return sb.toString();
    }

    public enum Type {
        String,
        Int,
        Double;

        @Override
        public String toString() 
        {
            switch(this) 
            {
                case String: return "text";
                case Int: return "int";
                default: return "double";
            }   
        }
    }
}
