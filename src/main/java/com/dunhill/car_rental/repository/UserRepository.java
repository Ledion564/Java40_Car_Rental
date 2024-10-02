package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
