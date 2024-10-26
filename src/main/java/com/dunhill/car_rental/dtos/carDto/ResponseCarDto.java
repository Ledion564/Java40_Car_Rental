package com.dunhill.car_rental.dtos.carDto;

import com.dunhill.car_rental.dtos.reviewDto.ResponseReviewDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Data transfer object for car details response")
public class ResponseCarDto {

        @Schema(description = "Unique identifier for the car", example = "1")
        private long id;

        @Schema(description = "Brand of the car", example = "Toyota")
        private String brand;

        @Schema(description = "Model of the car", example = "Corolla")
        private String model;

        @Schema(description = "Body type of the car", example = "Sedan")
        private String bodyType;

        @Schema(description = "Manufacture year of the car", example = "2018-01-01")
        private LocalDate manufactureYear;

        @Schema(description = "Colour of the car", example = "Red")
        private String colour;

        @Schema(description = "Mileage of the car", example = "50000")
        private long mileAge;

        @Schema(description = "Status of the car", example = "Available")
        private String status;

        @Schema(description = "Rental amount for the car", example = "100")
        private long amount;

        @Schema(description = "User who created the car entry", example = "admin")
        private String createdBy;

        @Schema(description = "Date and time when the car entry was created", example = "2023-01-01T10:00:00")
        private LocalDateTime createdAt;

        @Schema(description = "Date and time when the car entry was last updated", example = "2023-01-02T15:00:00")
        private LocalDateTime updatedAt;

        @Schema(description = "ID of the car category", example = "3")
        private Long categoryId;

        @Schema(description = "Name of the car category", example = "SUV")
        private String categoryName;

        @Schema(description = "List of reviews associated with the car")
        private List<ResponseReviewDto> reviews;
}
