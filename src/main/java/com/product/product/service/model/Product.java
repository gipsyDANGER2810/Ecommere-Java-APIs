package com.product.product.service.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private String product_id;

    @Column(name = "product_name", columnDefinition = "TEXT")
    private String product_name;

    @Column(name = "category", columnDefinition = "TEXT")
    private String category;

    @Column(name = "discounted_price", length = 255)
    private String discounted_price;

    @Column(name = "actual_price", length = 255)
    private String actual_price;

    @Column(name = "discount_percentage", length = 255)
    private String discount_percentage;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "rating_count")
    private Long rating_count;

    @Column(name = "about_product", columnDefinition = "TEXT")
    private String about_product;

    @Column(name = "img_link", columnDefinition = "TEXT")
    private String img_link;

    @Column(name = "product_link", columnDefinition = "TEXT")
    private String product_link;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value="product-review")
    private List<Review> reviews = new ArrayList<>();
}



