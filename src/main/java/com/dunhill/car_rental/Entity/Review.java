package com.dunhill.car_rental.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Review")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="Username")
    private String username;

    @Column(name = "Description")
    private String description;
}
