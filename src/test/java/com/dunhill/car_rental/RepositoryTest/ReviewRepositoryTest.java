package com.dunhill.car_rental.RepositoryTest;

import com.dunhill.car_rental.entity.Review;
import com.dunhill.car_rental.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    private Review review;

    @BeforeEach
    void setUp() {
        review = Review.builder().id(1L).username("ledion")
                .description("shum makin e mir")
                .createdAt(LocalDateTime.now()).build();
    }

    @Test
    public void testSave() {
        Review saved = reviewRepository.save(review);
        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isPositive();
    }




    @Test
    public void testGetAll() {
       Review savedReview = reviewRepository.save(review);
        List<Review> found = reviewRepository.findAll();
        assertThat(found).isNotNull();
    }
}
