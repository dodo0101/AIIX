package com.javacore.aiix;

import com.javacore.aiix.command.ACommand;
import com.javacore.aiix.command.CommandRegistry;
import com.javacore.aiix.profile.ProfileController;
import com.javacore.aiix.profile.ProfileModel;
import com.javacore.aiix.profile.ProfileView;
import state.ApplicationState;
import state.StateIdle;


/**
 *Main class
 * */
public class Application {

    /**
     * Fields with name, author and version
     * */
    static private final String APP_NAME = "AIIX";
    static public final String AUTHOR = "Fedor Glushchenko";
    static public final String VERSION = "0.0.2";

    static ApplicationState currentState; //currentState

    public static void changeState(ApplicationState newState, String commandName) {
        if (currentState != null) {
            currentState.exit();
        }
        currentState = newState;
        newState.enter(commandName);
    }

    /**
     * Start of the program
     * @param args command line values
     * */
    public static void main(String[] args) {
        //System.out.println("Hello, my name is " + APP_NAME);
        //System.out.println("my author`s name is " + AUTHOR);


        /*
        ACommand acommand = new ACommand("Anonymous") { //inner anonymous class
            @Override
            public void execute() {
                System.out.println("Hello!");
                System.out.println(this.getClass());
            }
        };
        acommand.execute();

         */



        String commandName = "version";

        /*
        if (CommandRegistry.INSTANCE.hasCommands(commandName)) {
            ACommand command = CommandRegistry.INSTANCE.getCommand(commandName);
            command.execute();

            commandName = "creator";
            command = CommandRegistry.INSTANCE.getCommand(commandName);
            command.execute();

            commandName = "time";
            command = CommandRegistry.INSTANCE.getCommand(commandName);
            command.execute();

            commandName = "weather";
            command = CommandRegistry.INSTANCE.getCommand(commandName);
            command.execute();


        }
        System.out.println();
        System.out.println();

         */


        /*
        changeState(new StateIdle(), "Idle");
        //reading input
        commandName = "test command";
        //receiving 10 new commands
        for (int i = 0; i < 10; i++) {
            currentState.onCommand(commandName + i);

        }

         */


        ProfileController controller = new ProfileController();
        controller.showProfile(5);






        //WTF
        /*
        Integer j = 71;
        Integer k = ++j;
        int i = 2;
        k = i + j + k;
        System.out.println(k);
        */
    }

}
