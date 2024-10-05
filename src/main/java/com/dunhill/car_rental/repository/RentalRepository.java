package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.Entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}