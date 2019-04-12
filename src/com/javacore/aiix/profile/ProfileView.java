package com.javacore.aiix.profile;

import com.javacore.aiix.common.BaseView;
import com.javacore.aiix.common.Canvas;

public class ProfileView extends BaseView {

    @Override
    public void draw(Canvas canvas) {
        canvas.drawSquare(10);
        canvas.drawText("Criminal profile view");
        canvas.drawText("ID: " + ((ProfileModel)model).getId());
        canvas.drawText("Name: " + ((ProfileModel)model).getName());
        canvas.drawText("Active: " + ((ProfileModel)model).isActive());
    }

}
