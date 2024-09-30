package com.dunhill.Car_Rental.repository;

import com.dunhill.Car_Rental.Entity.Car;
import com.dunhill.Car_Rental.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends JpaRepository<Car,Long> {

    @Query("select c from Car c where c.model=:model")
    Car findCarByModel(String model);
}
