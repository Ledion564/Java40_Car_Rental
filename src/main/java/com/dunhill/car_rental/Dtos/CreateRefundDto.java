package com.dunhill.car_rental.Dtos;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CreateRefundDto {

    private LocalDate dateOfReturn;
    private BigDecimal surcharge;
    private String comments;
}
