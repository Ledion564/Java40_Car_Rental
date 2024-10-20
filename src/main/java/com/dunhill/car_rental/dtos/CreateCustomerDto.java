package com.dunhill.car_rental.dtos;

import com.dunhill.car_rental.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class CreateCustomerDto extends CreateUserDto {

    private String firstName;
    private String lastName;
    private String phone;
    private String address;
}
