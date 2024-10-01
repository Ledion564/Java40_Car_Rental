package com.dunhill.Car_Rental.controller;

import com.dunhill.Car_Rental.Dtos.CreateUserDto;
import com.dunhill.Car_Rental.Dtos.ResponseUserDto;
import com.dunhill.Car_Rental.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseUserDto> save(@RequestBody CreateUserDto createUserDto){
        return ResponseEntity.ok(userService.save(createUserDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseUserDto>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping
    public ResponseEntity<ResponseUserDto> update(CreateUserDto createUserDto){
        return ResponseEntity.ok(userService.update(createUserDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("uId") Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
