package com.dunhill.car_rental.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRefundDto {

    private Long id;

    private LocalDate dateOfReturn;
    private BigDecimal surcharge;
    private String comments;

}
