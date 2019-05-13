package com.javacore.aiix.appserver.command;

import static com.javacore.aiix.MainApplication.VERSION;

/**
 * Version command class
 * */
public class CommandVersion extends  ACommand {

    /**
     * Setting command name
     * @param name Name of the command
     * */
     public CommandVersion(String name) {
         super(name);
    }

    /**
     * Method prints current version
     * */
    @Override
    public void execute() {
        System.out.println("My version is : " + VERSION);
        System.out.println("My class is :" + this.getClass());
    }
}
