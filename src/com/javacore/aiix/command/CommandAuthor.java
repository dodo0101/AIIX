package com.javacore.aiix.command;


import static com.javacore.aiix.Application.AUTHOR;

/**
 * Author command class
 * */
public class CommandAuthor extends ACommand {

    /**
     *Setting command name
     * @param name Name of the command
     * */
     CommandAuthor(String name) {
        super(name);
    }

    /**
     * Method prints author name
     * */
    @Override
    public void execute() {
        System.out.println("My author is : " + AUTHOR);

    }
}
