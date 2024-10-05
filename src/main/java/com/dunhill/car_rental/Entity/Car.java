package com.dunhill.car_rental.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Brand")
    private String brand;
    @Column(name = "Model")
    private String model;
    @Column(name = "Body_Type")
    private String bodyType;
    @Column(name = "manufacture_year")
    private LocalDate manufactureYear;
    @Column(name = "Colour")
    private String colour;
    @Column(name = "Mileage")
    private long mileAge;
    @Column(name = "Status")
    private String status;
    @Column(name = "Amount")
    private long amount;
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