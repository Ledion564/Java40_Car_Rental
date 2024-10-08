package com.dunhill.car_rental.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Total_Amount")
    private BigDecimal totalAmount;

    @Column(name = "Approved_Amount")
    private BigDecimal approvedAmount;

    @Column(name = "Unapproved_Amount")
    private BigDecimal unapprovedAmount;

    // Methods to calculate and update revenue
}

