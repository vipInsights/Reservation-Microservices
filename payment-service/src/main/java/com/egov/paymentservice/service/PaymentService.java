package com.egov.paymentservice.service;


import com.egov.paymentservice.model.Payment;
import com.egov.paymentservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    private final PaymentRepository repo;

    public PaymentService(PaymentRepository repo) {
        this.repo = repo;
    }

    public List<Payment> findAll() { return repo.findAll(); }
    public Optional<Payment> findById(String id) { return repo.findById(id); }
    public Payment save(Payment obj) { return repo.save(obj); }
    public void delete(String id) { repo.deleteById(id); }
}
