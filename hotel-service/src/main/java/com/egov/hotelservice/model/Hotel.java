package com.egov.hotelservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "hotels")
public class Hotel {
    @Id
    private String id;
    private String hotelName;
    private String hotelAddress;
    private int totalRooms;
    private double pricePerNight;

    private LocalDateTime createdAt = LocalDateTime.now();
}
