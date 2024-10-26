package com.dunhill.car_rental.dtos.revenueDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Data transfer object for revenue response")
public class ResponseRevenueDto {

    @Schema(description = "Unique identifier for the revenue record", example = "1")
    private Long id;

    @Schema(description = "Total amount of revenue", example = "1000.50")
    private double totalAmount;

    @Schema(description = "Total amount of approved revenue", example = "800.00")
    private double approvedAmount;

    @Schema(description = "Total amount of unapproved revenue", example = "200.50")
    private double unapprovedAmount;
}
