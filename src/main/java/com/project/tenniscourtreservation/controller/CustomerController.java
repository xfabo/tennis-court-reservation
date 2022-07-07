package com.project.tenniscourtreservation.controller;


import com.project.tenniscourtreservation.entity.Customer;
import com.project.tenniscourtreservation.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * This is a Spring Controller for Customer.
 *
 * @author Filip Fábry.
 */
@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * This is a PostMapping method to save customer in the database.
     * @param customer - customer object created from API parameters.
     * @return Customer object.
     */
    @PostMapping("/customers")
    public Customer saveCustomer(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    /**
     * This is a GetMapping method to get all customers in the database.
     * @return List of customers.
     */
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

}
