package com.javacore.aiix.dbservice.dbstate;

import com.javacore.aiix.dbservice.DBApplication;
import com.javacore.aiix.dbservice.data.Table;
import com.javacore.aiix.dbservice.data.TableMetaData;
import com.javacore.aiix.dbservice.misc.DBConstants;
import com.javacore.aiix.dbservice.misc.DataHandler;
import com.javacore.aiix.dbservice.misc.Utils;

public class DBStateInit extends DBState {
    @Override
    public void enter() {
        System.out.println("Entering DBInit state");
        initTables();
        DBApplication.INSTANCE.changeState(DBApplication.INSTANCE.stateRun);
    }

    private void initTables() {
        Utils.readDir(DBConstants.TABLE_DIR, new DataHandler() {
            @Override
            public void handleFile(String filePath) {
                TableMetaData metaData = TableMetaData.loadFromFile(filePath);
                Table table = new Table(metaData);
                table.load();
            }
        });
    }

    @Override
    public void onStop() {
        //check if everything is ok
        DBApplication.INSTANCE.changeState(DBApplication.INSTANCE.stateStop);
    }
}
