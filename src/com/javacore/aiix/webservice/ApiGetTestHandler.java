package com.javacore.aiix.webservice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class ApiGetTestHandler  implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        httpExchange.getRequestHeaders().put("Content-Type", Arrays.asList(new String[]{"text/plain"}));
        httpExchange.sendResponseHeaders(200, 0); // 200 - ok
        OutputStream ops = httpExchange.getResponseBody();

        ops.write(WebClientApplication.APP_NAME.getBytes());
        ops.close();

    }
}
