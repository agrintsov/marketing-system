package com.sagr.marketing.system.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static javafx.geometry.HPos.RIGHT;


/**
 * @author AGrintsov
 */
public class LoginSceneCreator {

    public Scene create() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Система підтримки прийняття рішень в маркетинговій діяльності");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        sceneTitle.setWrappingWidth(350);
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label login = new Label("Логін:");
        grid.add(login, 0, 1);

        TextField loginTextField = new TextField();
        grid.add(loginTextField, 1, 1);

        Label pw = new Label("Пароль:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Ввійти");
        grid.add(btn, 0, 4);

        final Text actionTarget = new Text();
        grid.add(actionTarget, 0, 6);
        grid.setColumnSpan(actionTarget, 2);
        grid.setHalignment(actionTarget, RIGHT);
        actionTarget.setId("actiontarget");

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Sign in button pressed");
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        return scene;

    }
}
