package com.dunhill.car_rental.mapper;

import com.dunhill.car_rental.Dtos.CreateReviewDto;
import com.dunhill.car_rental.Dtos.ResponseReviewDto;
import com.dunhill.car_rental.Entity.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public Review mapToEntity(CreateReviewDto createReviewDto){
        Review review = new Review();
        review.setUsername(createReviewDto.getUsername());
        review.setDescription(createReviewDto.getDescription());
        return review;
    }

    public ResponseReviewDto mapToDto(Review review){
        ResponseReviewDto responseReviewDto = new ResponseReviewDto();
        responseReviewDto.setId(review.getId());
        responseReviewDto.setUsername(review.getUsername());
        responseReviewDto.setDescription(review.getDescription());
        return responseReviewDto;
    }

    public Review update(CreateReviewDto createReviewDto, Review review){
        review.setUsername(createReviewDto.getUsername());
        review.setDescription(createReviewDto.getDescription());
        return review;
    }

}
