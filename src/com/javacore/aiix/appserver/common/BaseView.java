package com.javacore.aiix.appserver.common;

/**
 * BaseView - class describing view classes behaviour
 * */
public abstract class BaseView {

    /**
     * BaseModel field
     * */
    protected BaseModel model;

    /**
     * Method prints model
     * */
    public void draw() {
        System.out.println("Drawing should be implemented");
    }

    /**
     * Method prints model on canvas
     * @param canvas Place to draw model
     * */
    public void draw(Canvas canvas) {
        System.out.println("Wait to implement");
        //canvas.drawline(0, 0, 100, 100);
        //canvas.drawRect(0, 0, 100,100);
        //canvas.setColor(Color.BLACK);)
    }

    /**
     * Setting model to draw
     * @param model Model to draw
     * */
    public void setModel(BaseModel model) {
        this.model = model;
    }

}
