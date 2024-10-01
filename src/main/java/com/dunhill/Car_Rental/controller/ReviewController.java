package com.dunhill.Car_Rental.controller;

import com.dunhill.Car_Rental.Dtos.CreateReviewDto;
import com.dunhill.Car_Rental.Dtos.ResponseReviewDto;
import com.dunhill.Car_Rental.repository.ReviewRepository;
import com.dunhill.Car_Rental.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ResponseReviewDto> save(@RequestBody CreateReviewDto createReviewDto){
        return ResponseEntity.ok(reviewService.save(createReviewDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseReviewDto>> getAll(){
        return ResponseEntity.ok(reviewService.getAll());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("uId") Long id){
        reviewService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ResponseReviewDto> update(CreateReviewDto createReviewDto){
        return ResponseEntity.ok(reviewService.update(createReviewDto));
    }
}
