package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.dtos.reviewDto.CreateReviewDto;
import com.dunhill.car_rental.dtos.reviewDto.ResponseReviewDto;
import com.dunhill.car_rental.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reviews")
@Tag(name = "CRUD REST APIs for Review Resource")
public class ReviewController {

    private final ReviewService reviewService;

    @Operation(summary = "Create Review REST API", description = "Creates a new review for a specific car.")
    @ApiResponse(responseCode = "201", description = "Http Status 201 CREATED")
    @PostMapping("/{id}")
    public ResponseEntity<ResponseReviewDto> createReview(@PathVariable Long id, @Valid @RequestBody CreateReviewDto createReviewDto) {
        ResponseReviewDto review = reviewService.save(id, createReviewDto);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieve All Reviews REST API", description = "Fetches a list of all existing reviews.")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/all")
    public ResponseEntity<List<ResponseReviewDto>> getAllReviews() {
        List<ResponseReviewDto> reviews = reviewService.getAll();
        return ResponseEntity.ok(reviews);
    }

    @Operation(summary = "Retrieve Reviews by Car ID REST API", description = "Fetches reviews associated with a specific car.")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/car/{carId}")
    public ResponseEntity<List<ResponseReviewDto>> getAllByCarId(@PathVariable Long carId) {
        List<ResponseReviewDto> reviews = reviewService.getAllByCarId(carId);
        return ResponseEntity.ok(reviews);
    }

    @Operation(summary = "Find Review by Review ID and Car ID REST API", description = "Fetches a specific review based on its ID and associated car ID.")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @GetMapping("/{reviewId}/car/{carId}")
    public ResponseEntity<ResponseReviewDto> findByReviewIdAndCarId(@PathVariable Long reviewId, @PathVariable Long carId) {
        ResponseReviewDto review = reviewService.findByReviewIdAndCarId(reviewId, carId);
        return ResponseEntity.ok(review);
    }

    @Operation(summary = "Delete Review REST API", description = "Deletes a review by its ID.")
    @ApiResponse(responseCode = "204", description = "Http Status 204 NO CONTENT")
    @DeleteMapping("/{uId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long uId) {
        reviewService.delete(uId);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete Review by Review ID and Car ID REST API", description = "Deletes a specific review associated with a car.")
    @ApiResponse(responseCode = "204", description = "Http Status 204 NO CONTENT")
    @DeleteMapping("/car/{carId}/review/{reviewId}")
    public ResponseEntity<String> deleteByReviewIdAndCarId(@PathVariable Long reviewId, @PathVariable Long carId) {
        reviewService.deleteByCarId(reviewId, carId);
        return new ResponseEntity<>("Review successfully deleted!! :)", HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Update Review REST API", description = "Updates an existing review.")
    @ApiResponse(responseCode = "200", description = "Http Status 200 SUCCESS")
    @PutMapping
    public ResponseEntity<ResponseReviewDto> updateReview(@Valid @RequestBody CreateReviewDto createReviewDto) {
        ResponseReviewDto updatedReview = reviewService.update(createReviewDto);
        return ResponseEntity.ok(updatedReview);
    }
}
