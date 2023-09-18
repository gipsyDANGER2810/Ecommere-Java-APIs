package com.product.product.service.repository;

import com.product.product.service.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByCategory(String category);
    @Query("SELECT p FROM Product p WHERE p.category LIKE %:category%")
    Page<Product> findByCategoryLike(String category, Pageable pageable);
}
