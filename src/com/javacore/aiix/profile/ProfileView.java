package com.javacore.aiix.profile;

import com.javacore.aiix.common.BaseView;
import com.javacore.aiix.common.Canvas;
import com.javacore.aiix.common.CompositeView;

/**
 * Class to draw profile
 * */
public class ProfileView extends CompositeView {

    /**
     * Method firstly asks compositeview children to draw them self and after to draw text about criminal
     * @param canvas Place to draw
     * */
    @Override
    public void draw(Canvas canvas) {
        for (BaseView view : children) {
            view.draw();
        }

        canvas.drawSquare(10);
        canvas.drawText("Criminal profile view");
        canvas.drawText("ID: " + ((ProfileModel)model).getId());
        canvas.drawText("Name: " + ((ProfileModel)model).getName());
        canvas.drawText("Active: " + ((ProfileModel)model).isActive());
    }

    /**
     * Initial to add photoview to compositeview
     * */
    public void init() {
        ProfilePhotoView photoView = new ProfilePhotoView(30, 2, 10); //place for photo
        children.add(photoView);
    }

}
