package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.Dtos.CreateCarDto;
import com.dunhill.car_rental.Dtos.CreateCategoryDto;
import com.dunhill.car_rental.Dtos.ResponseCarDto;
import com.dunhill.car_rental.Dtos.ResponseCategoryDto;
import com.dunhill.car_rental.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCarDto> update(@PathVariable Long id, @RequestBody CreateCarDto updateCarDto) {
        return ResponseEntity.ok(carService.update(id, updateCarDto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("carId")Long id){
        carService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ResponseCarDto>> search(@RequestParam(value="brand", required = false) String brand,
                                                       @RequestParam(value="model", required = false) String model,
                                                       @RequestParam(value="bodyType", required = false) String bodyType,
                                                       @RequestParam(value="manufactureYear", required = false) LocalDate manufactureYear,
                                                       @RequestParam(value="colour", required = false) String colour,
                                                       @RequestParam(value="mileAge", required = false) Long mileage,
                                                       @RequestParam(value="amount", required = false) Long amount){
        return ResponseEntity.ok(carService.search(brand,model,bodyType,manufactureYear,colour,mileage,amount));

        
    }
}
