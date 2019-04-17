package com.javacore.aiix.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table {

    protected String name;

    protected List<String> columns;

    protected List<Record> records;

    {
        records = new ArrayList<Record>();
    }

    public Table(String name, List<String> columns) {
        this.name = name;
        this.columns = columns;
    }

    public List<String> getColumns() {
        return columns;                     //HOW TO MAKE IT SAFE?
    }

    public void insert(Record record) {
        records.add(record);
    }


    //"SELECT id, firstName, lastName;"
    public void select (String query) {



        //Loading...................100%
        //------------------------------
        //ID         firstName    lastName
        //------------------------------
        //1         Vladimir        Trump
        //100ms
        //2         Donald          Timoshenko
        //
    }

    public List<String> selectField(String fileName) {
        int index = columns.indexOf(fileName);
        Iterator it = records.iterator();
        List<String> result = new ArrayList<String>();

        while(it.hasNext()) {
            Record r = (Record) it.next();
            result.add(r.values.get(index));
        }
        return result;
    }

    public List<Record> select() {
        return null;
    }
}
