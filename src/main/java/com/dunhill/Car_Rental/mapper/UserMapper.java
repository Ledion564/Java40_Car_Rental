package com.dunhill.Car_Rental.mapper;

import com.dunhill.Car_Rental.Dtos.CreateUserDto;
import com.dunhill.Car_Rental.Dtos.ResponseCarDto;
import com.dunhill.Car_Rental.Dtos.ResponseUserDto;
import com.dunhill.Car_Rental.Entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity mapToEntity(CreateUserDto createUserDto){
        UserEntity user = new UserEntity();
        user.setUsername(createUserDto.getUsername());
        user.setEmail(createUserDto.getEmail());
        user.setPassword(createUserDto.getPassword());
        return user;
    }

    public ResponseUserDto mapToDto(UserEntity user){
        ResponseUserDto responseUserDto = new ResponseUserDto();
        responseUserDto.setId(user.getId());
        responseUserDto.setUsername(user.getUsername());
        responseUserDto.setEmail(user.getEmail());
        responseUserDto.setPassword(user.getPassword());
        return responseUserDto;
    }

    public UserEntity update(CreateUserDto createUserDto,UserEntity userEntity){
        userEntity.setUsername(createUserDto.getUsername());
        userEntity.setEmail(createUserDto.getEmail());
        userEntity.setPassword(createUserDto.getPassword());
        return userEntity;
    }
}
