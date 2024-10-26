package com.dunhill.car_rental.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Schema(description = "Data transfer object for user login")
public class LoginDto {

    @Schema(description = "Username of the user", example = "john_doe", required = true)
    private String username;

    @Schema(description = "Password of the user", example = "password123", required = true)
    private String password;

    @Schema(description = "Email address of the user", example = "john.doe@example.com", required = true)
    private String email;
}
