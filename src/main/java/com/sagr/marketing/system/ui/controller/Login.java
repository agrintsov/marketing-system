package com.sagr.marketing.system.ui.controller;


import com.sagr.marketing.system.ui.FxmlMapProvider;
import com.sagr.marketing.system.ui.ISceneManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * @author Oleksandr Hrintsov.
 */
public class Login implements ISceneController {

    private ISceneManager sceneManager;
    @FXML
    private Text actionStatus;

    public void login(ActionEvent actionEvent) {
        actionStatus.setFill(Color.FIREBRICK);
        actionStatus.setText("Sign in button pressed");
    }

    public void register(ActionEvent actionEvent) {
        /*actionStatus.setFill(Color.BLACK);
        actionStatus.setText("Registration button pressed");*/
        sceneManager.setScene(FxmlMapProvider.REGISTRATION_SCENE_NAME);
    }

    @Override
    public void setSceneManager(ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }
}
