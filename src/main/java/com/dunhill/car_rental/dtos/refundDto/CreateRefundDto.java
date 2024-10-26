package com.dunhill.car_rental.dtos.refundDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Data transfer object for creating a new refund")
public class CreateRefundDto {

    @Schema(description = "Date of the return", example = "2024-10-26", required = true)
    private LocalDate dateOfReturn;

    @Schema(description = "Surcharge amount for the refund", example = "15.75")
    private BigDecimal surcharge;

    @Schema(description = "Comments or notes regarding the refund", example = "Late return penalty")
    private String comments;
}
