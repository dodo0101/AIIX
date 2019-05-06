package com.javacore.aiix.webservice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class HTMLHandler implements HttpHandler {

    public static final String HTML_FORMAT = "^/pages/(([a-zA-Z]+\\.)(html))$";

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String path =  httpExchange.getRequestURI().getPath();// qustion - response here
        String response;
        if (path.matches(HTML_FORMAT)) {
            response = path;
        }
        else response = "INVALID URL : " + path;

        File file = new File("webclient" + path);
        response += "\n<br> File exists: " + file.exists();

        byte[] fileByte = null;
        if (file.exists()) {
            fileByte = Utils.readBytes("webclient" + path);
        }

        httpExchange.getRequestHeaders().put("Content-Type", Arrays.asList(new String[]{"text/html"}));
        httpExchange.sendResponseHeaders(200, 0); // 200 - ok
        OutputStream ops = httpExchange.getResponseBody();

        if (fileByte != null) {
            ops.write(fileByte);
        }
        //ops.write(("HTML Handler : " + response).getBytes());
        ops.close();

    }
}
