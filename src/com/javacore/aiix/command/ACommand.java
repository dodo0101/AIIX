package com.javacore.aiix.command;

public abstract class ACommand {

    private String name;

    public ACommand(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected String description;

    public ACommand(String name) {
        this.name = name;
    }

    public void execute() {
        System.out.println("Command \"" + name + "\" not supported");
    }
}
