package com.dunhill.car_rental.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ResponseRevenueDto {
    private Long id;
    private double totalAmount;
    private double approvedAmount;
    private double unapprovedAmount;
}
