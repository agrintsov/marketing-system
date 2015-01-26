package com.sagr.marketing.system.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author AGrintsov
 */
public class MarketingSystem extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Marketing System");
        LoginSceneCreator loginSceneCreator = new LoginSceneCreator();
        Scene loginScene = loginSceneCreator.create();

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }
}
