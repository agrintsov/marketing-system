package com.sagr.marketing.system.customer;

import com.google.inject.Inject;

import java.util.List;

/**
 * @author AGrintsov
 */
public class CustomerService implements ICustomerService {
    private CustomerDao customerDao;

    @Inject
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void add(Customer customer) {
        customerDao.add(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public Customer getById(Integer id) {
        return customerDao.getById(id);
    }

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }
}
