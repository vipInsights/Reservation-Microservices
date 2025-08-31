package com.egov.reservationservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "reservations")
public class Reservation {
    @Id
    private String id;
    private String customerId;
    private String hotelId;
    private String roomNumber;
    private String status;
    private java.time.LocalDate checkIn;
    private java.time.LocalDate checkOut;

    private LocalDateTime createdAt = LocalDateTime.now();
}
