package com.javacore.aiix.command;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum CommandRegistry {
    INSTANCE;

    static Map<String, ACommand> commands;

    static  {
        commands = new HashMap<>();

        CommandAuthor commandAuthor = new CommandAuthor("author");
        commands.put("author", commandAuthor);
        commands.put("creator", commandAuthor);
        commands.put("father", commandAuthor);

        commands.put("version", new CommandVersion("version"));

        commands.put("time", new CommandTime("time"));

    }

    public boolean hasCommands(String name) {
        return commands.containsKey(name);
    }

    public ACommand getCommand(String name) {
        return commands.get(name);
    }

    public void listCommands() {
        Iterator it = commands.entrySet().iterator();

        System.out.println("List of commands:");
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println(entry.getKey());
        }
    }
}
