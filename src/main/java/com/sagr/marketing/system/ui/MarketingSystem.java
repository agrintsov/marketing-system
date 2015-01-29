package com.sagr.marketing.system.ui;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    public void start(Stage primaryStage) throws Exception {
        SceneManagerFactory sceneManagerFactory = new SceneManagerFactory();
        ISceneManager sceneManager = sceneManagerFactory.createSceneManager(primaryStage);
        sceneManager.setScene(FxmlMapProvider.LOGIN_SCENE_NAME);

        primaryStage.setTitle("Marketing System");
        primaryStage.show();
    }
}
