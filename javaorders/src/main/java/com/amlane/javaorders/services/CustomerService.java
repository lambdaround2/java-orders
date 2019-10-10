package com.amlane.javaorders.services;

import com.amlane.javaorders.models.Customer;

import java.util.List;

public interface CustomerService
{
    List<Customer> findAll();

    Customer findById(long id);

    Customer save(Customer agent);

    Customer update(Customer agent, long id);

    void delete(long id);
}
