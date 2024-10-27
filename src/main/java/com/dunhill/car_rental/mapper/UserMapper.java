package com.dunhill.car_rental.mapper;

import com.dunhill.car_rental.dtos.userDto.CreateUserDto;
import com.dunhill.car_rental.dtos.userDto.ResponseUserDto;
import com.dunhill.car_rental.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserMapper {

    public User mapToEntity(CreateUserDto createUserDto){
        User user = new User();
        user.setUsername(createUserDto.getUsername());
        user.setEmail(createUserDto.getEmail());
        user.setPassword(createUserDto.getPassword());
//        user.setCreatedAt(LocalDateTime.now());
//        user.setActive(true);
        return user;
    }

    public ResponseUserDto mapToDto(User user){
        ResponseUserDto responseUserDto = new ResponseUserDto();
        responseUserDto.setId(user.getId());
        responseUserDto.setUsername(user.getUsername());
        responseUserDto.setEmail(user.getEmail());
        responseUserDto.setPassword(user.getPassword());
        responseUserDto.setRoles(user.getRoles());
//        responseUserDto.setCreatedAt(user.getCreatedAt());
//        responseUserDto.setUpdatedAt(user.getUpdatedAt());
//        responseUserDto.setActive(user.isActive());
        return responseUserDto;
    }

    public User update(CreateUserDto createUserDto, User user){
        user.setUsername(createUserDto.getUsername());
        user.setEmail(createUserDto.getEmail());
        user.setPassword(createUserDto.getPassword());
//        user.setUpdatedAt(LocalDateTime.now());
//        user.setActive(createUserDto.isActive());
        return user;
    }
}
