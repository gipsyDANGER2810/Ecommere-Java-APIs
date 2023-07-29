package com.product.product.service.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="amazon_products")
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 255)
    private String product_id;

    @Column(columnDefinition="TEXT")
    private String product_name;

    @Column(columnDefinition="TEXT")
    private String category;

    @Column(length = 255)
    private String discounted_price;

    @Column(length = 255)
    private String actual_price;

    @Column(length = 255)
    private String discount_percentage;


    private float rating;

    @Column(columnDefinition = "bigint")
    private Long rating_count;

    @Column(columnDefinition="TEXT")
    private String about_product;

    @Column(columnDefinition="TEXT")
    private String user_id;

    @Column(columnDefinition="TEXT")
    private String user_name;

    @Column(columnDefinition="TEXT")
    private String review_id;

    @Column(columnDefinition="TEXT")
    private String review_title;

    @Column(columnDefinition="TEXT")
    private String review_content;

    @Column(columnDefinition="TEXT")
    private String img_link;

    @Column(columnDefinition="TEXT")
    private String product_link;
}



