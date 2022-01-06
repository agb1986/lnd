package com.abg1986.lnd.accessingdatamongodb.controllers;

import com.abg1986.lnd.accessingdatamongodb.models.Customer;
import com.abg1986.lnd.accessingdatamongodb.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(path = "/customer")
    public ResponseEntity<Object> createCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/customer")
    public ResponseEntity<Object> getCustomersResponseEntity() {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
