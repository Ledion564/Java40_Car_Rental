package com.dunhill.car_rental.service;

import com.dunhill.car_rental.Dtos.CreateUserDto;
import com.dunhill.car_rental.Dtos.ResponseUserDto;
import com.dunhill.car_rental.Entity.User;
import com.dunhill.car_rental.Exceptions.NotFoundException;
import com.dunhill.car_rental.mapper.UserMapper;
import com.dunhill.car_rental.repository.UserRepository;
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
