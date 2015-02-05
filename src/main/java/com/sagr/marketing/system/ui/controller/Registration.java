package com.sagr.marketing.system.ui.controller;

import com.google.inject.Inject;
import com.sagr.marketing.system.ui.FxmlMapProvider;
import com.sagr.marketing.system.ui.ISceneManager;
import com.sagr.marketing.system.user.IUserService;
import javafx.event.ActionEvent;

/**
 * @author Oleksandr Hrintsov.
 */
public class Registration implements ISceneController {
    private ISceneManager sceneManager;
    private IUserService userService;

    @Inject
    public Registration(ISceneManager sceneManager, IUserService userService) {
        this.sceneManager = sceneManager;
        this.userService = userService;
    }

    @Override
    public void setSceneManager(ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void back(ActionEvent actionEvent) {
        sceneManager.setScene(FxmlMapProvider.LOGIN_SCENE_NAME);
    }

    public void register(ActionEvent actionEvent) {

    }
}
