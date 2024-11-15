package com.dunhill.car_rental.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    private String firstName;
    private String lastName;
    private String phone;
    private String address;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private List<Reservation> reservations;

 }
