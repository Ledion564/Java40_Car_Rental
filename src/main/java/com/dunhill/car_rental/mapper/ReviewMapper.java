package com.dunhill.car_rental.mapper;

import com.dunhill.car_rental.dtos.reviewDto.CreateReviewDto;
import com.dunhill.car_rental.dtos.reviewDto.ResponseReviewDto;
import com.dunhill.car_rental.entity.Review;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReviewMapper {

    public Review mapToEntity(CreateReviewDto createReviewDto){
        Review review = new Review();
        review.setUsername(createReviewDto.getUsername());
        review.setDescription(createReviewDto.getDescription());
        review.setCreatedBy(createReviewDto.getCreatedBy());
        review.setCreatedAt(LocalDateTime.now());
        return review;
    }

    public ResponseReviewDto mapToDto(Review review){
        ResponseReviewDto responseReviewDto = new ResponseReviewDto();
        responseReviewDto.setId(review.getId());
        responseReviewDto.setUsername(review.getUsername());
        responseReviewDto.setDescription(review.getDescription());
        responseReviewDto.setCreatedBy(review.getCreatedBy());
        responseReviewDto.setCreatedAt(review.getCreatedAt());
        responseReviewDto.setUpdatedAt(review.getUpdatedAt());
        responseReviewDto.setCarId(review.getCar().getId());
        responseReviewDto.setCarName(review.getCar().getBrand());
        return responseReviewDto;
    }

    public Review update(CreateReviewDto createReviewDto, Review review){
        review.setUsername(createReviewDto.getUsername());
        review.setDescription(createReviewDto.getDescription());
        review.setUpdatedAt(LocalDateTime.now());
        review.setCreatedBy(createReviewDto.getCreatedBy());
        return review;
    }

}
