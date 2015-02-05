package com.sagr.marketing.system.ui;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.inject.AbstractModule;
import com.sagr.marketing.system.user.IUserService;
import com.sagr.marketing.system.user.UserDaoImpl;
import com.sagr.marketing.system.user.UserService;

/**
 * @author Oleksandr Hrintsov.
 */
public class MarketingSystemModule  extends AbstractModule {
    @Override
    protected void configure() {
        bind(IUserService.class).to(UserService.class);
        bind(UserDaoImpl.class).to(UserDaoImpl.class);
    }

    UserDaoImpl provideUserDaoImpl() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        UserDaoImpl userDao = new UserDaoImpl(sessionFactory);
        return userDao;
    }
}
