package edu.icet.service;

import edu.icet.model.dto.Customer;
import edu.icet.model.entity.CustomerEntity;
import edu.icet.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllDetails() {
        List<CustomerEntity> allEntities = customerRepository.findAll();
        List<Customer> customerList = new ArrayList<>();

        for (CustomerEntity entity : allEntities) {
            customerList.add(new Customer(
                    entity.getCustomerId(),
                    entity.getName(),
                    entity.getEmail(),
                    entity.getPhone(),
                    entity.getAddress()
            ));
        }
        return customerList;
    }

    public void add(Customer customer) {
        CustomerEntity entity = new CustomerEntity(
                customer.getCustomerId(),
                customer.getName(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getAddress()
        );
        customerRepository.save(entity);
    }

    public Customer searchById(String customerId) {
        Optional<CustomerEntity> optional = customerRepository.findById(customerId);
        CustomerEntity entity = optional.orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

        return new Customer(
                entity.getCustomerId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getAddress()
        );
    }

    public void update(Customer customer) {
        Optional<CustomerEntity> optional = customerRepository.findById(customer.getCustomerId());
        CustomerEntity entity = optional.orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customer.getCustomerId()));

        entity.setName(customer.getName());
        entity.setEmail(customer.getEmail());
        entity.setPhone(customer.getPhone());
        entity.setAddress(customer.getAddress());

        customerRepository.save(entity);
    }

    public void delete(String customerId) {
        Optional<CustomerEntity> optional = customerRepository.findById(customerId);
        CustomerEntity entity = optional.orElseThrow(() ->
                new RuntimeException("Customer not found with ID: " + customerId)
        );

        customerRepository.delete(entity);
    }

}
