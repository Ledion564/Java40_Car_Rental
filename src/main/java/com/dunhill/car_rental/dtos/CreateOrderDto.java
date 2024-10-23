package com.dunhill.car_rental.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderDto {

    private Long customerId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    private List<OrderCarDto> orderCars;


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderCarDto {
        private Long carId;
        private int quantity;
}
}