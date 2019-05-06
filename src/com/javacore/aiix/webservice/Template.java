package com.javacore.aiix.webservice;

import java.util.Map;

public class Template {

    public String templateFileName; //html page criminalProfile.html
    public Map<String, String> values;
    public Template(String fileName, Map<String, String> values) {
        this.values = values;
        this.templateFileName = fileName;
    }


    public String comile() {
        String templateText = Utils.readFile(templateFileName); //TODO
        for (String key : values.keySet()) {
            templateText = templateText.replace("{{" + key + "}}", values.get(key));
        }
        return templateText;
    }

    //map.put("firstName", "Vasia");
    //map.put("lastName", "Petrov");

}
