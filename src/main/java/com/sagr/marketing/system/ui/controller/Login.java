package com.sagr.marketing.system.ui.controller;


import com.google.inject.Inject;
import com.sagr.marketing.system.ui.FxmlMapProvider;
import com.sagr.marketing.system.ui.ISceneManager;
import com.sagr.marketing.system.user.IUserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * @author Oleksandr Hrintsov.
 */
public class Login implements ISceneController {
    private IUserService userService;
    private ISceneManager sceneManager;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Text actionStatus;

    @Inject
    public Login(IUserService userService, ISceneManager sceneManager) {
        this.userService = userService;
        this.sceneManager = sceneManager;
    }

    public void login(ActionEvent actionEvent) {
        String login = loginField.getText();
        String password = passwordField.getText();

        if (login.isEmpty()) {
            actionStatus.setFill(Color.BLUE);
            actionStatus.setText("Введіть логін");
            return;
        }

        if (password.isEmpty()) {
            actionStatus.setFill(Color.BLUE);
            actionStatus.setText("Введіть пароль");
            return;
        }

        if (!userService.signIn(login, password)) {
            actionStatus.setFill(Color.BLUE);
            actionStatus.setText("Ви ввели неправильний логін або пароль");
            return;
        }
        sceneManager.setScene(FxmlMapProvider.MAIN_MENU_SCENE_NAME);
    }

    public void register(ActionEvent actionEvent) {
        sceneManager.setScene(FxmlMapProvider.REGISTRATION_SCENE_NAME);
    }

    @Override
    public void setSceneManager(ISceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }
}
