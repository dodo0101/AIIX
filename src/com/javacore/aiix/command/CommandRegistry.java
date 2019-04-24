package com.javacore.aiix.command;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Enum implementing singleton pattern
 * Creates the only example of interaction between console and programm
 * */
public enum CommandRegistry {

    /**
     * Only one example of this object will exist
     * */
    INSTANCE;

    /**
     * HashMap of commands - created after first reference (in static block), and filled with name - command
     * */
    static Map<String, ACommand> commands;

    static  {
        commands = new HashMap<>();

        CommandAuthor commandAuthor = new CommandAuthor("author");
        commands.put("author", commandAuthor);
        commands.put("creator", commandAuthor);
        commands.put("father", commandAuthor);

        commands.put("version", new CommandVersion("version"));
        commands.put("time", new CommandTime("time"));
        commands.put("weather", new CommandWeather("weather"));

    }

    /**
     * Checking if command exist
     * @param name Name of command
     * @return true - if command exist
     * */
    public boolean hasCommands(String name) {

        return commands.containsKey(name);
    }

    /**
     * Method helps to get command
     * @param name Name of command
     * @return Link to command
     * */
    public ACommand getCommand(String name) {
        return commands.get(name);
    }

    /**
     * Showing list of commands
     * */
    public void listCommands() {
        Iterator it = commands.entrySet().iterator();

        System.out.println("List of commands:");
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println(entry.getKey());
        }
    }
}
