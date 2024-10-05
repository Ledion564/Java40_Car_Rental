package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Long> {

    @Query("select c from Car c where c.model=:model")
    Car findCarByModel(String model);



}
