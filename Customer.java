package com.journaldev.model;

import java.sql.Array;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Customer {
    private Integer id;
    private String name;
    private String email;
    private String number;
    private Array orderlist;

    public Customer(){
    }

    public Customer(Integer id, String name, String email, String number, String orderlisttt)
    {
        this.id=id;
        this.name=name;
        this.email=email;
        this.number=number;
        String[] orderlist=orderlisttt.split(" ");
        Pattern pattern=Pattern.compile(" ");
        orderlist=pattern.split(orderlisttt);
        //this.orderlist=Arrays.toString(orderlist);

    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public Array getOrderlist() {return orderlist;}

    public void setOrderlist(Array orderlist) {
        this.orderlist =orderlist;
    }
/*
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", orderlist=" + Arrays.toString(orderlist) +
                '}';
    }*/

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", orderlist=" + orderlist +
                '}';
    }
    /*
    public void setOrderlist(Array orderlist) {

    }*/
}
