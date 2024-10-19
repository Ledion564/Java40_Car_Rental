package com.dunhill.car_rental.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

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

    @NotBlank(message = "Address cannot be blank")
    @Size(max = 255, message = "Address cannot exceed 255 characters")
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
