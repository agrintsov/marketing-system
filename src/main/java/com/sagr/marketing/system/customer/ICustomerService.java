package com.sagr.marketing.system.customer;

import java.util.List;

/**
 * @author AGrintsov
 */
public interface ICustomerService {
    void add(Customer customer);
    void update(Customer customer);
    Customer getById(Integer id);
    List<Customer> getAll();
}
