package com.product.product.service.DTO;

import com.product.product.service.model.Customer;
import com.product.product.service.model.Review;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CustomerDTO {



        private String userId;
        private String username;
        private List<ReviewDTO> reviews;

        // ... other fields you might need

        // getters, setters, and default constructor

        public CustomerDTO(String userId, String username, List<ReviewDTO> reviews) {
            this.userId = userId;
            this.username = username;
            this.reviews = reviews;

        }

    public static ReviewDTO toReviewDTO(Review review) {
        return new ReviewDTO(
                review.getReview_id(),
                review.getCustomer().getUserId(),
                review.getProduct().getProduct_id(),
                review.getReview_title(),
                review.getReview_content()
        );
    }

    // Convert Customer to CustomerDTO
    public static CustomerDTO fromEntity(Customer customer) {
        return new CustomerDTO(customer.getUserId(), customer.getUsername(), customer.getReviews().stream().map(CustomerDTO::toReviewDTO).collect(Collectors.toList()));
        }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", reviews=" + reviews +
                '}';
    }

}

