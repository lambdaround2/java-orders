package com.amlane.javaorders.controllers;

import com.amlane.javaorders.models.Customer;
import com.amlane.javaorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping(value = "/new",
                 consumes = {"application/json"},
                 produces = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid
                                            @RequestBody Customer newCustomer) throws URISyntaxException
    {
        newCustomer = customerService.save(newCustomer);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{custcode}")
                .buildAndExpand(newCustomer.getCustcode())
                .toUri();
        responseHeaders.setLocation(newCustomerURI);

        return new ResponseEntity<>(null,
                responseHeaders, HttpStatus.CREATED);

    }

    @PutMapping(value = "/update/{custcode}",
                consumes = {"application/json"},
                produces = {"application/json"})
    public ResponseEntity<?> updateCustomer(@RequestBody Customer updateCustomer,
                                            @PathVariable long custcode)
    {
        customerService.update(updateCustomer, custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
