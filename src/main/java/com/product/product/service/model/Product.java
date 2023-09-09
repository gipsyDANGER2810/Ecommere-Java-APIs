package com.product.product.service.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", length = 255)
    private String productId;

    @Column(name = "product_name", columnDefinition = "TEXT")
    private String productName;

    @Column(name = "category", columnDefinition = "TEXT")
    private String category;

    @Column(name = "discounted_price", length = 255)
    private String discountedPrice;

    @Column(name = "actual_price", length = 255)
    private String actualPrice;

    @Column(name = "discount_percentage", length = 255)
    private String discountPercentage;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "rating_count")
    private Long ratingCount;

    @Column(name = "about_product", columnDefinition = "TEXT")
    private String aboutProduct;

    @Column(name = "img_link", columnDefinition = "TEXT")
    private String imgLink;

    @Column(name = "product_link", columnDefinition = "TEXT")
    private String productLink;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}



