package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {


    Review findByUsername(String username);
}
