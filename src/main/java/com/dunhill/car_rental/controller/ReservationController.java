package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.Dtos.CreateReservationDto;
import com.dunhill.car_rental.Dtos.ResponseReservationDto;
import com.dunhill.car_rental.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/reservation")
@RestController
public class ReservationController {
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ResponseReservationDto> save(@RequestBody CreateReservationDto createReservationDto){
        return ResponseEntity.ok(reservationService.save(createReservationDto));
    }
    @GetMapping("/all")
    public ResponseEntity<List<ResponseReservationDto>> getAll(){
        return ResponseEntity.ok(reservationService.getAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseReservationDto> update(@PathVariable Long id, @RequestBody CreateReservationDto updateReservationDto){
        return ResponseEntity.ok(reservationService.update(id, updateReservationDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("reservationId")Long id){
        reservationService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
