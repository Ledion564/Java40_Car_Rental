package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.dtos.CreateCustomerDto;
import com.dunhill.car_rental.dtos.CreateUserDto;
import com.dunhill.car_rental.dtos.LoginDto;
import com.dunhill.car_rental.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@Tag(name = "Authentication and Account Management APIs")
public class AccountController {

    private AccountService accountService;

    @Operation(summary = "User Login REST API", description = "Authenticates a user and returns a token.")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        return ResponseEntity.ok(accountService.login(loginDto));
    }

    @Operation(summary = "User Registration REST API", description = "Registers a new customer and returns a confirmation message.")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@RequestBody CreateCustomerDto createCustomerDto){
        return ResponseEntity.ok(accountService.register(createCustomerDto));
    }

//    @PostMapping("/personel")
//public ResponseEntity<>

}
