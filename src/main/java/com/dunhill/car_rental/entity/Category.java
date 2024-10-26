package com.dunhill.car_rental.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private long id;

    @NotNull(message = "Username can't be null!")
    @Length(min = 1, max = 30, message = "Username length should be between 1-30")
    @Column(name = "user_name")
    private String username;

    @Length(max = 500, message = "Description too long!")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Category type can't be null!")
    @Length(min = 1, max = 30, message = "Category type length should be between 1-30")
    @Column(name = "category_type")
    private String categoryType;

    @Min(value = 0, message = "Priorty must be at least 0")
    @Column(name = "priority")
    private int priority;

    @DecimalMin(value = "0.0", message = "Rating can't be under 0!")
    @DecimalMax(value = "5.0", message = "Rating can't be over 5!")
    @Column(name = "rating")
    private double rating;

    @Length(max = 65, message = "Length is too long!")
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "code")
    private String code;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Car> car;
}
