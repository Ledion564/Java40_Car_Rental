package com.dunhill.car_rental.mapper;

import com.dunhill.car_rental.Dtos.CreateUserDto;
import com.dunhill.car_rental.Dtos.ResponseUserDto;
import com.dunhill.car_rental.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToEntity(CreateUserDto createUserDto){
        User user = new User();
        user.setUsername(createUserDto.getUsername());
        user.setEmail(createUserDto.getEmail());
        user.setPassword(createUserDto.getPassword());
        return user;
    }

    public ResponseUserDto mapToDto(User user){
        ResponseUserDto responseUserDto = new ResponseUserDto();
        responseUserDto.setId(user.getId());
        responseUserDto.setUsername(user.getUsername());
        responseUserDto.setEmail(user.getEmail());
        responseUserDto.setPassword(user.getPassword());
        return responseUserDto;
    }

    public User update(CreateUserDto createUserDto, User user){
        user.setUsername(createUserDto.getUsername());
        user.setEmail(createUserDto.getEmail());
        user.setPassword(createUserDto.getPassword());
        return user;
    }
}
