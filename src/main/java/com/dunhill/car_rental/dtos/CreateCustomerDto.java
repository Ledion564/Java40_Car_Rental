package com.dunhill.car_rental.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@SuperBuilder
@Schema(description = "Data transfer object for creating a new customer")
public class CreateCustomerDto extends CreateUserDto {

    @Schema(description = "First name of the customer", example = "John", required = true)
    private String firstName;

    @Schema(description = "Last name of the customer", example = "Doe", required = true)
    private String lastName;

    @Schema(description = "Phone number of the customer", example = "+123456789", required = true)
    private String phone;

    @Schema(description = "Address of the customer", example = "123 Main St, Tirana, Albania", required = true)
    private String address;
}
