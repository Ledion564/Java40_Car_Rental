package com.dunhill.car_rental.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateCarDto {
    private String brand;
    private String model;
    private String bodyType;
    private LocalDateTime year;
    private String colour;
    private long mileAge;
    private String status;
    private long amount;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}