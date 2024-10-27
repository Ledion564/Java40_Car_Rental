//package com.dunhill.car_rental.injection;
//
//import com.dunhill.car_rental.entity.Category;
//import com.dunhill.car_rental.repository.CategoryRepository;
//import jakarta.annotation.PostConstruct;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//@AllArgsConstructor
//public class CategoryInjection {
//
//    private final CategoryRepository categoryRepository;
//
//    @PostConstruct
//    public void init() {
//        List<Category> categories = Arrays.asList(
//                createCategory("SYSTEM", "SUV", 3, 4.5, "Popular SUV category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
//                createCategory("SYSTEM", "Sedan", 2, 4.0, "Comfortable sedan category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
//                createCategory("SYSTEM", "Coupe", 5, 4.8, "Stylish coupe category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
//                createCategory("SYSTEM", "Hatchback", 1, 4.2, "Compact hatchback category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
//                createCategory("SYSTEM", "Convertible", 2, 4.6, "Luxury convertible category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
//                createCategory("SYSTEM", "Luxury SUV", 5, 4.9, "Premium luxury SUV category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
//                createCategory("SYSTEM", "Pickup Truck", 4, 4.3, "Rugged pickup truck category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
//                createCategory("SYSTEM", "Minivan", 1, 4.0, "Family-friendly minivan category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
//                createCategory("SYSTEM", "Sportscar", 5, 4.7, "High-performance sportscar category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
//                createCategory("SYSTEM", "Electric Vehicle", 3, 4.5, "Eco-friendly electric vehicle category", true, "SYS", LocalDateTime.now(), LocalDateTime.now())
//        );
//
//        for (Category category : categories) {
//            // Check if a category with the same username and categoryType already exists
//            if (!categoryRepository.existsByUsernameAndCategoryType(category.getUsername(), category.getCategoryType())) {
//                categoryRepository.save(category);
//            }
//        }
//    }
//
//    private Category createCategory(String username, String categoryType, int priority, double rating, String description, boolean isActive, String createdBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
//        return Category.builder()
//                .username(username)
//                .categoryType(categoryType)
//                .priority(priority)
//                .rating(rating)
//                .description(description)
//                .isActive(isActive)
//                .createdBy(createdBy)
//                .createdAt(createdAt)
//                .updatedAt(updatedAt)
//                .build();
//    }
//}
