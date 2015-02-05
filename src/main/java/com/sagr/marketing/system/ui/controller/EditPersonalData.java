package com.sagr.marketing.system.ui.controller;

import com.sagr.marketing.system.ui.FxmlMapProvider;
import com.sagr.marketing.system.ui.ISceneManager;
import javafx.event.ActionEvent;

/**
 * Created by Sasha on 05.02.2015.
 */
public class EditPersonalData implements ISceneController {
    private ISceneManager sceneManager;

    @Override
    public void setSceneManager(ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void back(ActionEvent actionEvent) {
        sceneManager.setScene(FxmlMapProvider.MAIN_MENU_SCENE_NAME);
    }

    public void savePersonalData(ActionEvent actionEvent) {

    }

    public void saveAuthorizationData(ActionEvent actionEvent) {

    }
}