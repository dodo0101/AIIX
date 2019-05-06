package com.javacore.aiix.webservice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class CssHandler  implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String path =  httpExchange.getRequestURI().getPath();// qustion - response here

        File file = new File("webclient" + path);

        byte[] fileByte = null;
        if (file.exists()) {
            fileByte = Utils.readBytes("webclient" + path);
        }

        httpExchange.getRequestHeaders().put("Content-Type", Arrays.asList(new String[]{"text/css"}));
        httpExchange.sendResponseHeaders(200, 0); // 200 - ok
        OutputStream ops = httpExchange.getResponseBody();

        if (fileByte != null) {
            ops.write(fileByte);
        }
        //ops.write(("HTML Handler : " + response).getBytes());
        ops.close();
    }
}
