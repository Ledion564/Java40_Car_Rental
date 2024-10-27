package com.dunhill.car_rental.service;

import com.dunhill.car_rental.dtos.reviewDto.CreateReviewDto;
import com.dunhill.car_rental.dtos.reviewDto.ResponseReviewDto;
import com.dunhill.car_rental.entity.Car;
import com.dunhill.car_rental.entity.Review;
import com.dunhill.car_rental.exceptions.NotFoundException;
import com.dunhill.car_rental.mapper.ReviewMapper;
import com.dunhill.car_rental.repository.CarRepository;
import com.dunhill.car_rental.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {

    private ReviewRepository reviewRepository;
    private CarRepository carRepository;
    private ReviewMapper reviewMapper;

    public ResponseReviewDto save(Long carId, CreateReviewDto createReviewDto){
        Car car = carRepository.findById(carId).orElseThrow(()->new NotFoundException("Car not found"));
        Review review = reviewMapper.mapToEntity(createReviewDto);
        review.setCar(car);
        Review saved = reviewRepository.save(review);
        ResponseReviewDto responseReviewDto = reviewMapper.mapToDto(saved);
        return responseReviewDto;
    }

    public List<ResponseReviewDto> getAll(){
        return reviewRepository.findAll().stream().map(reviewMapper::mapToDto).toList();
    }

    public List<ResponseReviewDto> getAllByCarId(Long carId){
        Car car = carRepository.findById(carId).orElseThrow(()->new NotFoundException("Car not found"));
        List<Review> reviewList = reviewRepository.findByCarId(car.getId());
        List<ResponseReviewDto> listDto = new ArrayList<>();
        for(Review review : reviewList){
            ResponseReviewDto dto = reviewMapper.mapToDto(review);
            listDto.add(dto);
        }
        return listDto;
//        return reviewList.stream().map(reviewMapper::mapToDto).toList();

    }

    public ResponseReviewDto findByReviewIdAndCarId(Long reviewId, Long carId){
        Review review = reviewRepository.findById(reviewId).orElseThrow(()->new NotFoundException("Review not found"));
        Car car = carRepository.findById(carId).orElseThrow(()->new NotFoundException("Car not found"));
        if(review.getCar().getId() != car.getId()){
            throw new RuntimeException("Car doesn't belong to review");
        }else{
           return reviewMapper.mapToDto(review);
        }
    }

    public ResponseReviewDto getById(Long id){
        Review review = reviewRepository.findById(id).orElseThrow(()->new NotFoundException("Review not found"));
        ResponseReviewDto dto = reviewMapper.mapToDto(review);
        return dto;
    }



    public void delete(Long id){
        Review found = reviewRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No review found"));
        reviewRepository.delete(found);
    }

    public void deleteByCarId(Long carId, Long reviewId) {
        Car car = carRepository.findById(carId).orElseThrow(() -> new NotFoundException("Car not found"));
        Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new NotFoundException("Review not found"));
        if (review.getCar().getId() != car.getId()) {
            throw new RuntimeException("Car doesn't belong to review");
        } else {
            reviewRepository.delete(review);
        }
    }

    public ResponseReviewDto updateByCarIDAndReview(CreateReviewDto createReviewDto,Long carId,Long reviewId){
        Car car = carRepository.findById(carId).orElseThrow(() -> new NotFoundException("Car not found"));
        Review review = reviewRepository.findById(reviewId).orElseThrow(()->new NotFoundException("Review not found"));
        if(review.getCar().getId() !=car.getId()) {
            throw new RuntimeException("Car doesn't belong to review");
        }
            review.setUsername(createReviewDto.getUsername());
            review.setDescription(createReviewDto.getDescription());
            review.setUpdatedAt(LocalDateTime.now());
            review.setCar(car);
            review.setId(reviewId);
            Review savedReview = reviewRepository.save(review);


        return reviewMapper.mapToDto(savedReview);
    }

    public ResponseReviewDto update(CreateReviewDto createReviewDto){
        Review review = reviewRepository.findByUsername(createReviewDto.getUsername());
        review = reviewMapper.update(createReviewDto,review);
        return reviewMapper.mapToDto(review);
    }
}
