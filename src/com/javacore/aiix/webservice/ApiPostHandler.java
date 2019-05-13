package com.javacore.aiix.webservice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class ApiPostHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        //мы хотим обратно выслать то, что получили
        //recieve from client-browser

        InputStream is = httpExchange.getRequestBody(); //забрали поток ввода из запроса
        byte[] requestByte = new byte[is.available()];  //положили
        is.read(requestByte);
        //С клиента приходит JSON - надо из него сделать web


        //sending result
        httpExchange.getRequestHeaders().put("Content-Type", Arrays.asList(new String[]{"text/plain"}));
        httpExchange.sendResponseHeaders(200, 0); // 200 - ok
        OutputStream ops = httpExchange.getResponseBody();
        ops.write(requestByte);
        ops.close();

    }
}
