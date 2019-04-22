package com.javacore.aiix.profile;

import com.javacore.aiix.common.BaseView;
import com.javacore.aiix.common.Canvas;
import com.javacore.aiix.common.ConsoleCanvas;

public class ProfilePhotoView extends BaseView {

    private int x;
    private int y;
    private int size;

    public ProfilePhotoView(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    @Override
    public void draw(Canvas canvas) {
        ((ConsoleCanvas)canvas).drawSquare(x, y, size, 'x');
    }
}
