package com.javacore.aiix.dbservice.data;

import com.javacore.aiix.dbservice.misc.DataHandler;
import com.javacore.aiix.dbservice.misc.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Table class has rows
 * */
public class Table {

    private List<TableRow> rows;
    private TableMetaData metaData;

    public Table(TableMetaData metaData) {
        this.metaData = metaData;
        rows = new ArrayList<>();
    }

    public void load() {
        Utils.readFileLineByLine(metaData.getPathToData(), new DataHandler() {
            @Override
            public void handleString(String line) {
                TableRow row = new TableRow();
                row.setValues(line);
                addRow(row);
            }
        });
        System.out.println(this);
    }

    public void save() {
            //TODO - implement Table Saving
    }

    public void addRow(TableRow row) {
        rows.add(row);
    }

    @Override
    public String toString() {
        String result = "\n" + metaData.getTableName();
        result += "\nStructure file: " + metaData.getPathToStructure();
        result += "\nData file: " + metaData.getPathToStructure();
        result += "\n" + metaData.getColumns();
        result += "\nnumber of rows: " + rows.size();
        return result;
    }

    public List<List<String>> collect(String[] fields) {
        List<List<String>> result = new ArrayList<>();
        int[] indexes = new int[fields.length];
        for (int i = 0, len = fields.length; i < len; i++) {
            int index = getFieldIndex(fields[i]);
            if (index != -1) {
                indexes[i] = index;
            }
        }
        for (TableRow row : rows) {
            result.add(collectFieldValues(indexes, row));
        }
        return result;
    }

    public int getFieldIndex(String fieldName) {
        return metaData.getColumnIndex(fieldName);
    }

    public List<String> collectFieldValues(int[] indexes, TableRow row) {
        List<String> result = new ArrayList<>();
        for (int i : indexes) {
            result.add(row.getValues().get(i));
        }
        return result;
    }
}

