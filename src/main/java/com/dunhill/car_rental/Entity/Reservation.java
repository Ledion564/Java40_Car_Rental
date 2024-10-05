package com.dunhill.car_rental.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateOfBooking;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private BigDecimal amount;

//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer;

//    @ManyToOne
//    @JoinColumn(name = "car_id")
//    private Car car;
//
//    @ManyToOne
//    @JoinColumn(name = "pickup_branch_id")
//    private Branch pickupBranch;
//
//    @ManyToOne
//    @JoinColumn(name = "return_branch_id")
//    private Branch returnBranch;
//
//    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
//    private Loan loan;
//
//    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
//    private Refund refund;


}

