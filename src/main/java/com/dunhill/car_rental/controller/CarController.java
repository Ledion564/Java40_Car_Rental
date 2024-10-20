package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.dtos.CreateCarDto;
import com.dunhill.car_rental.dtos.ResponseCarDto;
import com.dunhill.car_rental.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/car")
@RestController
@Tag(name = "CRUD REST APIs for Car Resource")
public class CarController {

    private CarService carService;
    private PasswordEncoder passwordEncoder;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{password}")
    public ResponseEntity<String> getEncryptPass(@PathVariable String password) {
        return ResponseEntity.ok(passwordEncoder.encode(password));
    }

    @Operation(summary = "Create Car REST API", description = "Create car REST API is used to save cars into database")
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    @PostMapping
    public ResponseEntity<ResponseCarDto> save(@Valid @RequestBody CreateCarDto createCarDto) {
        return new ResponseEntity<> (carService.save(createCarDto),HttpStatus.CREATED);
    }

    @Operation(summary = "Find All Cars REST API", description = "Find All Cars REST API is used to fetch all the cars from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @PreAuthorize("hasRole('ADMIN')")
    @SecurityRequirement(name = "basicAuth")
    @GetMapping("/all")
    public ResponseEntity<List<ResponseCarDto>> getAll() {
        return ResponseEntity.ok(carService.getAll());
    }

    @Operation(summary = "update Car REST API", description = "Update Car REST API is used to update a particular car in the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseCarDto> update(@PathVariable Long id, @RequestBody CreateCarDto updateCarDto) {
        return ResponseEntity.ok(carService.update(id, updateCarDto));
    }


    @Operation(summary = "Delete Car REST API", description = "Delete Car REST API is used to delete a particular car from the database")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("carId") Long id) {
        carService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @Operation(summary = "Search Car REST API", description = "Search Car REST API is used to search cars based on the query")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/filter")
    public ResponseEntity<List<ResponseCarDto>> search(@RequestParam(value = "brand", required = false) String brand, @RequestParam(value = "model", required = false) String model, @RequestParam(value = "bodyType", required = false) String bodyType, @RequestParam(value = "manufactureYear", required = false) LocalDate manufactureYear, @RequestParam(value = "colour", required = false) String colour, @RequestParam(value = "mileAge", required = false) Long mileage, @RequestParam(value = "amount", required = false) Long amount) {
        return ResponseEntity.ok(carService.search(brand, model, bodyType, manufactureYear, colour, mileage, amount));


    }
}
