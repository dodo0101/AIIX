package com.javacore.aiix.command;


import static com.javacore.aiix.Application.AUTHOR;

public class CommandAuthor extends ACommand {

     CommandAuthor(String name) {
        super(name);
    }

    @Override
    public void execute() {
        System.out.println("My author is : " + AUTHOR);

    }
}
