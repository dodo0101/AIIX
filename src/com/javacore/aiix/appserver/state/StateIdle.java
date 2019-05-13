package com.javacore.aiix.appserver.state;

import com.javacore.aiix.MainApplication;

/**
 * Class in case state is free
 * */
public  class StateIdle extends  ApplicationState {

    /**
     * Method for entering state
     * @param commandName Name of command
     * */
    @Override
    public void enter(String commandName) {
        System.out.println("Entering idle com.javacore.aiix.appserver.state");
    }

    /**
     * Method starts with new command
     * @param commandName Name of the command
     * */
    @Override
    public void onCommand(String commandName) {
        System.out.println("New command received, starting execution..." + commandName);
        MainApplication.changeState(new StateExecutingCommand(), commandName);
    }

    /**
     * Method describes exiting state
     * */
    @Override
    public void exit() {
        System.out.println("Exiting idle com.javacore.aiix.appserver.state");
    }
}
