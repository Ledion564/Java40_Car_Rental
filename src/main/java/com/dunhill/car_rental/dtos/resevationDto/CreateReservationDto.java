package com.dunhill.car_rental.dtos.resevationDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Schema(description = "Data transfer object for creating a new reservation")
public class CreateReservationDto {

    @Schema(description = "Date of booking", example = "2024-10-26", required = true)
    private LocalDate dateOfBooking;

    @Schema(description = "Start date of the reservation", example = "2024-11-01", required = true)
    private LocalDate dateFrom;

    @Schema(description = "End date of the reservation", example = "2024-11-05", required = true)
    private LocalDate dateTo;

    @Schema(description = "Total amount for the reservation", example = "200.00", required = true)
    private BigDecimal amount;
}
