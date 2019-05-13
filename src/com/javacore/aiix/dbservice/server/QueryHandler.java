package com.javacore.aiix.dbservice.server;

import com.javacore.aiix.dbservice.misc.DataHandler;
import com.javacore.aiix.dbservice.misc.Utils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class QueryHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange request) throws IOException {

        String response = "\nNEW REQUEST RECEIVED!";
        response += String.format("METHOD: %s", request.getRequestMethod());
        for (Map.Entry<String, List<String>> header : request.getRequestHeaders().entrySet()) {
            response += String.format("\n %s %s", header.getKey(), header.getValue());
        }
        InputStream is = request.getRequestBody();
        Utils.readStream(is, new DataHandler() {
            @Override
            public void handleString(String line) {
                String query = String.format("REQUEST BODY: %s", line);
                System.out.println(query);
            }
        });
        response += response + "\nI will be able to execute any query soon";
        request.sendResponseHeaders(200, response.length());
        OutputStream os = request.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
