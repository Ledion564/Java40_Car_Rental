package com.dunhill.car_rental.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Role_Name")
    private String roleName;
}
