package com.dunhill.Car_Rental.repository;

import com.dunhill.Car_Rental.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {


    Review findByUsername(String username);
}
