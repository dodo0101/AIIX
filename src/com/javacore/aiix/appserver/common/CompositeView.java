package com.javacore.aiix.appserver.common;

import java.util.ArrayList;
import java.util.List;

/**
 * CompositeView implements composite pattern
 * */
public class CompositeView extends BaseView{

    /**
     * list of children objects of view
     * */
    protected List<BaseView> children = new ArrayList<>();

    /**
     * Method iterates through child object and making them to draw their self
     * */
    @Override
    public void draw(){
        for (BaseView view : children) {
            view.draw();
        }
        //drawing commands;
    }

    /**
     * Method adding child into view
     * @param view View to add as child into list
     * */
    public void addChildView(BaseView view) {
        children.add(view);
    }
}
