package com.dunhill.car_rental.dtos;


import com.dunhill.car_rental.dtos.carDto.CarDetails;
import com.dunhill.car_rental.entity.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Invoice {
    private Long orderId;
    private List<CarDetails> cars;
    private BigDecimal subTotal;
    private BigDecimal tax;
    private BigDecimal tips;
    private BigDecimal grandTotal;
    private OrderStatus status;
}
