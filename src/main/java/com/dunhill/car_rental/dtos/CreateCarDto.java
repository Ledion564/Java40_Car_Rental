package com.dunhill.car_rental.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class CreateCarDto {
    private String brand;
    private String model;
    private String bodyType;
    private LocalDate manufactureYear;
    private String colour;
    private long mileAge;
    private String status;
    private long amount;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long categoryId;
}
