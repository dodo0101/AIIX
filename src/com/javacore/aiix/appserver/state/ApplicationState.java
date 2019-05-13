package com.javacore.aiix.appserver.state;

/**
 * Class for keeping methods of state machine, have states busy/free
 * */
public abstract class ApplicationState {

    /**
     * Method for entering state
     * @param commandName Name of command
     * */
    public abstract void enter(String commandName);

    /**
     * Method starts with new command
     * @param commandName Name of the command
     * */
    public abstract void onCommand(String commandName);

    /**
     * Method describes exiting state
     * */
    public abstract void exit();

}
