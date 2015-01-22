package com.sagr.marketing.system.user;

import com.sagr.marketing.system.ACrudDao;
import org.hibernate.SessionFactory;

/**
 * @author AGrintsov
 */
public class UserDaoImpl extends ACrudDao<User> {
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    protected UserDaoImpl(SessionFactory sessionFactory, Class entityClass) {
        super(sessionFactory, entityClass);
    }
}
