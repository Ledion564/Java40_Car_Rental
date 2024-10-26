package com.dunhill.car_rental.dtos.categoryDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Data transfer object for category details response")
public class ResponseCategoryDto {

    @Schema(description = "Unique identifier for the category", example = "1")
    private long id;

    @Schema(description = "Name of the category", example = "Luxury")
    private String name;

    @Schema(description = "Description of the category", example = "High-end luxury vehicles")
    private String description;

    @Schema(description = "Type of the category", example = "TYPE_A")
    private String categoryType;

    @Schema(description = "Priority level of the category, ranging from 1 to 10", example = "5")
    private int priority;

    @Schema(description = "Rating of the category, ranging from 0.0 to 5.0", example = "4.5")
    private double rating;

    @Schema(description = "User who created the category entry", example = "admin")
    private String createdBy;

    @Schema(description = "Date and time when the category was created", example = "2023-01-01T10:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "Date and time when the category was last updated", example = "2023-01-02T15:00:00")
    private LocalDateTime updatedAt;

    @Schema(description = "Indicates if the category is active", example = "true")
    private boolean isActive;
}
