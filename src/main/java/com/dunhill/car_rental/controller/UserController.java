package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.dtos.CreateUserDto;
import com.dunhill.car_rental.dtos.ResponseUserDto;
import com.dunhill.car_rental.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Tag(name="CRUD REST API FOR USER RESOURCE")
public class UserController {

    private UserService userService;

    @Operation(summary = "CREATE User REST API",description = "CREATE User REST API is used saved in database")
    @ApiResponse(responseCode = "201",description = "Http Status 201 CREATED")

    @PostMapping
    public ResponseEntity<ResponseUserDto> save(@RequestBody CreateUserDto createUserDto){
        return ResponseEntity.ok(userService.save(createUserDto));

    }

    @Operation(summary = "Retrieve all users")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "List of users retrieved successfully")})
    @GetMapping("/all")
    public ResponseEntity<List<ResponseUserDto>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @Operation(summary = "Update a user by ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @PutMapping("/{id}")
    public ResponseEntity<ResponseUserDto> update(@PathVariable Long id, @RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok(userService.update(id, createUserDto));
    }

    @Operation(summary = "Delete a user by ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "User deleted successfully")})
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("uId") Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
