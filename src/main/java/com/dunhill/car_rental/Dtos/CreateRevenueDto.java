package com.dunhill.car_rental.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateRevenueDto {
    private BigDecimal totalAmount;
    private BigDecimal approvedAmount;
    private BigDecimal unapprovedAmount;
}
