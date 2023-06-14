package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services;



import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.dto.ReviewDTO;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Review;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.repositories.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
    }

    public Review convertReviewDTOToReview(ReviewDTO reviewDTO){
        return modelMapper.map(reviewDTO, Review.class);
    }

    public ReviewDTO convertReviewToReviewDTO(Review review){
        return modelMapper.map(review, ReviewDTO.class);
    }



}
