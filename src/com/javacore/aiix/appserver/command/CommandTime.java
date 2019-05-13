package com.javacore.aiix.appserver.command;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Time command class
 * */
public class CommandTime extends ACommand{

    /**
     * Setting command name
     * @param name Name of the command
     * */
    CommandTime(String name) {
        super(name);
    }

    /**
     * Method prints current time in two formats
     * */
    @Override
    public void execute() {

        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();

        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormatAP = new SimpleDateFormat("hh:mm:ss a");
        String formattedDate = dateFormat.format(date);
        String formattedDateAP = dateFormatAP.format(date);

        System.out.println("Current time is : " + formattedDate);
        System.out.println("Current time is : " + formattedDateAP);

    }



}
