package com.dunhill.car_rental.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "personels")
public class Personel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personel_id")
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String address;
}
