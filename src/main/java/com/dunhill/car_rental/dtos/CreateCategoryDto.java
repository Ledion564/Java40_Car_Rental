package com.dunhill.car_rental.dtos;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryDto {

    @NotBlank(message = "Name cannot be blank")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    private String description;

    @NotBlank(message = "Category type cannot be blank")
    @Pattern(regexp = "TYPE_A|TYPE_B|TYPE_C", message = "Category type must be one of the following: TYPE_A, TYPE_B, TYPE_C")
    private String categoryType;

    @Min(value = 1, message = "Priority must be at least 1")
    @Max(value = 10, message = "Priority cannot be greater than 10")
    private int priority;

    @DecimalMin(value = "0.0", message = "Rating cannot be less than 0.0")
    @DecimalMax(value = "5.0", message = "Rating cannot be greater than 5.0")
    private double rating;

    @NotBlank(message = "Created by cannot be blank")
    private String createdBy;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private boolean isActive;
}
