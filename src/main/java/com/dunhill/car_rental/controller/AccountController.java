package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.dtos.CreateCustomerDto;
import com.dunhill.car_rental.dtos.CreatePersonelDto;
import com.dunhill.car_rental.dtos.CreateUserDto;
import com.dunhill.car_rental.dtos.LoginDto;
import com.dunhill.car_rental.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok(accountService.login(loginDto));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody CreateCustomerDto createCustomerDto){
        return ResponseEntity.ok(accountService.register(createCustomerDto));
    }

    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping("/personel")
    public ResponseEntity<String> registerPersonel(@RequestBody CreatePersonelDto createPersonelDto){
        return ResponseEntity.ok(accountService.registerPersonel(createPersonelDto));
    }

}
