package com.journaldev.spring.dao;

import com.journaldev.model.Customer;
import com.journaldev.model.CustomerMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class CustomerDAOImpl implements CustomerDAO{

    JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Customer getCustomerById(Integer id) {
        return jdbcTemplate.queryForObject("select * from customers where customer_id = ?", new Object[]{id}, new CustomerMapper());

    }

    @Override
    public List<Customer> getAllCustomers(){
        return jdbcTemplate.query("select * from customers", new CustomerMapper());
    }

    @Override
    public boolean createCustomer(Customer customer) {
        return jdbcTemplate.update("insert into customers(customer_id, name, email, number, orderlist) VALUES(?,?,?,?,?)", customer.getId(), customer.getName(), customer.getEmail(), customer.getNumber(), customer.getOrderlist()) > 0;

    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        return jdbcTemplate.update("delete from customers where customer_id=?", customer.getId())>0;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return jdbcTemplate.update("update customers set name=?, email=?, number=?, orderlist=? where customer_id=?;", customer.getName(), customer.getEmail(), customer.getNumber(), customer.getOrderlist(), customer.getId())>0;
    }
}
