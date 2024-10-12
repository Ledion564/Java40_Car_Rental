package com.dunhill.car_rental.ServiceTest;

import com.dunhill.car_rental.Dtos.CreateCarDto;
import com.dunhill.car_rental.Dtos.CreateUserDto;
import com.dunhill.car_rental.Dtos.ResponseUserDto;
import com.dunhill.car_rental.Entity.Car;
import com.dunhill.car_rental.Entity.User;
import com.dunhill.car_rental.mapper.UserMapper;
import com.dunhill.car_rental.repository.UserRepository;
import com.dunhill.car_rental.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    private User user;
    private ResponseUserDto responseUserDto;
    private CreateUserDto createUserDto;

    @BeforeEach
    void setup(){
        user= User.builder().id(1L).username("ferit").email("gmail").password("bro").createdAt(LocalDateTime.now()).build();
        responseUserDto= ResponseUserDto.builder().id(1L).username("ferit").email("gmail").password("bro").createdAt(LocalDateTime.now()).build();
        createUserDto= CreateUserDto.builder().username("ferit").email("gmail").password("bro").createdAt(LocalDateTime.now()).build();
    }

    @Test
    public void save(){
        when(userMapper.mapToEntity(any(CreateUserDto.class))).thenReturn(user);
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userMapper.mapToDto(any(User.class))).thenReturn(responseUserDto);

        userService.save(createUserDto);

        verify(userRepository).save(user);
    }
    @Test
    public void delete(){

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        userService.delete(user.getId());
        verify(userRepository).delete(user);
    }

    @Test
    public void getAll(){
        List<User> users= asList(new User());
        when(userRepository.findAll()).thenReturn(users);
        when(userMapper.mapToDto(any(User.class))).thenReturn(responseUserDto);
        userService.getAll();

        verify(userRepository).findAll();
        verify(userMapper).mapToDto(any(User.class));
    }

}
