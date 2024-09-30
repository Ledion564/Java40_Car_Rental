package com.dunhill.Car_Rental.service;

import com.dunhill.Car_Rental.Dtos.CreateCarDto;
import com.dunhill.Car_Rental.Dtos.ResponseCarDto;
import com.dunhill.Car_Rental.Entity.Car;
import com.dunhill.Car_Rental.Exceptions.NotFoundException;
import com.dunhill.Car_Rental.mapper.CarMapper;
import com.dunhill.Car_Rental.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
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
           }

    public ResponseCarDto update(CreateCarDto createCarDto){
        Car found= carRepository.findCarByModel(createCarDto.getModel());
        found=carMapper.update(createCarDto,found);

        return carMapper.mapToDto(carRepository.save(found));
    }
}
