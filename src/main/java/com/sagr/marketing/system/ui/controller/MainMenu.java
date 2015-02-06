package com.sagr.marketing.system.ui.controller;

import com.google.inject.Inject;
import com.sagr.marketing.system.ui.FxmlMapProvider;
import com.sagr.marketing.system.ui.ISceneManager;
import javafx.event.ActionEvent;

/**
 * @author Oleksandr Hrintsov.
 */
public class MainMenu implements ISceneController {
    private ISceneManager sceneManager;

    @Inject
    public MainMenu(ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @Override
    public void setSceneManager(ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void editPersonalInformation(ActionEvent actionEvent) {
        sceneManager.setScene(FxmlMapProvider.EDIT_PERSONAL_DATA_SCENE_NAME);
    }

    public void editMarketingInformation(ActionEvent actionEvent) {
        sceneManager.setScene(FxmlMapProvider.LOGIN_SCENE_NAME);
    }

    public void findDependencies(ActionEvent actionEvent) {
        sceneManager.setScene(FxmlMapProvider.LOGIN_SCENE_NAME);
    }

    public void viewPurchaseData(ActionEvent actionEvent) {
        sceneManager.setScene(FxmlMapProvider.LOGIN_SCENE_NAME);
    }
}
