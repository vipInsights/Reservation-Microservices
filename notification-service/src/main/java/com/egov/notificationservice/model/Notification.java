package com.egov.notificationservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "notifications")
public class Notification {
    @Id
    private String id;
    private String toUserId;
    private String message;
    private String channel;
    private String status;

    private LocalDateTime createdAt = LocalDateTime.now();
}
