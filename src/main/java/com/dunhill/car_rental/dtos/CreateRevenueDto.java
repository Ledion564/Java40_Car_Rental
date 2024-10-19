package com.dunhill.car_rental.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateRevenueDto {
    private double totalAmount;
    private double approvedAmount;
    private double unapprovedAmount;
}
