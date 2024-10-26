package com.dunhill.car_rental.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "Data transfer object for creating a review")
public class CreateReviewDto {

    @Schema(description = "Username of the reviewer", example = "john_doe", required = true)
    private String username;

    @Schema(description = "Description of the review", example = "Great service and friendly staff!", required = true)
    private String description;

    @Schema(description = "User who created the review", example = "admin", required = true)
    private String createdBy;

    @Schema(description = "Timestamp of when the review was created", example = "2024-10-26T14:30:00")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp of when the review was last updated", example = "2024-10-27T15:00:00")
    private LocalDateTime updatedAt;
}
