package com.sagr.marketing.system.ui.controller;

import com.google.inject.Inject;
import com.sagr.marketing.system.ui.FxmlMapProvider;
import com.sagr.marketing.system.ui.ISceneManager;
import com.sagr.marketing.system.user.IUserService;
import com.sagr.marketing.system.user.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * @author Oleksandr Hrintsov.
 */
public class Registration implements ISceneController {
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
        String name = nameField.getText();
        String secondName = secondNameField.getText();
        String organization = organizationField.getText();
        String login = loginField.getText();
        String password = passwordField.getText();
        User newUser = new User(name, secondName, organization, login, null);
        if (userService.registerNewUser(newUser, password)) {
            sceneManager.setScene(FxmlMapProvider.LOGIN_SCENE_NAME);
        }
    }
}
