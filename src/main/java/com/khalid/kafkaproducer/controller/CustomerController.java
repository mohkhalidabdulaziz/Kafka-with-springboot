package com.khalid.kafkaproducer.controller;

import com.khalid.kafkaproducer.model.Customer;
import com.khalid.kafkaproducer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/pubCustomer")
    public String addCustomer(@RequestBody List<Customer> customerList) {
           return customerService.add(customerList);
    }

}
