package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.dtos.CreateRentalDto;
import com.dunhill.car_rental.dtos.ResponseRentalDto;
import com.dunhill.car_rental.service.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/rental")
@RestController
public class RentalController {

    private RentalService rentalService;

    @PostMapping
    public ResponseEntity<ResponseRentalDto> save(@RequestBody CreateRentalDto createRentalDto) {
        return ResponseEntity.ok(rentalService.save(createRentalDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseRentalDto>> getAll() {
        return ResponseEntity.ok(rentalService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseRentalDto> update(@RequestBody CreateRentalDto createRentalDto, @PathVariable Long id) {
        return ResponseEntity.ok(rentalService.update(createRentalDto, id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("rentalId") Long id) {
        rentalService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
