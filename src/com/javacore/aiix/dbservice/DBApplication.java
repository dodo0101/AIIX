package com.javacore.aiix.dbservice;

import com.javacore.aiix.dbservice.data.query.QueryResult;
import com.javacore.aiix.dbservice.data.Table;
import com.javacore.aiix.dbservice.dbstate.DBState;
import com.javacore.aiix.dbservice.dbstate.DBStateInit;
import com.javacore.aiix.dbservice.dbstate.DBStateRunning;
import com.javacore.aiix.dbservice.dbstate.DBStateStop;
import com.javacore.aiix.dbservice.misc.DBQueryRegEx;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum DBApplication {
    INSTANCE;

    private Map<String, Table> tables = new HashMap<>();

    public static final String DATA_ENCRYPTION_LEVEL = "LOW";
    private DBState currentState;
    public DBState stateInit = new DBStateInit("Initializing");
    public DBState stateRun = new DBStateRunning("Running");
    public DBState stateStop = new DBStateStop("Shutting Down");

    public void start()  {
        changeState(stateInit);
    }

    public void stop() {
        currentState.onStop();
    }

    public QueryResult query(String query) {


        //String query = "SELECT id, fileName, lastName FROM Criminals";
        Pattern p = Pattern.compile(DBQueryRegEx.OPERATION_GROUP + DBQueryRegEx.SPACE + DBQueryRegEx.FIELD_GROUP + DBQueryRegEx.SPACE + DBQueryRegEx.FROM_GROUP + DBQueryRegEx.SPACE + DBQueryRegEx.TABLE_GROUP);
        Matcher matcher = p.matcher(query); //

        if (matcher.find()) {
            System.out.println("Number of groups: " + matcher.groupCount());
            for (int i = 0, len = matcher.groupCount(); i <= len; i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
        return null;
        //return currentState.onQuery(query);
    }

    public String getStateName() {
        return currentState.getName();
    }

    public void changeState(DBState state) {
        if (currentState != null) {
            if (currentState.equals(state)) {
                return;
            } else {
                currentState.exit();
            }
        }
        currentState = state;
        currentState.enter();
    }

    public void addTable(String tableName, Table table) {
        tables.put(tableName, table);
    }

    public Table getTable(String tableName) {
        return tables.get(tableName);
    }

}
