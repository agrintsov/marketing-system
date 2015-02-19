package com.sagr.marketing.system.ui;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sasha on 28.01.2015.
 */
public class FxmlMapProvider {

    public static final String LOGIN_SCENE_NAME = "login";
    public static final String REGISTRATION_SCENE_NAME = "registration";
    public static final String MAIN_MENU_SCENE_NAME = "mainMenu";
    public static final String EDITING_DATA_MENU_SCENE_NAME = "editingDataMenu";
    public static final String EDIT_PERSONAL_DATA_SCENE_NAME = "editPersonalData";
    public static final String CUSTOMERS_SCENE_NAME = "customers";
    public static final String EDIT_CUSTOMER_DATA_SCENE_NAME = "editCustomerData";

    private static Map<String, String> sceneFxml;

    static {
        sceneFxml = new HashMap<String, String>();
        sceneFxml.put(REGISTRATION_SCENE_NAME, "/view/registration.fxml");
        sceneFxml.put(LOGIN_SCENE_NAME, "/view/login.fxml");
        sceneFxml.put(MAIN_MENU_SCENE_NAME, "/view/mainMenu.fxml");
        sceneFxml.put(EDITING_DATA_MENU_SCENE_NAME, "/view/editingDataMenu.fxml");
        sceneFxml.put(EDIT_PERSONAL_DATA_SCENE_NAME, "/view/editPersonalData.fxml");
        sceneFxml.put(CUSTOMERS_SCENE_NAME, "/view/customers.fxml");
        sceneFxml.put(EDIT_CUSTOMER_DATA_SCENE_NAME, "/view/editCustomerData.fxml");
    }

    public static Map<String, String> getSceneFxmlMap() {
        return sceneFxml;
    }
}
