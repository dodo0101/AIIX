package com.javacore.aiix.command;

/**
 * Abstract class describes commands methods and fields
 * */
public abstract class ACommand {
    /**
     * Name and description of method
     * */
    private String name;
    protected String description;

    /**
     *Command constructor
     * @param name Command name
     * @param description Command description
     * */
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

    /**
     * Command constructor
     * @param name Command name
     * */
    public ACommand(String name) {
        this.name = name;
    }

    /**
     * Default execution method
     * */
    public void execute() {

        System.out.println("Command \"" + name + "\" not supported");
    }
}
