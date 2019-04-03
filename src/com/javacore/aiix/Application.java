package com.javacore.aiix;

import com.javacore.aiix.command.ACommand;
import com.javacore.aiix.command.CommandRegistry;
import com.javacore.aiix.command.CommandVersion;


public class Application {

    static private final String APP_NAME = "AIIX";
    static public final String AUTHOR = "Fedor Glushchenko";
    static public final String VERSION = "0.0.2";


    public static void main(String[] args) {
        System.out.println("Hello, my name is " + APP_NAME);
        System.out.println("my author`s name is " + AUTHOR);

        ACommand acommand = new ACommand("Anonymous") { //inner anonymous class
            @Override
            public void execute() {
                System.out.println("Hello!");
                System.out.println(this.getClass());
            }
        };
        acommand.execute();

        String commandName = "version";

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
