package edu.icet.controller;

import edu.icet.model.dto.Customer;
import edu.icet.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllDetails() {
        return customerService.getAllDetails();
    }

    @PostMapping
    public void add(@RequestBody Customer customer) {
        customerService.add(customer);
    }

    @PutMapping
    public void update(@RequestBody Customer customer) {
        customerService.update(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String customerId) {
        customerService.delete(customerId);
    }
}

