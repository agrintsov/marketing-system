package com.sagr.marketing.system.ui.controller;

import com.google.inject.Inject;
import com.sagr.marketing.system.ui.ISceneManager;

/**
 * @author AGrintsov
 */
public class EditCustomerData implements ISceneController {
    private ISceneManager sceneManager;

    @Inject
    public EditCustomerData(ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @Override
    public void setSceneManager(ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }
}
