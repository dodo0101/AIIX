package com.javacore.aiix.dbservice.data.query;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WHEREParser {

    private static final String WHERE_STRING = "^(WHERE)([\\s]*[a-zA-Z0-9><= ]+)$";

    public boolean validate(String  where) {
        return where.matches(WHERE_STRING);
    }

    public String beautify(String where) {
        return where.trim().replaceAll("[\\s]+", "\\s");
    }

    public String extractClause(String where) {
        Pattern p = Pattern.compile(WHERE_STRING);
        Matcher m = p.matcher(where);
        if (m.find()) {
            return m.group(2);
        }
        return null;
    }

}
