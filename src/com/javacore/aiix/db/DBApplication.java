package com.javacore.aiix.db;

import com.javacore.aiix.db.data.QueryResult;
import com.javacore.aiix.db.dbstate.DBState;
import com.javacore.aiix.db.dbstate.DBStateInit;
import com.javacore.aiix.db.dbstate.DBStateRunning;
import com.javacore.aiix.db.dbstate.DBStateStop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum DBApplication {
    INSTANCE;

    public static final String DATA_ENCRYPTION_LEVEL = "LOW";

    public static final String OPERATION_GROUP = "(SELECT|DELETE)";
    public static final String FIELD_GROUP = "([*a-zA-Z, ]+)";
    public static final String SPACE = "([\\s])";
    public static final String FROM_GROUP = "(FROM)";
    public static final String TABLE_GROUP = "([a-zA-Z]+)$";

    private DBState currentState;
    public DBState stateInit = new DBStateInit();
    public DBState stateRun = new DBStateRunning();
    public DBState stateStop = new DBStateStop();

    public void start() {
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
