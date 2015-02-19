package com.sagr.marketing.system.ui.controller;

import com.google.inject.Inject;
import com.sagr.marketing.system.ui.FxmlMapProvider;
import com.sagr.marketing.system.ui.ISceneManager;
import javafx.event.ActionEvent;

/**
 * Created by Sasha on 05.02.2015.
 */
public class DataEditing implements ISceneController {
    private ISceneManager sceneManager;

    @Inject
    public DataEditing(ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @Override
    public void setSceneManager(ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void editCustomersInformation(ActionEvent actionEvent) {
        sceneManager.setScene(FxmlMapProvider.CUSTOMERS_SCENE_NAME);
    }

    public void editBrandInformation(ActionEvent actionEvent) {

    }

    public void editGoodsInformation(ActionEvent actionEvent) {

    }

    public void editLimitationInformation(ActionEvent actionEvent) {

    }
}
