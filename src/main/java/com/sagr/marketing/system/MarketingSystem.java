package com.sagr.marketing.system;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sagr.marketing.system.ui.FxmlMapProvider;
import com.sagr.marketing.system.ui.GuiceControllerFactory;
import com.sagr.marketing.system.ui.ISceneManager;
import javafx.application.Application;
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
        MarketingSystemModule marketingSystemModule = new MarketingSystemModule();
        Injector injector = Guice.createInjector(marketingSystemModule);

        GuiceControllerFactory controllerFactory = new GuiceControllerFactory(injector);
        marketingSystemModule.setControllerFactory(controllerFactory);
        marketingSystemModule.setPrimaryStage(primaryStage);

        ISceneManager sceneManager = injector.getInstance(ISceneManager.class);
        sceneManager.setScene(FxmlMapProvider.LOGIN_SCENE_NAME);

        primaryStage.setTitle("Marketing System");
        primaryStage.show();
    }
}
