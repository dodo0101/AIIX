package com.javacore.aiix.profile;

import com.javacore.aiix.common.BaseView;
import com.javacore.aiix.common.Canvas;
import com.javacore.aiix.common.CompositeView;

public class ProfileView extends CompositeView {

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

    public void init() {
        ProfilePhotoView photoView = new ProfilePhotoView(30, 2, 10); //place for photo
        children.add(photoView);
    }

}
