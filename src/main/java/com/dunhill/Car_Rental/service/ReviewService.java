package com.dunhill.Car_Rental.service;

import com.dunhill.Car_Rental.Dtos.CreateReviewDto;
import com.dunhill.Car_Rental.Dtos.CreateUserDto;
import com.dunhill.Car_Rental.Dtos.ResponseReviewDto;
import com.dunhill.Car_Rental.Entity.Review;
import com.dunhill.Car_Rental.Exceptions.NotFoundException;
import com.dunhill.Car_Rental.mapper.ReviewMapper;
import com.dunhill.Car_Rental.repository.ReviewRepository;
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
