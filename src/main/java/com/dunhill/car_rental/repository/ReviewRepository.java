package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    boolean existsByUsernameAndDescription(String username, String description);


    Review findByUsername(String username);

    List<Review> findByCarId(Long carId);

    List<Review> findByCarId(Long carId, Pageable pageable);
}
