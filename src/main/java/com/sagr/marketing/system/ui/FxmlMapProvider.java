package com.sagr.marketing.system.ui;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sasha on 28.01.2015.
 */
public class FxmlMapProvider {

    public static final String LOGIN_SCENE_NAME = "login";
    public static final String REGISTRATION_SCENE_NAME = "registration";
    public static final String DATA_EDITING_SCENE_NAME = "dataEditing";
    public static final String EDIT_PERSONAL_DATA_SCENE_NAME = "editPersonalData";

    private static Map<String, String> sceneFxml;


    static {
        sceneFxml = new HashMap<String, String>();
        sceneFxml.put(REGISTRATION_SCENE_NAME, "/view/registration.fxml");
        sceneFxml.put(LOGIN_SCENE_NAME, "/view/login.fxml");
        sceneFxml.put(DATA_EDITING_SCENE_NAME, "/view/dataEditing.fxml");
        sceneFxml.put(EDIT_PERSONAL_DATA_SCENE_NAME, "/view/editPersonalData.fxml");
    }

    public static Map<String, String> getSceneFxmlMap() {
        return sceneFxml;
    }
}
