package com.dunhill.car_rental.Dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ResponseReservationDto {
    private long id;
    private LocalDate dateOfBooking;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private BigDecimal amount;
}
