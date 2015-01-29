package com.sagr.marketing.system.ui.controller;

import com.sagr.marketing.system.ui.ISceneManager;

/**
 * @author Oleksandr Hrintsov.
 */
public class Registration implements ISceneController {
    private ISceneManager sceneManager;

    @Override
    public void setSceneManager(ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }
}
