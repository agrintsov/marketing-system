package com.sagr.marketing.system.ui;

import com.google.inject.Injector;
import javafx.util.Callback;

/**
 * @author Oleksandr Hrintsov.
 */
public class GuiceControllerFactory implements Callback<Class<?>, Object> {

    private final Injector injector;

    public GuiceControllerFactory(Injector anInjector) {
        injector = anInjector;
    }

    public Object call(Class<?> param) {
        return injector.getInstance(param);
    }
}
