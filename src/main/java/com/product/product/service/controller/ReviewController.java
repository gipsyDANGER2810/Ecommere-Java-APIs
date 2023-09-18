package com.product.product.service.controller;

import com.product.product.service.DTO.ReviewDTO;
import com.product.product.service.model.Review;
import com.product.product.service.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
@AllArgsConstructor
@CrossOrigin("*")
public class ReviewController {

    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody ReviewDTO reviewDTO) {
        try {
            Review newReview = reviewService.saveReview(reviewDTO);
            return new ResponseEntity<>(newReview, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
