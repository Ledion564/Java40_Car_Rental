package com.dunhill.car_rental.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseRevenueDto {
    private Long id;
    private double totalAmount;
    private double approvedAmount;
    private double unapprovedAmount;
}
