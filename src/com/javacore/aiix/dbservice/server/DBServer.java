package com.javacore.aiix.dbservice.server;

import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public enum DBServer {
    INSTANCE;
    public static final int PORT = 6701;
    public static final String SERVER_NAME = "Steve DB Server";
    public void start() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 10 );
        server.createContext("/api/query", new QueryHandler());
        server.start();
        String message = String.format("%s is running on port: %d", SERVER_NAME, server.getAddress().getPort());
        System.out.println(message);
    }



}