package com.dunhill.car_rental.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreatePersonelDto extends CreateUserDto{

    private String firstName;
    private String lastName;
    private String email;
    private String address;


}
