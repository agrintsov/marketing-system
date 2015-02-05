package com.sagr.marketing.system.ui.controller;

import com.sagr.marketing.system.ui.ISceneManager;

/**
 * Created by Sasha on 05.02.2015.
 */
public class DataEditing implements ISceneController {
    private ISceneManager sceneManager;

    @Override
    public void setSceneManager(ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }
}
