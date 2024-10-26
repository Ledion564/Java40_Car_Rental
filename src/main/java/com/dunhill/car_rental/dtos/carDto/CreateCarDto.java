package com.dunhill.car_rental.dtos.carDto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Data transfer object for creating a new car")
public class CreateCarDto {

    @Schema(description = "Brand of the car", example = "Toyota", required = true)
    @NotBlank(message = "Brand is required")
    private String brand;

    @Schema(description = "Model of the car", example = "Corolla", required = true)
    @NotBlank(message = "Model is required")
    private String model;

    @Schema(description = "Body type of the car", example = "Sedan", required = true)
    @NotBlank(message = "Body type is required")
    private String bodyType;

    @Schema(description = "Manufacture year of the car", example = "2018-01-01", required = true)
    @Past(message = "Manufacture year must be in the past")
    private LocalDate manufactureYear;

    @Schema(description = "Colour of the car", example = "Red", required = true)
    @NotBlank(message = "Colour is required")
    private String colour;

    @Schema(description = "Mileage of the car", example = "50000", required = true)
    @PositiveOrZero(message = "Mileage must be zero or a positive number")
    private long mileAge;

    @Schema(description = "Status of the car", example = "Available", required = true)
    @NotBlank(message = "Status is required")
    private String status;

    @Schema(description = "Amount for renting the car", example = "100", required = true)
    @PositiveOrZero(message = "Amount must be zero or a positive number")
    private long amount;

    @Schema(description = "User who created the entry", example = "admin", required = true)
    @NotBlank(message = "Created by is required")
    private String createdBy;

    @Schema(description = "Date and time when the car was created", example = "2023-01-01T10:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "Date and time when the car was last updated", example = "2023-01-02T15:00:00")
    private LocalDateTime updatedAt;

    @Schema(description = "ID of the car category", example = "3", required = true)
    @NotNull(message = "Category ID is required")
    private Long categoryId;
}
