package com.javacore.aiix;

public class Application {
    static final String APP_NAME = "AIIX";
    static String author = "Fedor Glushchenko";
    static String version = "0.0.0";


    public static void main(String[] args) {
        System.out.println("Hello, my name is " + APP_NAME);
        System.out.println("my author`s name is " + author);
        System.out.println("my version is " + Application.version);

        Integer j = 71;
        Integer k = ++j;
        int i = 2;
        k = i + j + k;
        System.out.println(k);
    }
}
