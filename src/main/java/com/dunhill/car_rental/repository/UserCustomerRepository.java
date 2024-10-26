package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.entity.UserCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserCustomerRepository extends JpaRepository<UserCustomer, Long> {
     List<UserCustomer> findByUserId(Long userId);
     List<UserCustomer> findByCustomerId(Long customerId);
}
