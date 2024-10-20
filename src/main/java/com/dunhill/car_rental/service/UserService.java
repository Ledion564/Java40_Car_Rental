package com.dunhill.car_rental.service;

import com.dunhill.car_rental.dtos.CreateUserDto;
import com.dunhill.car_rental.dtos.ResponseUserDto;
import com.dunhill.car_rental.entity.Role;
import com.dunhill.car_rental.entity.User;
import com.dunhill.car_rental.exceptions.NotFoundException;
import com.dunhill.car_rental.mapper.UserMapper;
import com.dunhill.car_rental.repository.RoleRepository;
import com.dunhill.car_rental.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public ResponseUserDto save(CreateUserDto createUserDto){

        Set<String> roles = createUserDto.getRoles();
        Set<Role> roleSet = new HashSet<>();
        for (String role : roles) {
            roleSet.add(roleRepository.findByRole(role).orElseThrow(()->new NotFoundException("Role not found")));
        }
        User user = userMapper.mapToEntity(createUserDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(roleSet);
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
//        user.setEmail(createUserDto.getEmail());
        user.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
//        user.setUpdatedAt(LocalDateTime.now());
//        user.setActive(createUserDto.isActive());
        return userMapper.mapToDto(user);
    }

}
