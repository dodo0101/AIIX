package com.javacore.aiix.appserver.common;
/**
 * ConsoleCanvas - drawing in console
 * */
public class ConsoleCanvas extends Canvas {

    private char[][] pixies; //parameters of the screen
    private int width;
    private int height;

    public ConsoleCanvas(int width, int height) {
        this.width = width;
        this.height = height;
        init();
    }

    public void init() {
        pixies = new char[height][width];
        reset();
    }

    private void reset() {
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixies[i][j] = '.';
            }
        }
    }

    public void draw() {
        for(int i = 0; i < height; i++) {
            System.out.print("\n");
            for (int j = 0; j < width; j++) {
                System.out.print(pixies[i][j]);
            }
        }
    }

    public void drawSquare(int x, int y, int size, char symbol) { //square in screen
        //pixies[x][y] = symbol;
        for (int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++){
                if (i == x || i == (x + size - 1)) {pixies[i][j] = symbol;}
                if (j == y || j == (y + size - 1)) {pixies[i][j] = symbol;}
            }
        }

    }

    public void drawCircle(int x, int y, int r, char symbol) {

    }

    public void drawText(int x, int y, String text) {

    }

    @Override
    public void drawText(String text) {
        System.out.println(text);
    }

    @Override
    public void drawSquare(int size) {
        if (size < 2) {
            System.out.println("No square of such small size allowed");
        }
        System.out.print('\n');
        for(int i = 0; i < size; i++) {
            System.out.print("#");
        }
        for (int i = 1; i < size - 1; i++) {
            System.out.println("\n#");
            for (int j = 1; j < size - 1; j++) {
                System.out.println(" ");
            }
            System.out.println("#");
        }

        for(int i = 0; i < size; i++) {
            System.out.print("#");
        }
    }
}
