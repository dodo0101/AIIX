package com.javacore.aiix.appserver.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.reflect.*;

/**
 * Weather command class
 * */
public class CommandWeather extends ACommand {

    /**
     * Fields with params for weather api
     * */
    private final static String API_KEY = "7acb3d1416e02469ab956e28188ae136";
    private final static String LOCATION = "Saint Petersburg,ru";
    private final static String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY +
            "&units=metric";

    /**
     *Setting command name
     * @param name Name of the command
     * */
    CommandWeather(String name) {
        super(name);
    }

    /**
     * Method creates new anonymous inner class and his instance - for defining of returned collection type
     * @param str Combined url
     * @return Map of objects with weather info
     * */
    private static Map<String, Object> jsonToMap (String str) {
        Type type = new TypeToken<HashMap<String, Object>>() {}.getType(); //
        Map<String, Object> map = new Gson().fromJson (str, type);
        return map;
    }

    /**
     * Method prints current temp
     * */
    @Override
    public void execute() {
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            BufferedReader breader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = breader.readLine()) != null) {
                result.append(line);
            }
            breader.close();
            //System.out.println(result);

            Map<String, Object> respMap = jsonToMap(result.toString());
            Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());

            //System.out.println(mainMap);
            System.out.println("Current temp is : " + mainMap.get("temp"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



}
