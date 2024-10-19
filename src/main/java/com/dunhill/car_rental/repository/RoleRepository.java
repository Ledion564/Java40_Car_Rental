package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
   Optional<Role> findByRole(String name);
}
