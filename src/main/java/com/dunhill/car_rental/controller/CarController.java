package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.Dtos.CreateCarDto;
import com.dunhill.car_rental.Dtos.ResponseCarDto;
import com.dunhill.car_rental.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/car")
@RestController
public class CarController {

    private CarService carService;

    @PostMapping
    public ResponseEntity<ResponseCarDto> save(@RequestBody CreateCarDto createCarDto){
        return ResponseEntity.ok(carService.save(createCarDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseCarDto>> getAll(){
        return ResponseEntity.ok(carService.getAll());
    }
    @PutMapping
    public ResponseEntity<ResponseCarDto> update(@RequestBody CreateCarDto createCarDto){
        return ResponseEntity.ok(carService.update(createCarDto));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("carId")Long id){
        carService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
