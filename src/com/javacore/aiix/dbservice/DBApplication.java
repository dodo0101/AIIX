package com.javacore.aiix.dbservice;

import com.javacore.aiix.dbservice.data.QueryResult;
import com.javacore.aiix.dbservice.dbstate.DBState;
import com.javacore.aiix.dbservice.dbstate.DBStateInit;
import com.javacore.aiix.dbservice.dbstate.DBStateRunning;
import com.javacore.aiix.dbservice.dbstate.DBStateStop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum DBApplication {
    INSTANCE;

    public static final int PORT = 6701;
    public static final String APP_NAME = "DBService";
    
    public static final String DATA_ENCRYPTION_LEVEL = "LOW";

    public static final String OPERATION_GROUP = "(SELECT|DELETE)";
    public static final String FIELD_GROUP = "([*a-zA-Z, ]+)";
    public static final String SPACE = "([\\s])";
    public static final String FROM_GROUP = "(FROM)";
    public static final String TABLE_GROUP = "([a-zA-Z]+)$";

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
        Pattern p = Pattern.compile(OPERATION_GROUP + SPACE + FIELD_GROUP + SPACE + FROM_GROUP + SPACE + TABLE_GROUP);
        Matcher matcher = p.matcher(query); //

        if (matcher.find()) {
            System.out.println("Number of groups: " + matcher.groupCount());
            for (int i = 0, len = matcher.groupCount(); i <= len; i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
        return null;
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

}
