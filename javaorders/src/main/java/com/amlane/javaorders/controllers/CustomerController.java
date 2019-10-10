package com.amlane.javaorders.controllers;

import com.amlane.javaorders.models.Customer;
import com.amlane.javaorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    // GET localhost:2019/customer/orders
    @GetMapping(value = "/order",
                produces = {"application/json"})
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customer> custList = customerService.findAll();
        return new ResponseEntity<>(custList, HttpStatus.OK);
    }
}
