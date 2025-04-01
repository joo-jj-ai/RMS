package com.example.ration_system_application.ration_system_application.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class RationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int requestedQuantity;
    private String status;  // PENDING, APPROVED, REJECTED
    private String comment;

    @ManyToOne
    private User user ;

    @ManyToOne
    private  Stock stock ;

    
}

