package com.amlane.javaorders.services;

import com.amlane.javaorders.models.Agent;
import com.amlane.javaorders.models.Customer;
import com.amlane.javaorders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService
{

    @Autowired
    private CustomerRepository custrepos;

    @Override
    public List<Customer> findAll()
    {
        List<Customer> list = new ArrayList<>();
        custrepos.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer findById(long id)
    {
        return null;
    }

    @Transactional
    @Override
    public Customer save(Customer customer)
    {
        return null;
    }

    @Override
    public Customer update(Customer customer, long id)
    {
        return null;
    }

    @Override
    public void delete(long id)
    {

    }
}
