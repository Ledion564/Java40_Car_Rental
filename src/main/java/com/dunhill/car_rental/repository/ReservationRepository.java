package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
