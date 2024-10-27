package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.dtos.resevationDto.CreateReservationDto;
import com.dunhill.car_rental.dtos.resevationDto.ResponseReservationDto;
import com.dunhill.car_rental.service.ReservationService;
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
@RequestMapping("/api/reservations")
@RestController
@Tag(name = "CRUD REST APIs for Reservation Resource")
public class ReservationController {
    private final ReservationService reservationService;

    @Operation(summary = "Create Reservation REST API", description = "Creates a new reservation based on the provided reservation details.")
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    @PostMapping
    public ResponseEntity<ResponseReservationDto> createReservation(@Valid @RequestBody CreateReservationDto createReservationDto) {
        ResponseReservationDto reservation = reservationService.save(createReservationDto);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieve All Reservations REST API", description = "Fetches a list of all existing reservations.")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/all")
    public ResponseEntity<List<ResponseReservationDto>> getAllReservations() {
        List<ResponseReservationDto> reservations = reservationService.getAll();
        return ResponseEntity.ok(reservations);
    }

    @Operation(summary = "Update Reservation REST API", description = "Updates a specific reservation based on its ID.")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @PutMapping("/{id}")
    public ResponseEntity<ResponseReservationDto> updateReservation(@PathVariable Long id, @Valid @RequestBody CreateReservationDto updateReservationDto) {
        ResponseReservationDto updatedReservation = reservationService.update(id, updateReservationDto);
        return ResponseEntity.ok(updatedReservation);
    }

    @Operation(summary = "Delete Reservation REST API", description = "Deletes a specific reservation by its ID.")
    @ApiResponse(responseCode = "204", description = "Http Status 204 NO CONTENT")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
