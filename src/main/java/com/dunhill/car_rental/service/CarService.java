package com.dunhill.car_rental.service;

import com.dunhill.car_rental.Dtos.CreateCarDto;
import com.dunhill.car_rental.Dtos.CreateCategoryDto;
import com.dunhill.car_rental.Dtos.ResponseCarDto;
import com.dunhill.car_rental.Dtos.ResponseCategoryDto;
import com.dunhill.car_rental.Entity.Car;
import com.dunhill.car_rental.Entity.Category;
import com.dunhill.car_rental.Exceptions.NotFoundException;
import com.dunhill.car_rental.mapper.CarMapper;
import com.dunhill.car_rental.repository.CarRepository;
import com.dunhill.car_rental.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class CarService {

    private CarRepository carRepository;
    private CategoryRepository categoryRepository;
    private CarMapper carMapper;

    public ResponseCarDto save(CreateCarDto createCarDto){
        Category category = categoryRepository.findById(createCarDto.getCategoryId())
                .orElseThrow(()->new RuntimeException("Category not found"));
        Car car= carMapper.mapToEntity(createCarDto);
        car.setCategory(category);
        Car savedCar = carRepository.save(car);
        ResponseCarDto responseCarDto = carMapper.mapToDto(savedCar);
        return responseCarDto;
    }

    public List<ResponseCarDto> getAll(){
        return carRepository.findAll().stream().map(carMapper::mapToDto).toList();
    }

    public void delete(long id){
        Car found= carRepository.findById(id).
                orElseThrow(() -> new NotFoundException("cannot find this car!"));
        carRepository.delete(found);
           }

    public ResponseCarDto update(Long id, CreateCarDto dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category  Not Found"));
        Car car = carRepository.findById(id).orElseThrow(()->new RuntimeException("Car not found"));
        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setBodyType(dto.getBodyType());
        car.setManufactureYear(dto.getManufactureYear());
        car.setColour(dto.getColour());
        car.setMileAge(dto.getMileAge());
        car.setStatus(dto.getStatus());
        car.setAmount(dto.getAmount());
        car.setCreatedBy(dto.getCreatedBy());
        car.setUpdatedAt(LocalDateTime.now());
        car.setCategory(category);
        Car savedCar = carRepository.save(car);
        return carMapper.mapToDto(savedCar);
    }

//    public ResponseCarDto update(CreateCarDto createCarDto){
////        Car found= carRepository.findCarByModel(createCarDto.getModel());
////        found=carMapper.update(createCarDto,found);
//
////        return carMapper.mapToDto(carRepository.save(found));
//    }

    public List<ResponseCarDto> search(String brand, String model, String bodyType, LocalDate manufactureYear, String colour, Long mileage, Long amount){
        return carRepository.findByBrandAndModelAndBodyTypeAndManufactureYearAndColourAndMileAgeAndAmount(brand,model,bodyType,manufactureYear,colour,mileage,amount)
                .stream().map(carMapper::mapToDto).toList();

    }
}
