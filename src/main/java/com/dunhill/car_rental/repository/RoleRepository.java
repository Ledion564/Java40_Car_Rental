package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
