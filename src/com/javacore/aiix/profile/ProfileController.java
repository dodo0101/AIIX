package com.javacore.aiix.profile;

import com.javacore.aiix.common.ConsoleCanvas;

public class ProfileController {

    private ProfileModel profileModel;
    private ProfileView view;
    private ProfileStore store;
    private ConsoleCanvas canvas;

    {
        store.INSTANCE.loadData();
        view = new ProfileView();
        canvas = new ConsoleCanvas();

    }


    public void showProfile(int id) {
        ProfileModel model = store.INSTANCE.getProfile(id);
        if (model == null) System.out.println("No record found with id: " + id);
        else {
            view.setModel(model);
            view.draw(canvas);
        }
    }



    public ProfileView getView() {
        return view;
    }

    public void setView(ProfileView view) {
        this.view = view;
    }


    public ProfileModel getProfileModel() {
        return profileModel;
    }

    public void setProfileModel(ProfileModel profileModel) {
        this.profileModel = profileModel;
    }

}
