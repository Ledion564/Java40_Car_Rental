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

public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String internetDomain;
    private String contactAddress;
    private String owner;
    private String logotype;

    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL)
    private List<Branch> branches;


}

