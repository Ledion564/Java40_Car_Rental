package com.dunhill.car_rental.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "revenues")
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "approved_amount")
    private double approvedAmount;

    @Column(name = "unapproved_amount")
    private double unapprovedAmount;

    // Methods to calculate and update revenue
}

