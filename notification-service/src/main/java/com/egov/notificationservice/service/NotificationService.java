package com.egov.notificationservice.service;


import com.egov.notificationservice.model.Notification;
import com.egov.notificationservice.repository.NotificationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
    private final NotificationRepository repo;

    public NotificationService(NotificationRepository repo) {
        this.repo = repo;
    }

    public List<Notification> findAll() { return repo.findAll(); }
    public Optional<Notification> findById(String id) { return repo.findById(id); }
    public Notification save(Notification obj) {
        logger.info("Data Saved into DB: " + obj);
        return repo.save(obj); }
    public void delete(String id) { repo.deleteById(id); }
}
