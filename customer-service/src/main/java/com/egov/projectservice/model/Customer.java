package com.egov.projectservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "customers")
@Getter
@Setter
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private LocalDateTime createdAt = LocalDateTime.now();
    // getters/setters...
}
