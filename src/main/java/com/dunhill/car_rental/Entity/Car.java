package com.dunhill.car_rental.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Brand")
    private String brand;
    @Column(name = "Model")
    private String model;
    @Column(name = "Body_Type")
    private String bodyType;
    @Column(name = "Year")
    private LocalDate year;
    @Column(name = "Colour")
    private String colour;
    @Column(name = "Mileage")
    private long mileAge;
    @Column(name = "Status")
    private String status;
    @Column(name = "Amount")
    private long amount;
}