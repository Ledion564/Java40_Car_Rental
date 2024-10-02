package com.dunhill.Car_Rental.service;

import com.dunhill.Car_Rental.Dtos.CreateUserDto;
import com.dunhill.Car_Rental.Dtos.ResponseUserDto;
import com.dunhill.Car_Rental.Entity.User;
import com.dunhill.Car_Rental.Exceptions.NotFoundException;
import com.dunhill.Car_Rental.mapper.UserMapper;
import com.dunhill.Car_Rental.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public ResponseUserDto save(CreateUserDto createUserDto){
        User user = userMapper.mapToEntity(createUserDto);
        User saved = userRepository.save(user);
        ResponseUserDto responseUserDto = userMapper.mapToDto(saved);
        return responseUserDto;
    }

    public List<ResponseUserDto> getAll(){
        return userRepository.findAll().stream().map(userMapper::mapToDto).toList();
    }

    public void delete(Long id){
        User found = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No user Found"));
        userRepository.delete(found);
    }

    public ResponseUserDto update(CreateUserDto createUserDto){
        User found = userRepository.findByUsername(createUserDto.getUsername());
        found = userMapper.update(createUserDto,found);
        return userMapper.mapToDto(userRepository.save(found));
    }

}
