package com.egov.reservationservice.service;


import com.egov.reservationservice.model.Reservation;
import com.egov.reservationservice.repository.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ReservationService {

    private static final Logger logger = LoggerFactory.getLogger(ReservationService.class);
    private final ReservationRepository repo;
    private final WebClient webClient;

    public ReservationService(ReservationRepository repo, WebClient webClient) {
        this.repo = repo;
        this.webClient = webClient;
    }

    public List<Reservation> findAll() { return repo.findAll(); }
    public Optional<Reservation> findById(String id) { return repo.findById(id); }

    public ResponseEntity<?> save(Reservation obj) {
        try {
            // Step 1: Save reservation in DB
            Reservation saved = repo.save(obj);
            logger.info("Reservation saved successfully: {}", saved);

            // Step 2: Prepare notification request
            NotificationRequest request = new NotificationRequest(
                    saved.getCustomerId(),
                    "Your reservation is confirmed for hotel " + saved.getHotelId(),
                    "EMAIL",
                    "PENDING"
            );

            // Step 3: Blocking call to notification-service
            ResponseEntity<Void> response = webClient.post()
                    //.uri("/notifications")  // adjust endpoint if needed
                    .bodyValue(request)
                    .retrieve()
                    .toBodilessEntity()
                    .block(); // wait for notification response

            logger.info("Notification triggered successfully for reservationId: {}", saved.getId());

            // Step 4: Return combined success response
            return ResponseEntity.ok(Map.of(
                    "reservation", saved,
                    "notificationStatus", response.getStatusCode()
            ));

        } catch (Exception e) {
            logger.error("Failed to save reservation or trigger notification. Error: {}", e.getMessage(), e);

            // Step 5: Return failure response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of(
                            "error", "Failed to save reservation/trigger notification",
                            "details", e.getMessage()
                    ));
        }
    }

/*    public Reservation save(Reservation obj) {
        Reservation saved = repo.save(obj);
        logger.info("Request received to trigger notification request: " + obj);
        // Fire-and-forget async call to notification-service
        webClient.post()
                .bodyValue(new NotificationRequest(
                        saved.getCustomerId(),
                        "Your reservation is confirmed for hotel " + saved.getHotelId(),
                        "EMAIL",
                        "PENDING"
                ))
                .retrieve()
                .toBodilessEntity()
                .doOnSuccess(response -> logger.info("Notification request triggered successfully for reservationId: {}", saved.getId()))
                .doOnError(error -> logger.error("Failed to trigger notification for reservationId: {}. Error: {}", saved.getId(), error.getMessage(), error))
                .subscribe(); // non-blocking
        logger.info("Call successful to trigger notification  request : " + obj);
        return saved;
    }*/

    public void delete(String id) { repo.deleteById(id); }

    // DTO for notification payload
    static record NotificationRequest(String toUserId, String message, String channel, String status) {}
}

