package com.egov.projectservice.controller;

import com.egov.projectservice.model.Customer;
import com.egov.projectservice.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer c) {
        Customer created = service.createCustomer(c);
        return ResponseEntity.created(URI.create("/api/customers/" + created.getId())).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> get(@PathVariable String id) {
        return service.getCustomerById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Customer> list() { return service.getAllCustomers(); }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable String id, @RequestBody Customer c) {
        return ResponseEntity.ok(service.updateCustomer(id, c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}