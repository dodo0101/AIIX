package com.javacore.aiix.db;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataBase {

    Map<String, Table> tables;
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
