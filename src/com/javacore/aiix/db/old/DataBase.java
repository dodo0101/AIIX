package com.javacore.aiix.db.old;

import java.io.*;
import java.util.*;

public class DataBase {

    public static final String[] CRIMINALS_COLUMNS = new String[] {
            "id", "fileName"//fields from model
    };
    public static final String[] CRIME_PAMILY_COLUMNS = new String[] {
        "id", "name"
    };
    //how to initialize tables on start
    //

    public static final String OPERATION_GROUP = "(SELECT|DELETE)";
    public static final String FIELD_GROUP = "([*a-zA-Z, ]+)";
    public static final String SPACE = "([\\s])";
    public static final String FROM_GROUP = "(FROM)";
    public static final String TABLE_GROUP = "([a-zA-Z]+)$";
    
    static final Map<String, Table> tables;

    static {
        tables = new HashMap<>();
        tables.put("Criminals", new Table("Criminals", Arrays.asList(CRIMINALS_COLUMNS)));
        tables.put("CrimeFamily", new Table("CrimeFamily", Arrays.asList(CRIME_PAMILY_COLUMNS)));
    }
//SELECT WORKING HERE
// Db.query("SELECT ID, NAME, EMAIL FROM CRIMINALS WHERE ID = 123");
// 1. Keywords - select from
//

    private Object tableLock = new Object();

    public  List<Record> select() {
        System.out.println("Starting fetching records...");

        synchronized (tableLock) {
            try{
                Thread.sleep(500);
                System.out.println("Finished fetching records...");
            } catch (InterruptedException e) {

            }
        }

        return  null;
    }

    public  void update() {
        System.out.println("Starting updating database...");

        synchronized (tableLock) {
            try{
                Thread.sleep(10000);
                System.out.println("Finished updating database...");
            } catch (InterruptedException e) {

            }
        }

    }

    public static List<String[]> readDataFile(String fileName) {
        FileInputStream fis = null;
        List<String[]> result = new ArrayList<String[]>();

        BufferedReader br;
        try {
            fis = new FileInputStream(fileName);
            br = new BufferedReader(new InputStreamReader(fis));
            String line;
            while((line = br.readLine()) != null) {
                System.out.println(line);
                result.add(line.split(" "));
            }
        } catch (FileNotFoundException fnfe) {

        } catch (IOException ioe) {

        } finally {
            try {
                fis.close();
            } catch (IOException e) {

            }
        }
        return result;
    }

    public void delete() {

    }

    public void insert(Record record, Table table) {

    }

}
