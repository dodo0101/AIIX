package com.javacore.aiix.profile;

import com.javacore.aiix.common.BaseView;
import com.javacore.aiix.common.Canvas;
import com.javacore.aiix.common.ConsoleCanvas;

/**
 * Class for creating photo view
 * */
public class ProfilePhotoView extends BaseView {

    /**
     * Coordinates and size of photo
     * */
    private int x;
    private int y;
    private int size;

    /**
     * Constructor setting coordinates and size of photo
     * @param x X coordinate
     * @param y Y coordinate
     * @param size Size of photo
     * */
    public ProfilePhotoView(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    /**
     * Drawing itself on right canvas
     * @param canvas Place for drawing
     * */
    @Override
    public void draw(Canvas canvas) {
        ((ConsoleCanvas)canvas).drawSquare(x, y, size, 'x');
    }
}
