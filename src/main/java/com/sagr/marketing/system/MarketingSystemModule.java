package com.sagr.marketing.system;

import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import com.sagr.marketing.system.ui.FxmlMapProvider;
import com.sagr.marketing.system.ui.ISceneManager;
import com.sagr.marketing.system.ui.SceneManager;
import com.sagr.marketing.system.ui.controller.Login;
import com.sagr.marketing.system.ui.controller.MainMenu;
import com.sagr.marketing.system.user.IUserService;
import com.sagr.marketing.system.user.UserDaoImpl;
import com.sagr.marketing.system.user.UserService;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * @author Oleksandr Hrintsov.
 */
public class MarketingSystemModule extends AbstractModule {
    private Callback<Class<?>, Object> controllerFactory;
    private Stage primaryStage;

    @Override
    protected void configure() {
        bind(IUserService.class).to(UserService.class).in(Singleton.class);
        bind(ISceneManager.class).to(SceneManager.class).in(Singleton.class);
        bind(new TypeLiteral<Map<String, String>>() {
        }).annotatedWith(Names.named("sceneFxml")).toInstance(FxmlMapProvider.getSceneFxmlMap());
    }

    @Provides
    @Singleton
    public UserDaoImpl provideUserDaoImpl() {
        /*SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        UserDaoImpl userDao = new UserDaoImpl(sessionFactory);*/
        return new UserDaoImpl(null);
    }

    @Provides
    @Singleton
    public Stage providePrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Provides
    @Singleton
    public Callback<Class<?>, Object> provideControllerFactory() {
        return controllerFactory;
    }

    public void setControllerFactory(Callback<Class<?>, Object> controllerFactory) {
        this.controllerFactory = controllerFactory;
    }
}
