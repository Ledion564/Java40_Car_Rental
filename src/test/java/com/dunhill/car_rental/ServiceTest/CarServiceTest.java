package com.dunhill.car_rental.ServiceTest;

import com.dunhill.car_rental.Dtos.CreateCarDto;
import com.dunhill.car_rental.Dtos.ResponseCarDto;
import com.dunhill.car_rental.Entity.Car;
import com.dunhill.car_rental.mapper.CarMapper;
import com.dunhill.car_rental.repository.CarRepository;
import com.dunhill.car_rental.service.CarService;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @Mock
    private CarMapper carMapper;

    @InjectMocks
    private CarService carService;

    private ResponseCarDto responseCarDto;
    private CreateCarDto createCarDto;
    private Car car;

    @BeforeEach
    void setup(){
        car = Car.builder().model("benz").bodyType("hatchback").manufactureYear(LocalDate.of(1997,10,10)).colour("black").mileAge(220L).brand("bclass").amount(100L).build();
        responseCarDto = ResponseCarDto.builder().model("benz").bodyType("hatchback").manufactureYear(LocalDate.of(1997,10,10)).colour("black").mileAge(220L).brand("bclass").amount(100L).build();
        createCarDto = CreateCarDto.builder().model("benz").bodyType("hatchback").manufactureYear(LocalDate.of(1997,10,10)).colour("black").mileAge(220L).brand("bclass").amount(100L).build();
    }


    @Test
    public void save(){
        when(carMapper.mapToEntity(any(CreateCarDto.class))).thenReturn(car);
        when(carRepository.save(any(Car.class))).thenReturn(car);
        when(carMapper.mapToDto(any(Car.class))).thenReturn(responseCarDto);

        carService.save(createCarDto);
//        assertThat(saved).isNotNull();

        verify(carRepository).save(car);
    }

    @Test
    public void delete(){

        when(carRepository.findById(car.getId())).thenReturn(Optional.of(car));
        carService.delete(car.getId());
        verify(carRepository).delete(car);
    }


}
