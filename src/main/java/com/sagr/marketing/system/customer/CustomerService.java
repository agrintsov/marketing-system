package com.sagr.marketing.system.customer;

import com.google.inject.Inject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Customer customer = new Customer();
        customer.setFirstName("firstName1");
        customer.setLastName("lastName1");
        customer.setOrganisation("organisation1");
        Calendar cal = Calendar.getInstance();
        customer.setBirthDate(new Date(cal.getTimeInMillis()));
        customer.setPhone("phone1");
        customer.setReceivingCardDate(new Date(cal.getTimeInMillis()));
        customer.setEmail("email");
        customer.setDiscountAmount(5);
        customers.add(customer);
        return customers;
        //return customerDao.getAll();
    }
}
