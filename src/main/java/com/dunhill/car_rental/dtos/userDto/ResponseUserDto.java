package com.dunhill.car_rental.dtos.userDto;

import com.dunhill.car_rental.entity.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Data transfer object for user response")
public class ResponseUserDto {

    @Schema(description = "Unique identifier for the user", example = "1")
    private Long id;

    @Schema(description = "Username of the user", example = "johndoe")
    private String username;

    @Schema(description = "Email address of the user", example = "johndoe@example.com")
    private String email;

    @Schema(description = "Password of the user (encrypted)", example = "encrypted_password")
    private String password;

    @Schema(description = "Date and time when the user was created", example = "2023-01-01T10:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "Date and time when the user was last updated", example = "2023-01-02T15:00:00")
    private LocalDateTime updatedAt;

    @Schema(description = "Indicates whether the user is active", example = "true")
    private boolean isActive;

    @Schema(description = "Set of roles assigned to the user")
    private Set<Role> roles;
}
