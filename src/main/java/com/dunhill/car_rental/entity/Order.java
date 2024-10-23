package com.dunhill.car_rental.entity;

import com.dunhill.car_rental.entity.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name ="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long orderId;

    @Column(name="order_date")
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name="order_status")
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;


    @JsonManagedReference
    @OneToMany(mappedBy = "order",orphanRemoval = true,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<OrderCars> orderCars;

}
