package com.dunhill.Car_Rental.repository;

import com.dunhill.Car_Rental.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
