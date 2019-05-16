package com.javacore.aiix.webservice;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class ApiCriminalsHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        //check path
        //

        URL url = new URL("http://localhost:6702/api/criminals");           //обращаемся к api для получения
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        InputStream is = connection.getInputStream(); //взяли поток ввода
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        is.close();

        //Read template file
        File file = new File("webclient/snippets/criminalTablebelow.html"); //новый маленький шаблон для html
        byte[] fileBytes = null; //
        if (file.exists()) {
            fileBytes = Utils.readBytes("webclient/snippets/criminalTablebelow.html"); //перевели в байты
        }

        String result = "";
        String raw = new String(bytes);
        String template = new String(fileBytes);


        String[] records = raw.split(";");
        for (String rec : records) {
            String html = new String(template);
            String[] values = rec.split(",");
            for (int i = 0, len = values.length; i < len; i++) {
                html = html.replace("{{" + i + "}}", values[i]); //заменяем в шаблоне по индексу значения
            }
            result += template;
        }


        httpExchange.getRequestHeaders().set("Content-Type", "text/plain");
        httpExchange.sendResponseHeaders(200, 0);

        OutputStream os = httpExchange.getResponseBody(); //взяли поток вывода
        os.write(result.getBytes());
        os.close();


            //SOMETHING ELSE
    }
}
