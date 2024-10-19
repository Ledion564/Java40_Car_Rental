package com.dunhill.car_rental.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_id")
    private long id;

    @Column(name = "brand")
    private String brand;
    @Column(name = "Model")
    private String model;

    @Column(name = "body_Type")
    private String bodyType;

    @Column(name = "manufacture_year")
    private LocalDate manufactureYear;

    @Column(name = "colour")
    private String colour;

    @Column(name = "mileage")
    private long mileAge;

    @Column(name = "status")
    private String status;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}