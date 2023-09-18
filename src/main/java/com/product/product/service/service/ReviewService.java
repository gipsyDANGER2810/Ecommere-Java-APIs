package com.product.product.service.service;

import com.product.product.service.DTO.ReviewDTO;
import com.product.product.service.model.Customer;
import com.product.product.service.model.Product;
import com.product.product.service.model.Review;
import com.product.product.service.repository.CustomerRepository;
import com.product.product.service.repository.ProductRepository;
import com.product.product.service.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Review saveReview(ReviewDTO reviewDTO) {
        Review review = new Review();

        // Set the review attributes
        review.setReview_title(reviewDTO.getReviewTitle());
        review.setReview_content(reviewDTO.getReviewContent());

        // Set the relationships
        Product product = productRepository.findById(reviewDTO.getProductId()).orElseThrow(() -> new RuntimeException("Product not found"));
        review.setProduct(product);

        Customer customer = customerRepository.findById(reviewDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        review.setCustomer(customer);

        // Generate a unique ID for the review or use another mechanism
        review.setReview_id(UUID.randomUUID().toString());

        return reviewRepository.save(review);
    }
}
