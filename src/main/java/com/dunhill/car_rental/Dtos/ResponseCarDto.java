package com.dunhill.car_rental.Dtos;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class ResponseCarDto {
        private long id;
        private String brand;
        private String model;
        private String bodyType;
        private LocalDate year;
        private String colour;
        private long mileAge;
        private String status;
        private long amount;
    }


