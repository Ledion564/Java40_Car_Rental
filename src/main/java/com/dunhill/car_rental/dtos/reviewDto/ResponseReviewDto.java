package com.dunhill.car_rental.dtos.reviewDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "Data transfer object for review response")
public class ResponseReviewDto {

    @Schema(description = "Unique identifier for the review", example = "1")
    private Long id;

    @Schema(description = "Username of the reviewer", example = "johndoe")
    private String username;

    @Schema(description = "Review description", example = "Great experience with this car!")
    private String description;

    @Schema(description = "Name of the user who created the review", example = "admin")
    private String createdBy;

    @Schema(description = "Date and time when the review was created", example = "2023-01-01T10:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "Date and time when the review was last updated", example = "2023-01-02T15:00:00")
    private LocalDateTime updatedAt;

    @Schema(description = "ID of the car related to the review", example = "3")
    private Long carId;

    @Schema(description = "Name of the car related to the review", example = "Toyota Corolla")
    private String carName;
}
