package com.product.product.service.DTO;

import lombok.Data;

@Data
public class ReviewDTO {

    private String reviewId;
    private String userId;
    private String productId;
    private String reviewTitle;
    private String reviewContent;

    // Default constructor
    public ReviewDTO() {}

    // Parameterized constructor
    public ReviewDTO(String reviewId, String userId, String productId, String reviewTitle, String reviewContent) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.productId = productId;
        this.reviewTitle = reviewTitle;
        this.reviewContent = reviewContent;
    }

    // Getters and setters

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "reviewId='" + reviewId + '\'' +
                ", userId='" + userId + '\'' +
                ", productId='" + productId + '\'' +
                ", reviewTitle='" + reviewTitle + '\'' +
                ", reviewContent='" + reviewContent + '\'' +
                '}';
    }
}

