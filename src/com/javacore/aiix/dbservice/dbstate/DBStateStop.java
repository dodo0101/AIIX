package com.javacore.aiix.dbservice.dbstate;

import com.javacore.aiix.dbservice.misc.DBConstants;
import com.javacore.aiix.dbservice.misc.MainDataEncryptor;
import com.javacore.aiix.dbservice.misc.Utils;

import java.util.ArrayList;
import java.util.List;

public class DBStateStop extends DBState {

    public DBStateStop(String name) {
        super(name);
    }

    @Override
    public void enter() {
        System.out.println("Entering DBStop state");

        List<String> list = new ArrayList<>();
        MainDataEncryptor mde = new MainDataEncryptor();

        list.add(mde.encrypt("test string one"));
        list.add(mde.encrypt("test string two"));

        Utils.writeListToFile(list, DBConstants.DATA_DIR + "/test.dat", mde);
    }

    @Override
    public void onStop() {
        System.out.println("Already trying to stop...");
    }
}

