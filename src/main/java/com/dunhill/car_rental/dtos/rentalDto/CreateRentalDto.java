package com.dunhill.car_rental.dtos.rentalDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Data transfer object for creating a new rental")
public class CreateRentalDto {

    @Schema(description = "Name of the rental company", example = "Dunhill Rentals", required = true)
    private String name;

    @Schema(description = "Internet domain of the rental company", example = "www.dunhillrentals.com", required = true)
    private String internetDomain;

    @Schema(description = "Contact address of the rental company", example = "789 Pine St, Tirana, Albania", required = true)
    private String contactAddress;

    @Schema(description = "Owner of the rental company", example = "John Doe", required = true)
    private String owner;

    @Schema(description = "Logo of the rental company", example = "logo.png")
    private String logotype;
}
