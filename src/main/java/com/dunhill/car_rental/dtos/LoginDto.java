package com.dunhill.car_rental.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class LoginDto {

    private String username;
    private String password;
    private String email;
}
