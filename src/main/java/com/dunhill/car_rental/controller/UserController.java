package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.dtos.CreateUserDto;
import com.dunhill.car_rental.dtos.ResponseUserDto;
import com.dunhill.car_rental.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @PreAuthorize("hasAnyRole('ADMIN','HR')")
    @PostMapping
    public ResponseEntity<ResponseUserDto> save(@RequestBody CreateUserDto createUserDto){
        return ResponseEntity.ok(userService.save(createUserDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseUserDto>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseUserDto> update(@PathVariable Long id, @RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok(userService.update(id, createUserDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("uId") Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
