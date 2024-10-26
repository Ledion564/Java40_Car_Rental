package com.dunhill.car_rental.dtos.categoryDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Data transfer object for creating a new category")
public class CreateCategoryDto {

    @Schema(description = "Name of the category", example = "Luxury", required = true)
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @Schema(description = "Description of the category", example = "Luxury cars with premium features")
    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @Schema(description = "Type of the category", example = "TYPE_A", allowableValues = {"TYPE_A", "TYPE_B", "TYPE_C"}, required = true)
    @NotBlank(message = "Category type cannot be blank")
    @Pattern(regexp = "TYPE_A|TYPE_B|TYPE_C", message = "Category type must be one of the following: TYPE_A, TYPE_B, TYPE_C")
    private String categoryType;

    @Schema(description = "Priority of the category", example = "5", required = true)
    @Min(value = 1, message = "Priority must be at least 1")
    @Max(value = 10, message = "Priority cannot be greater than 10")
    private int priority;

    @Schema(description = "Rating of the category", example = "4.5")
    @DecimalMin(value = "0.0", message = "Rating cannot be less than 0.0")
    @DecimalMax(value = "5.0", message = "Rating cannot be greater than 5.0")
    private double rating;

    @Schema(description = "User who created the entry", example = "admin", required = true)
    @NotBlank(message = "Created by cannot be blank")
    private String createdBy;

    @Schema(description = "Date and time when the category was created", example = "2023-01-01T10:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "Date and time when the category was last updated", example = "2023-01-02T15:00:00")
    private LocalDateTime updatedAt;

    @Schema(description = "Indicates if the category is active", example = "true")
    private boolean isActive;
}
