package com.egov.projectservice.service;

import com.egov.projectservice.model.Customer;
import com.egov.projectservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repo;

    public CustomerServiceImpl(CustomerRepository repo) { this.repo = repo; }

    @Override
    public Customer createCustomer(Customer customer) {
        return repo.save(customer);
    }

    @Override
    public Optional<Customer> getCustomerById(String id) {
        return repo.findById(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    @Override
    public Customer updateCustomer(String id, Customer customer) {
        customer.setId(id);
        return repo.save(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        repo.deleteById(id);
    }
}