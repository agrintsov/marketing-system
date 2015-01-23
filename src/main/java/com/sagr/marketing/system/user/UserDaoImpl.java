package com.sagr.marketing.system.user;

import java.util.List;

import com.sagr.marketing.system.ACrudDao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;

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

    public User getUserByLogin(final String login) {
        List<User> users = find(new CriteriaMaker() {
            @Override
            public Criteria make(Session session) {
                Criteria criteria = session.createCriteria(entityClass);
                criteria.add(Expression.eq("login", login));
                return criteria;
            }
        });
        return users.isEmpty() ? null : users.get(0);
    }
}
