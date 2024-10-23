package com.dunhill.car_rental.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders_cars")
public class OrderCars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_car_id")
    private Long orderCarId;

    @ManyToOne
    @JoinColumn(name="name_id")
    private Car car;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @Column(name="quantity")
    private int quantity;
}
