package com.sagr.marketing.system.ui;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sagr.marketing.system.ui.controller.ISceneController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Sasha on 28.01.2015.
 */
public class SceneManager implements ISceneManager {
    private Stage primaryStage;
    private Map<String, String> sceneFxml;
    private Callback<Class<?>, Object> controllerFactory;

    @Inject
    public SceneManager(Stage primaryStage, @Named("sceneFxml")Map<String, String> sceneFxml, Callback<Class<?>, Object> controllerFactory) {
        this.primaryStage = primaryStage;
        this.sceneFxml = sceneFxml;
        this.controllerFactory = controllerFactory;
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
        loader.setControllerFactory(controllerFactory);
        Parent parent;
        try {
            parent = loader.load(getClass().getResource(fxml).openStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return parent;
    }
}
