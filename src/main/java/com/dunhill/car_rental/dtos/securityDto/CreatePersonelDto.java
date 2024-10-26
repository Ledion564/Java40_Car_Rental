package com.dunhill.car_rental.dtos.securityDto;

import com.dunhill.car_rental.dtos.userDto.CreateUserDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(description = "Data transfer object for creating a new personnel")
public class CreatePersonelDto extends CreateUserDto {

    @Schema(description = "First name of the personnel", example = "Alice", required = true)
    private String firstName;

    @Schema(description = "Last name of the personnel", example = "Smith", required = true)
    private String lastName;

    @Schema(description = "Email address of the personnel", example = "alice.smith@example.com", required = true)
    private String email;

    @Schema(description = "Address of the personnel", example = "456 Elm St, Tirana, Albania", required = true)
    private String address;
}
