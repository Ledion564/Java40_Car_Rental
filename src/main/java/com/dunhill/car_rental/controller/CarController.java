package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.dtos.CreateCarDto;
import com.dunhill.car_rental.dtos.ResponseCarDto;
import com.dunhill.car_rental.service.CarService;
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
public class CarController {

    private CarService carService;
    private PasswordEncoder passwordEncoder;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{password}")
    public ResponseEntity<String> getEncryptPass(@PathVariable String password) {
        return ResponseEntity.ok(passwordEncoder.encode(password));
    }

    @PostMapping
    public ResponseEntity<ResponseCarDto> save(@Valid @RequestBody CreateCarDto createCarDto){
        return ResponseEntity.ok(carService.save(createCarDto));
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/all")
    public ResponseEntity<List<ResponseCarDto>> getAll(){
        return ResponseEntity.ok(carService.getAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
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
