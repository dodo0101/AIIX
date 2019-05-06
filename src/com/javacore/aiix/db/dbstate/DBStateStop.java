package com.javacore.aiix.db.dbstate;

import com.javacore.aiix.db.misc.DBConstants;
import com.javacore.aiix.db.misc.MainDataEncryptor;
import com.javacore.aiix.db.misc.Utils;

import java.util.ArrayList;
import java.util.List;

public class DBStateStop extends DBState {

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

