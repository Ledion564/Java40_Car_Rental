package com.dunhill.car_rental.injection;

import com.dunhill.car_rental.entity.Car;
import com.dunhill.car_rental.entity.Review;
import com.dunhill.car_rental.repository.CarRepository;
import com.dunhill.car_rental.repository.ReviewRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewInjection {

    private final ReviewRepository reviewRepository;
    private final CarRepository carRepository;
    private final List<Review> reviewList = new ArrayList<>();

    @PostConstruct
    public void init() {
        // Create reviews for cars
        populateReviews();
        saveReviews();
    }

    private void populateReviews() {
        // Fetch all cars to create reviews for them
        List<Car> cars = carRepository.findAll();

        for (Car car : cars) {
            // Creating 3 unique reviews for each car
            reviewList.add(createReview("JohnDoe", "Amazing performance and comfort!", "Admin", car));
            reviewList.add(createReview("JaneSmith", "Good value for money, highly recommend!", "Admin", car));
            reviewList.add(createReview("User123", "Had a great experience, will rent again!", "Admin", car));

            // Additional unique reviews
            reviewList.add(createReview("Alice", "Sleek design and very efficient!", "Admin", car));
            reviewList.add(createReview("Bob", "Not the best fuel efficiency, but fun to drive!", "Admin", car));
            reviewList.add(createReview("Charlie", "Perfect for family trips, spacious and comfortable!", "Admin", car));

            // More variations
            reviewList.add(createReview("David", "Top-notch service, the car was spotless!", "Admin", car));
            reviewList.add(createReview("Eva", "Loved the ride quality, very smooth!", "Admin", car));
            reviewList.add(createReview("Frank", "Great car for city driving, easy to park!", "Admin", car));
            reviewList.add(createReview("Grace", "Reliable and efficient, just what I needed!", "Admin", car));

            // Even more reviews to reach 60 total
            reviewList.add(createReview("Hank", "The tech features were impressive!", "Admin", car));
            reviewList.add(createReview("Ivy", "Not enough trunk space for my needs.", "Admin", car));
            reviewList.add(createReview("Jack", "Great experience overall, no complaints!", "Admin", car));
            reviewList.add(createReview("Karen", "Customer service was very helpful!", "Admin", car));
            reviewList.add(createReview("Leo", "I would rent this again in a heartbeat!", "Admin", car));
            reviewList.add(createReview("Mallory", "Perfect car for long road trips!", "Admin", car));
            reviewList.add(createReview("Nina", "Had a little trouble with the GPS, but overall good!", "Admin", car));
            reviewList.add(createReview("Oscar", "Fuel efficiency could be better, but still a great car!", "Admin", car));
            reviewList.add(createReview("Paul", "Smooth handling and responsive steering!", "Admin", car));
            reviewList.add(createReview("Quinn", "A bit pricey, but worth it for the comfort!", "Admin", car));
            reviewList.add(createReview("Rita", "Great for families, lots of room!", "Admin", car));
            reviewList.add(createReview("Steve", "Perfect for weekend getaways!", "Admin", car));
            reviewList.add(createReview("Tina", "The safety features gave me peace of mind!", "Admin", car));
            reviewList.add(createReview("Uma", "Really enjoyed the sunroof feature!", "Admin", car));
            reviewList.add(createReview("Vince", "Awesome ride, but could use a few more horsepower!", "Admin", car));
            reviewList.add(createReview("Will", "The car was well-maintained, very clean!", "Admin", car));
            reviewList.add(createReview("Xena", "Overall a very good experience!", "Admin", car));
            reviewList.add(createReview("Yara", "The pickup and drop-off process was easy!", "Admin", car));
            reviewList.add(createReview("Zack", "Loved the Bluetooth connectivity!", "Admin", car));
        }
    }

    private Review createReview(String username, String description, String createdBy, Car car) {
        return Review.builder()
                .username(username)
                .description(description)
                .createdBy(createdBy)
                .car(car)
                .build();
    }

    private void saveReviews() {
        for (Review review : reviewList) {
            // Avoid duplicates based on your logic (e.g., username and description)
            if (!reviewRepository.existsByUsernameAndDescription(review.getUsername(), review.getDescription())) {
                reviewRepository.save(review);
            }
        }
    }
}
