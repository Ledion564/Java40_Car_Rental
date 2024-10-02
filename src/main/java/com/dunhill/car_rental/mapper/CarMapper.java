package com.dunhill.car_rental.mapper;

import com.dunhill.car_rental.Dtos.CreateCarDto;
import com.dunhill.car_rental.Dtos.ResponseCarDto;
import com.dunhill.car_rental.Entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public Car mapToEntity(CreateCarDto createCarDto){
        Car car= new Car();
        car.setBrand(createCarDto.getBrand());
        car.setModel(createCarDto.getModel());
        car.setBodyType(createCarDto.getBodyType());
        car.setYear(createCarDto.getYear());
        car.setColour(createCarDto.getColour());
        car.setMileAge(createCarDto.getMileAge());
        car.setStatus(createCarDto.getStatus());
        car.setAmount(createCarDto.getAmount());
        return car;
    }
    public ResponseCarDto mapToDto(Car car){
        ResponseCarDto responseCarDto=new ResponseCarDto();
        responseCarDto.setId(car.getId());
        responseCarDto.setBrand(car.getBrand());
        responseCarDto.setModel(car.getModel());
        responseCarDto.setBodyType(car.getBodyType());
        responseCarDto.setYear(car.getYear());
        responseCarDto.setColour(car.getColour());
        responseCarDto.setMileAge(car.getMileAge());
        responseCarDto.setStatus(car.getStatus());
        responseCarDto.setAmount(car.getAmount());
        return responseCarDto;
    }
    public Car update(CreateCarDto dto,Car car){
        car.setBrand(dto.getBrand());
        car.setModel(dto.getModel());
        car.setBodyType(dto.getBodyType());
        car.setYear(dto.getYear());
        car.setColour(dto.getColour());
        car.setMileAge(dto.getMileAge());
        car.setStatus(dto.getStatus());
        car.setAmount(dto.getAmount());
        return car;
    }

}
