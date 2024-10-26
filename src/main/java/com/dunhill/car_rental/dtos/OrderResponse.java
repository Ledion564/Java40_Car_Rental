package com.dunhill.car_rental.dtos;

import com.dunhill.car_rental.entity.Personel;
import com.dunhill.car_rental.entity.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderResponse {

    private Long id;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private Long customerId;
    private Personel personel;

}
