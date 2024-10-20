package com.dunhill.car_rental.repository;

import com.dunhill.car_rental.entity.Personel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonelRepository extends JpaRepository<Personel,Long> {
}
