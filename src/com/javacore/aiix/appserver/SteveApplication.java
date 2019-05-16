package com.javacore.aiix.appserver;


import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public enum SteveApplication {
    INSTANCE;

    public static final int PORT = 6702;
    public static final String APP_NAME = "MainApplication Service";

    public void start() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT),10);

        server.createContext("/api/criminals", new CriminalsApiHandler());


        server.start();
        String message = String.format("%s is running on port: %s", APP_NAME, server.getAddress().getPort());
        System.out.println(message);
    }
}