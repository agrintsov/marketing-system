package com.sagr.marketing.system.ui.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * @author Oleksandr Hrintsov.
 */
public class Login{

    @FXML
    private Text actionStatus;

    public void login(ActionEvent actionEvent) {
        actionStatus.setFill(Color.FIREBRICK);
        actionStatus.setText("Sign in button pressed");
    }

    public void register(ActionEvent actionEvent) {
        actionStatus.setFill(Color.BLACK);
        actionStatus.setText("Registration button pressed");
    }
}
