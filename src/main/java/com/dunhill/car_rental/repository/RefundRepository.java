package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.Entity.Refund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefundRepository extends JpaRepository<Refund, Long> {
}
