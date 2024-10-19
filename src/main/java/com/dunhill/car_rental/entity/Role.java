package com.dunhill.car_rental.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="role_id")
    private Long roleId;

    @NotNull(message = "Role cannot be null")
    @Length(min = 1, max = 64, message = "the length of the role should be between 1-64 characters")
    @Column(name = "role")
    private String role;

}
