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
@Schema(description = "Data transfer object for refund details response")
public class ResponseRefundDto {

    @Schema(description = "Unique identifier for the refund", example = "1")
    private Long id;

    @Schema(description = "Date the car was returned", example = "2023-08-15")
    private LocalDate dateOfReturn;

    @Schema(description = "Additional surcharge applied during refund", example = "25.00")
    private BigDecimal surcharge;

    @Schema(description = "Comments or notes regarding the refund", example = "Late return fee applied")
    private String comments;

}
