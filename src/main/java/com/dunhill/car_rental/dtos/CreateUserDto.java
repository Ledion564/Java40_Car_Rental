package com.dunhill.car_rental.dtos;

import com.dunhill.car_rental.entity.Role;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {

    private String username;
    private String email;
    private String password;
    private Set<String> roles;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
//    private boolean isActive;

}
