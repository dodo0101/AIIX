package com.javacore.aiix.appserver.profile;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for keeping all profiles (singleton pattern implemented)
 * */
public enum ProfileStore {

    /**
     * Only one example of this object will exist
     * */
    INSTANCE;

    /**
     * Map of profiles
     * */
    Map<Integer, ProfileModel> profiles;

    {
        profiles = new HashMap<>();
    }

    /**
     * Loading profiles from dbservice
     * */
    public void loadData() {
        profiles.clear();

    }

    /**
     * Returns profile with current if
     * @param id ID of profile
     * */
    public ProfileModel getProfile(int id) {
        return profiles.get(id);
    }

    /*
       Deprecated methods from practice

    // Loads 50 "random" models
        public void loadData() {
        profiles.clear();

        for (int i = 0; i < 50; i++) {
            ProfileModel model = ProfileModel.randomModel();
            profiles.put(model.getId(), model);
        }
    }


    */
}
