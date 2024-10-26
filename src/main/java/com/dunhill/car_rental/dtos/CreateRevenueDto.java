package com.dunhill.car_rental.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Data transfer object for creating revenue details")
public class CreateRevenueDto {

    @Schema(description = "Total amount of revenue", example = "10000.00", required = true)
    private double totalAmount;

    @Schema(description = "Approved amount of revenue", example = "8000.00", required = true)
    private double approvedAmount;

    @Schema(description = "Unapproved amount of revenue", example = "2000.00", required = true)
    private double unapprovedAmount;
}
