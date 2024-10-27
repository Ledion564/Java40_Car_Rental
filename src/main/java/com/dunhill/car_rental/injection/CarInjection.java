//package com.dunhill.car_rental.injection;
//
//import com.dunhill.car_rental.entity.Car;
//import com.dunhill.car_rental.entity.Category;
//import com.dunhill.car_rental.repository.CarRepository;
//import com.dunhill.car_rental.repository.CategoryRepository;
//import jakarta.annotation.PostConstruct;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//@AllArgsConstructor
//public class CarInjection {
//
//    private final CarRepository carRepository;
//    private final CategoryRepository categoryRepository;
//
//    @PostConstruct
//    public void init() {
//        List<Car> cars = Arrays.asList(
//                createCar("Toyota", "Camry", "Sedan", 2019, "White", 25000, "Available", 45.99, "SYSTEM", 2L),
//                createCar("Honda", "Civic", "Sedan", 2020, "Black", 18000, "Available", 42.50, "SYSTEM", 2L),
//                createCar("Ford", "Mustang", "Coupe", 2021, "Red", 12000, "Available", 70.00, "SYSTEM", 5L),
//                createCar("Chevrolet", "Corvette", "Coupe", 2022, "Blue", 8000, "Available", 85.75, "SYSTEM", 5L),
//                createCar("BMW", "X5", "SUV", 2018, "Gray", 30000, "Available", 55.00, "SYSTEM", 3L),
//                createCar("Audi", "Q7", "SUV", 2019, "White", 21000, "Available", 60.00, "SYSTEM", 3L),
//                createCar("Mercedes", "C-Class", "Sedan", 2020, "Silver", 15000, "Available", 68.00, "SYSTEM", 2L),
//                createCar("Jeep", "Wrangler", "SUV", 2021, "Green", 12000, "Available", 62.50, "SYSTEM", 3L),
//                createCar("Toyota", "Highlander", "SUV", 2019, "Black", 23000, "Available", 50.00, "SYSTEM", 3L),
//                createCar("Mazda", "CX-5", "SUV", 2018, "Blue", 34000, "Available", 48.00, "SYSTEM", 3L),
//                createCar("Porsche", "911", "Coupe", 2021, "Red", 5000, "Available", 100.00, "SYSTEM", 5L),
//                createCar("Subaru", "Outback", "SUV", 2020, "Brown", 19000, "Available", 52.00, "SYSTEM", 3L),
//                createCar("Volkswagen", "Golf", "Hatchback", 2018, "White", 25000, "Available", 43.00, "SYSTEM", 1L),
//                createCar("Hyundai", "Elantra", "Sedan", 2019, "Silver", 22000, "Available", 40.00, "SYSTEM", 2L),
//                createCar("Tesla", "Model S", "Sedan", 2021, "Black", 7000, "Available", 95.00, "SYSTEM", 2L),
//                createCar("Nissan", "Altima", "Sedan", 2019, "Blue", 27000, "Available", 46.00, "SYSTEM", 2L),
//                createCar("Volvo", "XC90", "SUV", 2020, "Gray", 21000, "Available", 65.00, "SYSTEM", 3L),
//                createCar("Kia", "Sorento", "SUV", 2021, "Green", 15000, "Available", 58.00, "SYSTEM", 3L),
//                createCar("Ferrari", "488", "Coupe", 2021, "Yellow", 4000, "Available", 120.00, "SYSTEM", 5L),
//                createCar("Lexus", "RX", "SUV", 2022, "White", 5000, "Available", 70.00, "SYSTEM", 3L)
//        );
//
//        for (Car car : cars) {
//            if (!carRepository.existsByBrandAndModelAndManufactureYear(car.getBrand(), car.getModel(), car.getManufactureYear())) {
//                carRepository.save(car);
//                System.out.println("Car saved: " + car.getBrand() + " " + car.getModel());
//            } else {
//                System.out.println("Car already exists: " + car.getBrand() + " " + car.getModel());
//            }
//        }
//    }
//
//    private Car createCar(String brand, String model, String bodyType, int manufactureYear, String colour, long mileage, String status, double amount, String createdBy, Long categoryId) {
//        Category category = categoryRepository.findById(categoryId)
//                .orElseThrow(() -> new RuntimeException("Category not found: " + categoryId));
//        return Car.builder()
//                .brand(brand)
//                .model(model)
//                .bodyType(bodyType)
//                .manufactureYear(LocalDate.of(manufactureYear, 1, 1))
//                .colour(colour)
//                .mileAge(mileage)
//                .status(status)
//                .amount(amount)
//                .createdBy(createdBy)
//                .category(category)
//                .build();
//    }
//}
