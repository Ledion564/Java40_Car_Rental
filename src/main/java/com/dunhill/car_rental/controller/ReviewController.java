package com.dunhill.car_rental.controller;

import com.dunhill.car_rental.dtos.CreateReviewDto;
import com.dunhill.car_rental.dtos.ResponseReviewDto;
import com.dunhill.car_rental.service.ReviewService;
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

    @PostMapping("/{id}")
    public ResponseEntity<ResponseReviewDto> save(@PathVariable Long id ,@RequestBody CreateReviewDto createReviewDto){
        return new ResponseEntity<>(reviewService.save(id,createReviewDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ResponseReviewDto>> getAll(){
        return ResponseEntity.ok(reviewService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ResponseReviewDto>> getAllByCarId(@PathVariable Long carId){
        return ResponseEntity.ok(reviewService.getAllByCarId(carId));
    }

    @GetMapping("/{reviewId}/{carId}")
    public ResponseEntity<ResponseReviewDto> findByReviewIdByCarId(@PathVariable("reviewId") Long reviewId,@PathVariable("carId") Long carId){
        return ResponseEntity.ok(reviewService.findByReviewIdAndCarId(reviewId,carId));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestParam("uId") Long id){
        reviewService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{carId}/{reviewId}")
    public ResponseEntity<String> deleteByReviewIdAndCarId(@PathVariable("reviewId") Long reviewId,@PathVariable("carId") Long carId){
        reviewService.deleteByCarId(reviewId,carId);
        return new ResponseEntity<>("Review successfully deleted!! :)",HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<ResponseReviewDto> update(CreateReviewDto createReviewDto){
        return ResponseEntity.ok(reviewService.update(createReviewDto));
    }
}
