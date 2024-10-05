package com.dunhill.car_rental.RepositoryTest;


import com.dunhill.car_rental.Entity.Car;
import com.dunhill.car_rental.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    private Car car;
    private Car car1;
    private Car car2;

    @BeforeEach
    void setup(){
        car = Car.builder().model("benz").colour("black").mileAge(220L).amount(100L).build();
        Car car1 = Car.builder().model("volkswagen").colour("blue").mileAge(200L).brand("golf").id(4L).build();
        Car car2 = Car.builder().model("volkswagen").colour("blue").mileAge(200L).brand("golf").id(5L).build();
    }


    @Test
    public  void testSave(){
       //given
//        Car car = Car.builder().model("benz").colour("black").mileAge(220L).amount(100L).build();

        //action
        Car savedCar = carRepository.save(car);

        //then
        assertThat(savedCar).isNotNull();
        assertThat(savedCar.getId()).isPositive();
        assertThat(savedCar.getModel()).isEqualTo("benz");

    }
    @Test
    public void testGetAll(){
        //given
        Car car = Car.builder().model("volkswagen").colour("blue").mileAge(100L).brand("golf").id(3L).build();
        carRepository.save(car);
        carRepository.save(car1);
        carRepository.save(car2);

        List<Car> found = carRepository.findAll();
        assertThat(found).isNotNull();

    }

    @Test
    public void testGetById(){
//        Car car = Car.builder().id(2L).build();
        carRepository.save(car);
        Car savedCar = carRepository.findById(2L).get();
        assertThat(savedCar).isNotNull();
        assertThat(savedCar.getId()).isPositive();
        assertThat(savedCar.getId()).isEqualTo(2L);
    }

    @Test
    public void testDelete(){
//        Car car = Car.builder().id(6L).build();
        Car savedCar = carRepository.save(car);
        carRepository.delete(savedCar);
        Optional<Car> found = carRepository.findById(savedCar.getId());
        assertThat(found).isNotPresent();
    }


}
