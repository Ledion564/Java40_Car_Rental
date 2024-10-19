package com.dunhill.car_rental.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class CreateCarDto {
    @NotBlank(message = "Brand is required")
    private String brand;

    @NotBlank(message = "Model is required")
    private String model;

    @NotBlank(message = "Body type is required")
    private String bodyType;

    @Past(message = "Manufacture year must be in the past")
    private LocalDate manufactureYear;

    @NotBlank(message = "Colour is required")
    private String colour;

    @PositiveOrZero(message = "Mileage must be zero or a positive number")
    private long mileAge;

    @NotBlank(message = "Status is required")
    private String status;

    @PositiveOrZero(message = "Amount must be zero or a positive number")
    private long amount;

    @NotBlank(message = "Created by is required")
    private String createdBy;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @NotNull(message = "Category ID is required")
    private Long categoryId;

}
