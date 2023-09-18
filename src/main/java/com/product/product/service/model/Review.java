package com.product.product.service.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "product_reviews")
public class Review {
    @Id
    @Column(length = 50)
    private String review_id;

    @Column(length = 255)
    private String review_title;

    @Column(columnDefinition = "LONGTEXT")
    private String review_content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    @JsonBackReference(value="product-review")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference(value="user-review")
    private Customer customer;
    // getters, setters, etc.

    public void setReviewTitle(){
        this.review_title = review_title;
    }

    @Override
    public String toString() {
        return
                "reviewId='" + review_id + '\'' +
                        ", UserID='" + (customer != null ? customer.getUserId() : "N/A") + '\'' +
                        ", ProductID='" + (product != null ? product.getProduct_id() : "N/A") + '\'' +  // safely access the product ID
                        ", reviewTitle='" + review_title + '\'' +
                        ", reviewContent='" + review_content + '\'';
    }


}
