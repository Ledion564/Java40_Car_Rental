package com.dunhill.car_rental.service;

import com.dunhill.car_rental.Dtos.CreateReviewDto;
import com.dunhill.car_rental.Dtos.ResponseReviewDto;
import com.dunhill.car_rental.Entity.Review;
import com.dunhill.car_rental.Exceptions.NotFoundException;
import com.dunhill.car_rental.mapper.ReviewMapper;
import com.dunhill.car_rental.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewService {

    private ReviewRepository reviewRepository;
    private ReviewMapper reviewMapper;

    public ResponseReviewDto save(CreateReviewDto createReviewDto){
        Review review = reviewMapper.mapToEntity(createReviewDto);
        Review saved = reviewRepository.save(review);
        ResponseReviewDto responseReviewDto = reviewMapper.mapToDto(saved);
        return responseReviewDto;
    }

    public List<ResponseReviewDto> getAll(){
        return reviewRepository.findAll().stream().map(reviewMapper::mapToDto).toList();
    }

    public void delete(Long id){
        Review found = reviewRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No review found"));
        reviewRepository.delete(found);
    }

    public ResponseReviewDto update(CreateReviewDto createReviewDto){
        Review review = reviewRepository.findByUsername(createReviewDto.getUsername());
        review = reviewMapper.update(createReviewDto,review);
        return reviewMapper.mapToDto(review);
    }
}
