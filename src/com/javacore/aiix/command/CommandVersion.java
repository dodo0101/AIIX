package com.javacore.aiix.command;

import static com.javacore.aiix.Application.VERSION;


public class CommandVersion extends  ACommand {

     CommandVersion(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("My version is : " + VERSION);

    }
}
