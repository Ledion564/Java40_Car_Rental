package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
