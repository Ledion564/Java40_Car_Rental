package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query("select C from Category C where C.name=name")
    Category findByName(String name);

}
