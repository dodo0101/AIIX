package com.javacore.aiix.dbservice.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//Have inside String array
//now we want get value from record with current value
//getInt is overloaded - if value didn`t find - you will have some value

public class Record {

    List<String> values;
    List<String> columns;

    {
        values = new ArrayList<String>();
    }

    //25; Alexey;Rodin;javacore2019h1@gmail.com

    public Record(Table table) {
        columns = table.getColumns();

    }

    public void setValues(String[] values) {
        this.values.clear();
        this.values = Arrays.asList(values);
        //this.values.add("test");             //testing of failure
    }

    public int getInt(String fieldName) throws FieldNotFoundExceptione {
       //Dangerous block of code
            int index = columns.indexOf(fieldName);
            if (index == -1) {
                throw new FieldNotFoundExceptione("FIELD NOT FOUND: " + fieldName);
            }

        return Integer.parseInt(values.get(index));
    }

    public int getInt(String fieldName, int defaultValue) throws FieldNotFoundExceptione {
        //Dangerous block of code
        int index = columns.indexOf(fieldName);
        if (index == -1) {
            throw new FieldNotFoundExceptione("FIELD NOT FOUND: " + fieldName);
        }

        String valueString = values.get(index);
        if (valueString == null) return defaultValue;
        return Integer.parseInt(valueString);
    }

    public boolean getBoolean(String fieldName) throws FieldNotFoundExceptione {
        //Dangerous block of code
        int index = columns.indexOf(fieldName);
        if (index == -1) {
            throw new FieldNotFoundExceptione("FIELD NOT FOUND: " + fieldName);
        }

        return Boolean.parseBoolean(values.get(index));
    }

    public class FieldNotFoundExceptione extends Exception {
        public FieldNotFoundExceptione (String msg) {
            super(msg);
        }
    }


}
