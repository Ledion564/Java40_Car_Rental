package com.dunhill.car_rental.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {

    private String username;
    private String email;
    private String password;
}
