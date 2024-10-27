package com.dunhill.car_rental.injection;

import com.dunhill.car_rental.entity.Car;
import com.dunhill.car_rental.entity.Category;
import com.dunhill.car_rental.repository.CarRepository;
import com.dunhill.car_rental.repository.CategoryRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class DataInjection {

    private final CategoryRepository categoryRepository;
    private final CarRepository carRepository;

    @PostConstruct
    public void init() {
        // Inject Categories
        List<Category> categories = Arrays.asList(
                createCategory("SYSTEM", "SUV", 3, 4.5, "Popular SUV category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
                createCategory("SYSTEM", "Sedan", 2, 4.0, "Comfortable sedan category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
                createCategory("SYSTEM", "Coupe", 5, 4.8, "Stylish coupe category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
                createCategory("SYSTEM", "Hatchback", 1, 4.2, "Compact hatchback category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
                createCategory("SYSTEM", "Convertible", 2, 4.6, "Luxury convertible category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
                createCategory("SYSTEM", "Luxury SUV", 5, 4.9, "Premium luxury SUV category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
                createCategory("SYSTEM", "Pickup Truck", 4, 4.3, "Rugged pickup truck category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
                createCategory("SYSTEM", "Minivan", 1, 4.0, "Family-friendly minivan category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
                createCategory("SYSTEM", "Sportscar", 5, 4.7, "High-performance sportscar category", true, "SYS", LocalDateTime.now(), LocalDateTime.now()),
                createCategory("SYSTEM", "Electric Vehicle", 3, 4.5, "Eco-friendly electric vehicle category", true, "SYS", LocalDateTime.now(), LocalDateTime.now())
        );

        for (Category category : categories) {
            if (!categoryRepository.existsByUsernameAndCategoryType(category.getUsername(), category.getCategoryType())) {
                categoryRepository.save(category);
            }
        }

        // Inject Cars
        List<Car> cars = Arrays.asList(
                createCar("Toyota", "Camry", "Sedan", 2019, "White", 25000, "Available", 45.99, "SYSTEM", 2L),
                createCar("Honda", "Civic", "Sedan", 2020, "Black", 18000, "Available", 42.50, "SYSTEM", 2L),
                createCar("Ford", "Mustang", "Coupe", 2021, "Red", 12000, "Available", 70.00, "SYSTEM", 5L),
                createCar("Chevrolet", "Corvette", "Coupe", 2022, "Blue", 8000, "Available", 85.75, "SYSTEM", 5L),
                createCar("BMW", "X5", "SUV", 2018, "Gray", 30000, "Available", 55.00, "SYSTEM", 3L),
                createCar("Audi", "Q7", "SUV", 2019, "White", 21000, "Available", 60.00, "SYSTEM", 3L),
                createCar("Mercedes", "C-Class", "Sedan", 2020, "Silver", 15000, "Available", 68.00, "SYSTEM", 2L),
                createCar("Jeep", "Wrangler", "SUV", 2021, "Green", 12000, "Available", 62.50, "SYSTEM", 3L),
                createCar("Toyota", "Highlander", "SUV", 2019, "Black", 23000, "Available", 50.00, "SYSTEM", 3L),
                createCar("Mazda", "CX-5", "SUV", 2018, "Blue", 34000, "Available", 48.00, "SYSTEM", 3L)
        );

        for (Car car : cars) {
            if (!carRepository.existsByBrandAndModelAndManufactureYear(car.getBrand(), car.getModel(), car.getManufactureYear())) {
                carRepository.save(car);
                System.out.println("Car saved: " + car.getBrand() + " " + car.getModel());
            } else {
                System.out.println("Car already exists: " + car.getBrand() + " " + car.getModel());
            }
        }
    }

    private Category createCategory(String username, String categoryType, int priority, double rating, String description, boolean isActive, String createdBy, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return Category.builder()
                .username(username)
                .categoryType(categoryType)
                .priority(priority)
                .rating(rating)
                .description(description)
                .isActive(isActive)
                .createdBy(createdBy)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }

    private Car createCar(String brand, String model, String bodyType, int manufactureYear, String colour, long mileage, String status, double amount, String createdBy, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found: " + categoryId));
        return Car.builder()
                .brand(brand)
                .model(model)
                .bodyType(bodyType)
                .manufactureYear(LocalDate.of(manufactureYear, 1, 1))
                .colour(colour)
                .mileAge(mileage)
                .status(status)
                .amount(amount)
                .createdBy(createdBy)
                .category(category)
                .build();
    }
}
