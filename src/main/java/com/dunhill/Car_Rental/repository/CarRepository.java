package com.dunhill.Car_Rental.repository;

import com.dunhill.Car_Rental.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Category,Long> {
    
}
