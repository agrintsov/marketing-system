package com.sagr.marketing.system.ui;

import javafx.stage.Stage;

import java.util.Map;

/**
 * Created by Sasha on 28.01.2015.
 */
public class SceneManagerFactory {
    public ISceneManager createSceneManager(Stage primaryStage) {
        Map<String, String> sceneFxmlMap = FxmlMapProvider.getSceneFxmlMap();
        return new SceneManager(primaryStage, sceneFxmlMap);
    }
}
