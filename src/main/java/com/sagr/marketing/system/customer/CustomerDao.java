package com.sagr.marketing.system.customer;

import com.sagr.marketing.system.ACrudDao;
import com.sagr.marketing.system.user.User;

import org.hibernate.SessionFactory;

/**
 * @author AGrintsov
 */
public class CustomerDao extends ACrudDao<Customer> {
    public CustomerDao(SessionFactory sessionFactory) {
        super(sessionFactory, Customer.class);
    }

    protected CustomerDao(SessionFactory sessionFactory, Class<Customer> entityClass) {
        super(sessionFactory, entityClass);
    }
}
