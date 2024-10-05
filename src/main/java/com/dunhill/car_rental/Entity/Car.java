package com.dunhill.car_rental.Entity;

import com.dunhill.car_rental.Entity.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;
    private String model;
    private String bodyType;
    private int year;
    private String color;
    private int mileage;

    @Enumerated(EnumType.STRING)
    private Status status; // BOOKED, AVAILABLE, UNAVAILABLE

    private BigDecimal amountPerDay;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

}
