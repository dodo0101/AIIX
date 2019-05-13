package com.javacore.aiix.appserver;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class CriminalsApiHandler implements HttpHandler {

    public static final String LIST_REQUEST = "^/api/criminals$";
    public static final String PERSON_REQUEST = "^/api/criminals/[0-9]+$";


    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String path = httpExchange.getRequestURI().getPath();
        String response = "";
        if (path.matches(LIST_REQUEST)) {
            response = "LIST";
        } else if (path.matches(PERSON_REQUEST)) {
            response = "PERSON";
        } else {
            httpExchange.sendResponseHeaders(404,0);
        }

        httpExchange.getRequestHeaders().put("Content-Type", Arrays.asList(new String[]{"text/plain"}));
        httpExchange.sendResponseHeaders(200, 0); // 200 - ok
        OutputStream ops = httpExchange.getResponseBody();
        ops.write(response.getBytes());
        ops.close();


    }


}
