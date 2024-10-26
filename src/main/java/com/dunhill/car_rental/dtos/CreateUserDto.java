package com.dunhill.car_rental.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Data transfer object for creating a new user")
public class CreateUserDto {

    @Schema(description = "Username of the user", example = "john_doe", required = true)
    private String username;

    @Schema(description = "Email address of the user", example = "john.doe@example.com", required = true)
    private String email;

    @Schema(description = "Password for the user account", example = "password123", required = true)
    private String password;

    // Uncomment these fields if you decide to include them
    // @Schema(description = "Roles assigned to the user", example = "[\"ROLE_USER\", \"ROLE_ADMIN\"]")
    // private Set<String> roles;

    // @Schema(description = "Timestamp of when the user was created", example = "2024-10-26T14:30:00")
    // private LocalDateTime createdAt;

    // @Schema(description = "Timestamp of when the user was last updated", example = "2024-10-27T15:00:00")
    // private LocalDateTime updatedAt;

    // @Schema(description = "Indicates whether the user account is active", example = "true")
    // private boolean isActive;
}
