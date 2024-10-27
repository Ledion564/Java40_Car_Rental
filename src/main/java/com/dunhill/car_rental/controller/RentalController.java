package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.dtos.rentalDto.CreateRentalDto;
import com.dunhill.car_rental.dtos.rentalDto.ResponseRentalDto;
import com.dunhill.car_rental.service.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/rentals")
@RestController
@Tag(name = "CRUD REST APIs for Rental Resource")
public class RentalController {

    private final RentalService rentalService;

    @Operation(summary = "Create Rental REST API", description = "Creates a new rental based on the provided rental details.")
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    @PostMapping
    public ResponseEntity<ResponseRentalDto> createRental(@Valid @RequestBody CreateRentalDto createRentalDto) {
        ResponseRentalDto rental = rentalService.save(createRentalDto);
        return new ResponseEntity<>(rental, HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieve All Rentals REST API", description = "Fetches a list of all existing rentals.")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/all")
    public ResponseEntity<List<ResponseRentalDto>> getAllRentals() {
        List<ResponseRentalDto> rentals = rentalService.getAll();
        return ResponseEntity.ok(rentals);
    }

    @Operation(summary = "Update Rental REST API", description = "Updates a specific rental based on its ID.")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseRentalDto> updateRental(@Valid @RequestBody CreateRentalDto createRentalDto, @PathVariable Long id) {
        ResponseRentalDto updatedRental = rentalService.update(createRentalDto, id);
        return ResponseEntity.ok(updatedRental);
    }

    @Operation(summary = "Delete Rental REST API", description = "Deletes a specific rental by its ID.")
    @ApiResponse(responseCode = "204", description = "Http Status 204 NO CONTENT")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable Long id) {
        rentalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
