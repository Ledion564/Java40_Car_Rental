package com.dunhill.car_rental.service;

import com.dunhill.car_rental.Dtos.CreateCategoryDto;
import com.dunhill.car_rental.Dtos.CreateUserDto;
import com.dunhill.car_rental.Dtos.ResponseCategoryDto;
import com.dunhill.car_rental.Dtos.ResponseUserDto;
import com.dunhill.car_rental.Entity.Category;
import com.dunhill.car_rental.Entity.User;
import com.dunhill.car_rental.Exceptions.NotFoundException;
import com.dunhill.car_rental.mapper.UserMapper;
import com.dunhill.car_rental.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public ResponseUserDto update(Long id, CreateUserDto createUserDto) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        user.setUsername(createUserDto.getUsername());
        user.setEmail(createUserDto.getEmail());
        user.setPassword(createUserDto.getPassword());
        user.setUpdatedAt(LocalDateTime.now());
        user.setActive(createUserDto.isActive());
        return userMapper.mapToDto(user);
    }

}
