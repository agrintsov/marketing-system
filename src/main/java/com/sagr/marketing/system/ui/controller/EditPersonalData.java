package com.sagr.marketing.system.ui.controller;

import com.google.inject.Inject;
import com.sagr.marketing.system.ui.FxmlMapProvider;
import com.sagr.marketing.system.ui.ISceneManager;
import com.sagr.marketing.system.user.IUserService;
import com.sagr.marketing.system.user.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Sasha on 05.02.2015.
 */
public class EditPersonalData implements ISceneController, Initializable {
    private ISceneManager sceneManager;
    private IUserService userService;

    @FXML
    private TextField nameField;
    @FXML
    private TextField secondNameField;
    @FXML
    private TextField organizationField;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField repeatedPasswordField;

    @Inject
    public EditPersonalData(ISceneManager sceneManager, IUserService userService) {
        this.sceneManager = sceneManager;
        this.userService = userService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        User currentUser = userService.getCurrentUser();
        nameField.setText(currentUser.getFirstName());
        secondNameField.setText(currentUser.getLastName());
        organizationField.setText(currentUser.getOrganisation());
        loginField.setText(currentUser.getLogin());
    }

    @Override
    public void setSceneManager(ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    public void back(ActionEvent actionEvent) {
        sceneManager.setScene(FxmlMapProvider.MAIN_MENU_SCENE_NAME);
    }

    public void savePersonalData(ActionEvent actionEvent) {
        User currentUser = userService.getCurrentUser();
        currentUser.setFirstName(nameField.getText());
        currentUser.setLastName(secondNameField.getText());
        currentUser.setOrganisation(organizationField.getText());
        userService.update(currentUser);
    }

    public void saveAuthorizationData(ActionEvent actionEvent) {

    }
}