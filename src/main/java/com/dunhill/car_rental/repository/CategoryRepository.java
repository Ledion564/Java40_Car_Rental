package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("SELECT C FROM Category C WHERE C.username =:username")
    List<Category> findByUsername(String username);
}
