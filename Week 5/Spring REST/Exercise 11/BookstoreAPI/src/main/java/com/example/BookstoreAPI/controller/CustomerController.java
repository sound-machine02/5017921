package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.entity.Customer;
import com.example.BookstoreAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/register")
    public Customer register(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @PostMapping("/register/form")
    public Customer registerCustomerWithFormData(@RequestParam("name") String name,
                                                 @RequestParam("email") String email,
                                                 @RequestParam("address") String address) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        return customerRepository.save(customer);
    }
}