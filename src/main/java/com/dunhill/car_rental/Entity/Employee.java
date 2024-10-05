package com.dunhill.car_rental.Entity;

import com.dunhill.car_rental.Entity.enums.Position;
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
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Position position;  // EMPLOYEE, MANAGER

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @OneToMany(mappedBy = "employee")
    private List<Loan> loans;

    @OneToMany(mappedBy = "employee")
    private List<Refund> refunds;

}

