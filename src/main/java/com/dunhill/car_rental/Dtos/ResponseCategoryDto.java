package com.dunhill.car_rental.Dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCategoryDto {

    private  long id;
    private String name;
    private String description;
    private String categoryType;
    private int priority;
    private double rating;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isActive;
}
