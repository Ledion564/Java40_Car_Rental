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
@Schema(description = "Data transfer object for rental details response")
public class ResponseRentalDto {

    @Schema(description = "Unique identifier for the rental", example = "1")
    private Long id;

    @Schema(description = "Name of the rental company", example = "Dunhill Car Rental")
    private String name;

    @Schema(description = "Internet domain of the rental company", example = "www.dunhillcarrental.com")
    private String internetDomain;

    @Schema(description = "Contact address of the rental company", example = "123 Main St, Tirana, Albania")
    private String contactAddress;

    @Schema(description = "Owner of the rental company", example = "John Doe")
    private String owner;

    @Schema(description = "URL or path to the rental company's logo image", example = "/images/logo.png")
    private String logotype;
}
