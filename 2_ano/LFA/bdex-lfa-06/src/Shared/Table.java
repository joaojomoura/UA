package Shared;

import java.util.*;

public class Table 
{
    private LinkedHashMap<String, Column> table; //can i use wildcards here since we're gonna have columns of different types?
    private int size;
    
    public Table(KeyValuePair<String, Column.Type>[] columns)
    {
        table = new LinkedHashMap<String, Column>();

        for(int i = 0 ; i < columns.length; i++)
        {
            this.AddColumn(columns[i]);
        }

        size = 0;
    }

    public Table(List<KeyValuePair<String, Column.Type>> columns)
    {
        table = new LinkedHashMap<String, Column>();

        for(int i = 0 ; i < columns.size(); i++)
        {
            this.AddColumn(columns.get(i));
        }

        size = 0;
    }


    public Table()
    {
        table = new LinkedHashMap<String, Column>();
        size = 0;
    }

    public Table(int size)
    {
        table = new LinkedHashMap<String, Column>();
        this.size = size;
    }


    //returns column info for this table. i.e. the name and type.
    public List<KeyValuePair<String, String>> GetColumnInfo()
    {
        List<KeyValuePair<String, String>> result = new ArrayList<KeyValuePair<String, String>>();
        
        table.forEach((k, v) -> 
        {
            result.add(new KeyValuePair<String,String>(k, v.GetType().toString()));
        });

        return result;
    }

    public List<String> GetColumnNames()
    {
        List<String> result = new ArrayList<String>();

        table.forEach((k, v) -> 
        {
            result.add(k);
        });

        return result;
    }

    public int GetSize()
    {
        return size;
    }

    public Boolean ContainsColumn(String columnName)
    {
        return table.containsKey(columnName);
    }

    public Column<?> GetColumnByName(String columnName)
    {
        if(ContainsColumn(columnName))
        {
            return table.get(columnName);
        }
        return null;
    }

    public void AddColumn(KeyValuePair<String, Column.Type> column)
    {
        if(ContainsColumn(column.key))
        {
            System.err.println("Failed to add Column " + column.key + " to table because it already exists!");
            return;
        }
    
        switch(column.value) 
        {
            case Int:
                table.put(column.key, new Column<Integer>(Column.Type.Int));
                break;
            case Double:
                table.put(column.key, new Column<Double>(Column.Type.Double));
                break;
            case String:
                table.put(column.key, new Column<String>(Column.Type.String));
                break;
        }
    }

    //no kvp because java overloading is dumb. public void AddColumn(KeyValuePair<String, Column> column) would work perfecly in C#
    @SuppressWarnings("unchecked")
    public void AddColumn(String colName, Column<?> column) 
    {
        if(ContainsColumn(colName))
        {
            System.err.println("Failed to add Column " + colName + " to table because it already exists!");
            return;
        }
        
        int colSize = column.GetSize();
        if(colSize != size)
        {
            if(colSize > size)
            {
                int difference = colSize - size;
                int size = colSize - 1;
                for(int i = 0; i < difference; i++, size--)
                {
                    column.column.remove(size);
                }
            }
            else
            {
                int difference = size - colSize;
                for(int i = 0; i < difference; i++)
                {
                    switch(column.GetType()) 
                    {
                        case Int:
                            ((Column<Integer>)column).Insert(0);
                            break;
                        case Double:
                            ((Column<Double>)column).Insert(0.0);
                            break;
                        case String:
                            ((Column<String>)column).Insert("");
                            break;
                    }
                }
            }
        }

        table.put(colName, column);
    }

    public void RemoveColumn(String columnName)
    {
        if(ContainsColumn(columnName)) table.remove(columnName);
    }


    //inserts a line in this table.
    //each KeyValuePair<String, Object> represents the name of the column and the object that we´re inserting.
    //this code assumes that object is of the correct type specified by its column.
    //non specified columns will be filled with their default values.
    @SuppressWarnings("unchecked")
    public void InsertLine(KeyValuePair<String, Object>[] line)
    {
        HashSet<String> keys = new HashSet<String>(table.keySet());
        
        for(int i = 0; i < line.length; i++)
        {
            KeyValuePair<String, Object> kvp = line[i];

            if(ContainsColumn(kvp.key))
            {
                Column<?> col = table.get(kvp.key);
                switch(col.GetType()) 
                {
                    case Int:
                        ((Column<Integer>)col).Insert((Integer)kvp.value);
                        break;
                    case Double:
                        ((Column<Double>)col).Insert((Double)kvp.value);
                        break;
                    case String:
                        ((Column<String>)col).Insert((String)kvp.value);
                        break;
                }

                keys.remove(kvp.key);
            }
        }

        for(String key : keys) //insert default values in columns where no value was specified
        {
            Column<?> col = table.get(key);
            switch(col.GetType()) 
            {
                case Int:
                    ((Column<Integer>)col).Insert(0);
                    break;
                case Double:
                    ((Column<Double>)col).Insert(0.0);
                    break;
                case String:
                    ((Column<String>)col).Insert("");
                    break;
            }
        }

        size++;
    }

    //inserts a line in this table.
    //each object represents the object that we´re inserting.
    //these need to be ordered in the same order as the columns i.e. the order they´re declared in.
    //is an object is null the column that it belongs to will be filled with the default value.
    @SuppressWarnings("unchecked")
    public void InsertLine(Object[] line)
    {
        if(this.table.size() != line.length) 
        {
            //do error stuff
            System.out.println("Table column size doesn't match the amount of elements being addded");
        }

        List<Column<?>> cols = new ArrayList(table.values()); //these should be in the column order since table is a LinkedHashMap

        for(int i = 0; i < line.length; i++)
        {
            Object value = line[i];

            Column<?> col = cols.get(i);

            if(value == null) //if no value we insert default value
            {
                switch(col.GetType()) 
                {
                    case Int:
                        ((Column<Integer>)col).Insert(0);
                        break;
                    case Double:
                        ((Column<Double>)col).Insert(0.0);
                        break;
                    case String:
                        ((Column<String>)col).Insert("");
                        break;
                }
            }
            else
            {
                //whoever is dealing with error stuff must decide if types don't match what should we do?
                //we can either insert a default value or just throw some exception
                switch(col.GetType()) 
                {
                    case Int:
                        if(value instanceof Integer)
                        {
                            ((Column<Integer>)col).Insert((Integer)value);
                        }
                        break;
                    case Double:
                        if(value instanceof Double)
                        {
                            ((Column<Double>)col).Insert((Double)value);
                        }
                        break;
                    case String:
                        if(value instanceof String)
                        {
                            ((Column<String>)col).Insert((String)value);
                        }
                        break;
                }
            }
        }
        size++;
    }

    public void RemoveLine(int i)
    {
        if(i < size)
        {
            table.forEach((k, v) -> 
            {
                v.Remove(i);
            });
        }
        size--;
    }

    public Object[] GetLine(int index)
    {
        if(index < 0) return null;

        List<Column<?>> cols = new ArrayList(table.values());

        int colSize = cols.size();

        Object[] arr = new Object[colSize];

        for(int i = 0; i < colSize; i++)
        {
            Column<?> col = cols.get(i);

            arr[i] = col.Get(index);
        }

        return arr;
    }

    //extracts a table from this table.
    //conditions are composed of the column an operand and a value
    //these conditions will be checked and if all of these match for each line that line will be in the resulting table
    //if columnsToExtract is null this will extract every column
    public Table Extract(String[] columnsToExtract, Condition[] conditions)
    {
        if(columnsToExtract == null) //extract all columns
        {
            columnsToExtract = (String[])this.table.keySet().toArray();
        }
        
        HashSet<String> colSet = new HashSet<String>(Arrays.asList(columnsToExtract));

        List<KeyValuePair<String, Column.Type>> cols = new ArrayList<KeyValuePair<String, Column.Type>>();

        this.table.forEach((k, v) -> 
        {
            cols.add(new KeyValuePair<String, Column.Type>(k, v.GetType()));
        });

        Table result = new Table(cols); 

        // only add lines that match all conditions

        for(int i = 0; i < size; i++)
        {
            int k = 0;
            for(int j = 0; j < conditions.length; j++)
            {
                Condition c = conditions[j];
                Column<?> col = this.GetColumnByName(c.GetColName());
                if(col == null) continue;  //we might want to handle this differently

                if(!c.Process(col.Get(i))) break; //if one condition fails there's no need to check the others
                else k++;
            }

            if(k == conditions.length) //do all the conditions match for this line?
            {
                result.InsertLine(this.GetLine(i));
            }
        }

        List<String> columnsToRemove = new ArrayList<String>();

        //remove unwanted columns
        result.table.forEach((k, v) -> 
        {
            if(!colSet.contains(k))
            {
                columnsToRemove.add(k);
            }
        });

        for(int i = 0; i < columnsToRemove.size(); i++)
        {
            result.RemoveColumn(columnsToRemove.get(i));
        }

        return result;
    }

    public void Remove(Condition[] conditions)
    {
        for(int i = 0; i < size; i++)
        {
            int k = 0;
            for(int j = 0; j < conditions.length; j++)
            {
                Condition c = conditions[j];
                Column<?> col = this.GetColumnByName(c.GetColName());
                if(col == null) continue;  //we might want to handle this differently

                if(!c.Process(col.Get(i))) break; //if one condition fails there's no need to check the others
                else k++;
            }

            if(k == conditions.length) //do all the conditions match for this line?
            {
                this.RemoveLine(i); //decreases size
                i--; //we remove the line at i so all the following lines move up by one;
            }
        }
    }

    //replaces specified columns with specified values for lines that match all conditions
    //values to replace are column/value
    //assumes value is of correct type for the column
    @SuppressWarnings("unchecked")
    public void Modify(KeyValuePair<String, Object>[]valuesToReplace, Condition[] conditions)
    {
        for(int i = 0; i < size; i++)
        {
            int k = 0;
            for(int j = 0; j < conditions.length; j++)
            {
                Condition c = conditions[j];
                Column<?> col = this.GetColumnByName(c.GetColName());
                if(col == null) continue;  //we might want to handle this differently

                if(!c.Process(col.Get(i))) break; //if one condition fails there's no need to check the others
                else k++;
            }

            if(k == conditions.length) //do all the conditions match for this line?
            {
                for(int l = 0; l < valuesToReplace.length; l++)
                {
                    KeyValuePair<String, Object> kvp = valuesToReplace[l];
                    if(ContainsColumn(kvp.key))
                    {
                        Column<?> col = GetColumnByName(kvp.key);

                        switch(col.GetType()) 
                        {
                            case Int:
                                ((Column<Integer>)col).Replace(i, (Integer)kvp.value);
                                break;
                            case Double:
                                ((Column<Double>)col).Replace(i, (Double)kvp.value);
                                break;
                            case String:
                                ((Column<String>)col).Replace(i, (String)kvp.value);
                                break;
                        }
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void ModifyColValue(String colName, int index, Object value)
    {
        Column<?> col = GetColumnByName(colName);

        if(col == null) return;

        Column.Type type= col.GetType();

        switch(type)
        {
            case Int:
                if(value instanceof Integer)
                {
                    ((Column<Integer>)col).Replace(index, (Integer)value);
                }
                break;
            case Double:
                if(value instanceof Double)
                {
                    ((Column<Double>)col).Replace(index, (Double)value);
                }
                break;
            case String:
                if(value instanceof String)
                {
                    ((Column<String>)col).Replace(index, (String)value);
                }
                break;
        }
    }

    //joins this table with another table.
    //the resulting table size is the size of the bigger table.
    //columns of the smaller table will be filled with default values until their size matches with resulting size.
    //does´t add a column if it already exists so if both tables have a column with the same name only "this" version of it will be on result.
    public Table Join(Table t2)
    {
        int newSize = this.size > t2.size ? this.size : t2.size;

        Table result = new Table(newSize);

        this.table.forEach((k, v) -> 
        {
            result.AddColumn(k, v.Clone());      
        });

        t2.table.forEach((k, v) -> 
        {
            result.AddColumn(k, v.Clone());       
        });
        
        return result;
    }


    // Example output
    // -------------------------------------------------------------------
    // |    c1    |    c2    |    c3    |    c4    |    c5    |    c6    |
    // -------------------------------------------------------------------
    // |   1.36   |   1.5    |  "bye"   |    1     |   36.3   |   0.54   |
    // |   1.25   |  455.56  | "hello"  |   589    |   15.5   |   0.66   |
    // |   1.67   |  123.33  | "hello"  |    87    |   55.0   |   0.35   |
    // -------------------------------------------------------------------

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder(((this.table.size()*10)+this.table.size()+ 2) * (size+4));   

        List<String> columnNames = this.GetColumnNames();

        StringBuilder sb = new StringBuilder(128);

        sb.append('|');
        for(int i = 0; i < columnNames.size(); i++)
        {
            sb.append(StringUtils.centerString(10, columnNames.get(i)));
            sb.append('|');
        }
        sb.append('\n');

        StringBuilder sb2 = new StringBuilder(128);
        for(int i = 1; i < sb.length(); i++)
        {
            sb2.append('-');
        }
        sb2.append('\n');

        result.append(sb2);
        result.append(sb);
        result.append(sb2);

        for(int i = 0; i < size; i++)
        {
            StringBuilder sbT = new StringBuilder(128);
            for (Object val: this.GetLine(i)) 
            {
                sbT.append('|');
                if(val instanceof String)
                {
                    sbT.append(StringUtils.centerString(10, "\""+val.toString()+"\""));
                }
                else
                {
                    sbT.append(StringUtils.centerString(10, val.toString()));
                }
            }
            sbT.append("|\n");
            result.append(sbT);
        }
        result.append(sb2);

        return result.toString();
    }
}
