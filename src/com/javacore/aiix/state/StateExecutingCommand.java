package com.javacore.aiix.state;

import com.javacore.aiix.Application;

/**
 * Class using if state is busy
 * */
public class StateExecutingCommand extends ApplicationState {

    /**
     * Method for entering state
     * @param commandName Name of command
     * */
    @Override
    public void enter(String commandName) {
        System.out.println("Entering State Executing Command" + commandName);
        //get command by name;
        //command execute
        executeCommand(commandName);
    }

    /**
     * Method starting command execution
     * @param commandName Name of teh command
     * */
    private void executeCommand(String commandName) {
        //code for execution
        Application.changeState(new StateIdle(), "Idle");
    }

    /**
     * Method starts with new command
     * @param commandName Name of the command
     * */
    @Override
    public void onCommand(String commandName) {
        System.out.println("Busy executing command..." + commandName + " has to wait");
    }

    /**
     * Method describes exiting state
     * */
    @Override
    public void exit() {
        System.out.println("Leaving State Executing Command");
    }
}
