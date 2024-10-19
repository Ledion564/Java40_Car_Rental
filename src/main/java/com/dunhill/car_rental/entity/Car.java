package com.dunhill.car_rental.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_id")
    private long id;

    @NotBlank(message = "Brand cannot be blank")
    @Column(name = "brand")
    private String brand;

    @NotBlank(message = "Model cannot be blank")
    @Column(name = "Model")
    private String model;

    @NotBlank(message = "Body type cannot be blank")
    @Column(name = "body_Type")
    private String bodyType;

    @NotNull(message = "Manufacture year is required")
    @PastOrPresent(message = "Manufacture year must be in the past or present")
    @Column(name = "manufacture_year")
    private LocalDate manufactureYear;

    @NotBlank(message = "Colour cannot be blank")
    @Column(name = "colour")
    private String colour;

    @Min(value = 0, message = "Mileage cannot be negative")
    @Column(name = "mileage")
    private long mileAge;

    @NotBlank(message = "Status cannot be blank")
    @Column(name = "status")
    private String status;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    @Column(name = "amount")
    private Long amount;

    @NotBlank(message = "Created by cannot be blank")
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviewList;
}

