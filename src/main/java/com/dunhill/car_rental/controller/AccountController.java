package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.dtos.CreatePersonelDto;
import com.dunhill.car_rental.dtos.customerDto.CreateCustomerDto;
import com.dunhill.car_rental.dtos.userDto.CreateUserDto;
import com.dunhill.car_rental.dtos.userDto.LoginDto;
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

    @Operation(summary = "Register new personnel")
    @ApiResponse(responseCode = "200", description = "Successfully registered")
    @ApiResponse(responseCode = "400", description = "Invalid request data")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<String> registerPersonel(@RequestBody CreatePersonelDto createPersonelDto) {
        return ResponseEntity.ok(accountService.registerPersonel(createPersonelDto));
    }

}
