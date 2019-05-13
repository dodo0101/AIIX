package com.javacore.aiix.dbservice.dbstate;

import com.javacore.aiix.dbservice.DBApplication;
import com.javacore.aiix.dbservice.data.Table;
import com.javacore.aiix.dbservice.data.TableMetaData;
import com.javacore.aiix.dbservice.misc.DBConstants;
import com.javacore.aiix.dbservice.misc.DataHandler;
import com.javacore.aiix.dbservice.misc.Utils;
import com.javacore.aiix.dbservice.server.DBServer;

public class DBStateInit extends DBState {

    public DBStateInit(String name) {
        super(name);
    }

    @Override
    public void enter() {
        System.out.println("Entering DBInit state");
        initTables();
        try{
            DBServer.INSTANCE.start();
            DBApplication.INSTANCE.changeState(DBApplication.INSTANCE.stateRun);
        } catch (Exception e) {
            e.printStackTrace();
            DBApplication.INSTANCE.changeState(DBApplication.INSTANCE.stateStop);
        }
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
