package com.dunhill.car_rental.service;

import com.dunhill.car_rental.Dtos.CreateCarDto;
import com.dunhill.car_rental.Dtos.ResponseCarDto;
import com.dunhill.car_rental.Entity.Car;
import com.dunhill.car_rental.Exceptions.NotFoundException;
import com.dunhill.car_rental.mapper.CarMapper;
import com.dunhill.car_rental.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CarService {

    private CarRepository carRepository;
    private CarMapper carMapper;

    public ResponseCarDto save(CreateCarDto createCarDto){
        Car car= carMapper.mapToEntity(createCarDto);
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

    public ResponseCarDto update(CreateCarDto createCarDto){
        Car found= carRepository.findCarByModel(createCarDto.getModel());
        found=carMapper.update(createCarDto,found);

        return carMapper.mapToDto(carRepository.save(found));
    }
}
