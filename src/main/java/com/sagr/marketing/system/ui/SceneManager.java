package com.sagr.marketing.system.ui;

import com.sagr.marketing.system.ui.controller.ISceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Sasha on 28.01.2015.
 */
public class SceneManager implements ISceneManager {
    private Stage primaryStage;
    private Map<String, String> sceneFxml;

    public SceneManager(Stage primaryStage, Map<String, String> sceneFxml) {
        this.primaryStage = primaryStage;
        this.sceneFxml = sceneFxml;
    }

    @Override
    public Scene getScene() {
        return primaryStage.getScene();
    }

    @Override
    public void setScene(String scene) {
        if (!sceneFxml.containsKey(scene)) {
            throw new RuntimeException("Scene not found.");
        }
        Parent parent = loadParent(sceneFxml.get(scene));
        primaryStage.setScene(new Scene(parent, 300, 300));
        primaryStage.show();
    }

    private Parent loadParent(String fxml) {
        FXMLLoader loader = new FXMLLoader();
        Parent parent;
        try {
            parent = loader.load(getClass().getResource(fxml).openStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ISceneController controller = loader.getController();
        controller.setSceneManager(this);
        return parent;
    }
}
