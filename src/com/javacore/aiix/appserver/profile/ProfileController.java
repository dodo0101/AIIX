package com.javacore.aiix.appserver.profile;

import com.javacore.aiix.appserver.common.ConsoleCanvas;

/**
 * Class for showing profile
 * */
public class ProfileController {

    /**
     * Fields helping to draw profile
     * */
    private ProfileModel profileModel;
    private ProfileView view;
    private ProfileStore store;
    private ConsoleCanvas canvas;

    {
        store.INSTANCE.loadData();
        view = new ProfileView();
        canvas = new ConsoleCanvas(80,80);

    }

    /**
     * Showing profile
     * @param id ID of criminal
     * */
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
