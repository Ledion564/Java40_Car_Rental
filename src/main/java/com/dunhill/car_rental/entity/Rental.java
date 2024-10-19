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

public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String internetDomain;
    private String contactAddress;
    private String owner;
    private String logotype;

//    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
//    private List<Branch> branches;


}

