package com.dunhill.car_rental.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

//    @ManyToOne
//    @JoinColumn(name = "rental_id")
//    private Rental rental;
//
//    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
//    private List<Employee> employees;
//
//    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
//    private List<Car> cars;


}
