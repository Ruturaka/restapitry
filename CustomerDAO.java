package com.journaldev.spring.dao;

import com.journaldev.model.Customer;

import java.util.List;

public interface CustomerDAO {
    Customer getCustomerById(Integer id);

    List<Customer> getAllCustomers();

    boolean createCustomer(Customer customer);

    boolean deleteCustomer(Customer customer);

    boolean updateCustomer(Customer customer);


}
