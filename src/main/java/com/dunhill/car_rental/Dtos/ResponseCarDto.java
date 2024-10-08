package com.dunhill.car_rental.Dtos;


import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCarDto {
        private long id;
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
    }


