package com.sagr.marketing.system.ui;

import javafx.application.Application;
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
        Parent loginFxml = FXMLLoader.load(getClass().getClassLoader().getResource("view/login.fxml"));

        primaryStage.setTitle("Marketing System");
        primaryStage.setScene(new Scene(loginFxml, 300, 275));
        primaryStage.show();
    }
}
