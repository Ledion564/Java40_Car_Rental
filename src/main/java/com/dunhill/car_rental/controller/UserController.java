package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.dtos.userDto.CreateUserDto;
import com.dunhill.car_rental.dtos.userDto.ResponseUserDto;
import com.dunhill.car_rental.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@Tag(name = "CRUD REST APIs for User Resource")
public class UserController {

    private UserService userService;

//    @PostMapping
//    public ResponseEntity<ResponseUserDto> save(@RequestBody CreateUserDto createUserDto){
//        return ResponseEntity.ok(userService.save(createUserDto));
//    }

    @Operation(summary = "Retrieve All Users REST API", description = "Fetches a list of all existing users.")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/all")
    public ResponseEntity<List<ResponseUserDto>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @Operation(summary = "Update User REST API", description = "Updates a specific user based on its ID.")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseUserDto> update(@PathVariable Long id, @RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok(userService.update(id, createUserDto));
    }

    @Operation(summary = "Delete User REST API", description = "Deletes a user by their ID.")
    @ApiResponse(responseCode = "204", description = "Http Status 204 NO CONTENT")
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("uId") Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
