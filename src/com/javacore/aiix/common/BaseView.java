package com.javacore.aiix.common;

/**
 * BaseView - class describ
 * */
public abstract class BaseView {
    protected BaseModel model;

    public void draw() {
        System.out.println("Drawing should be implemented");
    }

    public void draw(Canvas canvas) {
        System.out.println("Wait to implement");
        //canvas.drawline(0, 0, 100, 100);
        //canvas.drawRect(0, 0, 100,100);
        //canvas.setColor(Color.BLACK);)
    }

    public void setModel(BaseModel model) {
        this.model = model;
    }

}
