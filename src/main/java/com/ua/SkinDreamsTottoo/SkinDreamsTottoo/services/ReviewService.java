package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services;



import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.dto.ReviewDTO;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Review;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.repositories.ReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, ModelMapper modelMapper) {
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
    }

    public Page<Review> findAllReview(Pageable pageable){
        log.info("Found all the Review");
        return reviewRepository.findAll(pageable);

    }

    public List<Review> findReviewByMasterId(long id){
        return reviewRepository.findAllByMasterId(id);
    }

    @Transactional
    public Review saveReview(Review review){
        log.info("Save review");
        return reviewRepository.save(review);
    }

    @Transactional
    public void deleteReviewById(long id){
        log.info("Delete review");
        reviewRepository.deleteById(id);
    }

    @Transactional
    public Review updateReview(Review updatingReview){
        log.info("Review Client");
        return reviewRepository.save(updatingReview);
    }




    public Review convertReviewDTOToReview(ReviewDTO reviewDTO){
        return modelMapper.map(reviewDTO, Review.class);
    }

    public ReviewDTO convertReviewToReviewDTO(Review review){
        return modelMapper.map(review, ReviewDTO.class);
    }



}
