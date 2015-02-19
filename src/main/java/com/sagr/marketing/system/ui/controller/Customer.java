package com.sagr.marketing.system.ui.controller;

import com.google.inject.Inject;
import com.sagr.marketing.system.ui.ISceneManager;

/**
 * @author AGrintsov
 */
public class Customer implements ISceneController {
    private ISceneManager sceneManager;

    @Inject
    public Customer(ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @Override
    public void setSceneManager(ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }
}
