package com.sagr.marketing.system.customer;

import com.sagr.marketing.system.ACrudDao;
import org.hibernate.SessionFactory;

/**
 * @author AGrintsov
 */
public class CustomerDao extends ACrudDao<Customer> {
    protected CustomerDao(SessionFactory sessionFactory, Class<Customer> entityClass) {
        super(sessionFactory, entityClass);
    }
}
