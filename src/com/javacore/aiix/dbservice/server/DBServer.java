package com.javacore.aiix.dbservice.server;

import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public enum DBServer {
    INSTANCE;
    public static final int PORT = 6701;

    public void start() throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 10 );
        //server.createContext("/", new BaseHandler());
        //server.createContext("/dbservice/editQuery", new QueryEditorHandler());
        //server.createContext("/dbservice/state", new StateHandler());
        //server.createContext("/dbservice/query", new QueryHandler());
        DBServer dbServer = this;
        server.start();
        String message = String.format("Server is running on port: %d", server.getAddress().getPort());
        System.out.println(message);
    }



}