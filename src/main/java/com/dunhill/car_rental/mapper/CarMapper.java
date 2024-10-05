package com.dunhill.car_rental.mapper;

import com.dunhill.car_rental.Dtos.CreateCarDto;
import com.dunhill.car_rental.Dtos.ResponseCarDto;
import com.dunhill.car_rental.Entity.Car;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CarMapper {
    public Car mapToEntity(CreateCarDto createCarDto){
        Car car= new Car();
        car.setBrand(createCarDto.getBrand());
        car.setModel(createCarDto.getModel());
        car.setBodyType(createCarDto.getBodyType());
        car.setManufactureYear(createCarDto.getManufactureYear());
        car.setColour(createCarDto.getColour());
        car.setMileAge(createCarDto.getMileAge());
        car.setStatus(createCarDto.getStatus());
        car.setAmount(createCarDto.getAmount());
        car.setCreatedAt(LocalDateTime.now());
        car.setCreatedBy(createCarDto.getCreatedBy());
        return car;
    }
    public ResponseCarDto mapToDto(Car car){
        ResponseCarDto responseCarDto=new ResponseCarDto();
        responseCarDto.setId(car.getId());
        responseCarDto.setBrand(car.getBrand());
        responseCarDto.setModel(car.getModel());
        responseCarDto.setBodyType(car.getBodyType());
        responseCarDto.setManufactureYear(car.getManufactureYear());
        responseCarDto.setColour(car.getColour());
        responseCarDto.setMileAge(car.getMileAge());
        responseCarDto.setStatus(car.getStatus());
        responseCarDto.setAmount(car.getAmount());
        responseCarDto.setCreatedAt(car.getCreatedAt());
        responseCarDto.setCreatedBy(car.getCreatedBy());
        responseCarDto.setUpdatedAt(car.getUpdatedAt());
        return responseCarDto;
    }
    public Car update(CreateCarDto dto,Car car){
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
        return car;
    }

}
