package com.journaldev;


import com.journaldev.model.Customer;
import com.journaldev.model.Menu;
import com.journaldev.spring.config.AppConfig;

import com.journaldev.spring.dao.CustomerDAO;
import com.journaldev.spring.dao.MenuDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerDAO customerDAO = context.getBean(CustomerDAO.class);

        System.out.println("List of customers is:");

        for(Customer p: customerDAO.getAllCustomers()){
            System.out.println(p);
        }

        System.out.println("\nGet customer with ID 2");

        Customer customerById = customerDAO.getCustomerById(2);
        System.out.println(customerById);

        System.out.println("\nCreating customer: ");
        Customer customer = new Customer(6, "anud singh dhaka", "anud@gmail.com", "9822422023",
                "ARRAY[ (1, ‘lasagana’, 1)::orders, (2, ‘cold coffee’, 1)::orders]");
        System.out.println(customer);
        customerDAO.createCustomer(customer);
        System.out.println("\nList of customer is:");

        for (Customer p : customerDAO.getAllCustomers()) {
            System.out.println(p);
        }
/*
        System.out.println("Deleting customer with id 6");
        Customer customerById6 = customerDAO.getCustomerById(6);

        customerDAO.deleteCustomer(customerById6);

        System.out.println("\nList of customer is:");

        for (Customer p : customerDAO.getAllCustomers()) {
            System.out.println(p);
        }

        System.out.println("Our whole menu: ");

        MenuDAO menuDAO = context.getBean(MenuDAO.class);

        for (Menu m: menuDAO.getWholeMenu()){
            System.out.println(m);
        }

        System.out.println("Get dish with ID 2");

        Menu menuById = menuDAO.getDishById(2);
        System.out.println(menuById);


        System.out.println("Adding new dish to the menu: ");
        Menu menu = new Menu(12,"bornvita",200);
        System.out.println(menu);
        menuDAO.createDish(menu);

        System.out.println("Our whole menu:");

        for (Menu m : menuDAO.getWholeMenu()) {
            System.out.println(m);
        }
        System.out.println("Deleting dish with id 12");
        Menu dishById6 = menuDAO.getDishById(12);

        menuDAO.deleteDish(dishById6);

        System.out.println("Our whole menu:");

        for (Menu m : menuDAO.getWholeMenu()) {
            System.out.println(m);
        }*/

        System.out.println("done");
    }
}
