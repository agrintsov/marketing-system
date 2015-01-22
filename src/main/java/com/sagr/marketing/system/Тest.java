package com.sagr.marketing.system;

import com.sagr.marketing.system.user.User;
import com.sagr.marketing.system.user.UserDaoImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author AGrintsov
 */
public class Тest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        UserDaoImpl userDao = new UserDaoImpl(sessionFactory);
        List<User> all = userDao.getAll();
        System.out.println(all);
    }
}
