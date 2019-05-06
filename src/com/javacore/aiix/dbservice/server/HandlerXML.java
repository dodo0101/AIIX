package com.javacore.aiix.dbservice.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class HandlerXML implements HttpHandler {

    public static final String XML = "<table>"+"SDKASKD"+"</table>";


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String file = XML;
        httpExchange.sendResponseHeaders(200, file.length());
        httpExchange.getResponseHeaders().put("Content-Type:", Arrays.asList(new String[]{"application/xml"}));
        OutputStream os = httpExchange.getResponseBody();
        os.write(file.getBytes());
        os.close();
    }

}