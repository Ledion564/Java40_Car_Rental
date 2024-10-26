package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.entity.OrderCars;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderCarRepository extends JpaRepository<OrderCars,Long> {

    List<OrderCars> findByOrderId(Long orderId);
}
