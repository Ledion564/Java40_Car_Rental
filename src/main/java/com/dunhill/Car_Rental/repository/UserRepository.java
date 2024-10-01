package com.dunhill.Car_Rental.repository;

import com.dunhill.Car_Rental.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query("select u from UserEntity u where u.username::username")
    UserEntity findByUsername(String username);
}
