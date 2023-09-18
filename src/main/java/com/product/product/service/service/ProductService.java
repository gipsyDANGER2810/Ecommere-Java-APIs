package com.product.product.service.service;

import com.product.product.service.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    List<Product> getAllProducts();
    Page<Product> findByCategory(String category, Pageable pageable);
    Product getProductById(String id);

    Product updateProduct(Product product, String id);

    void deleteProduct(String id);

    Page<Product> findAllProducts(Pageable pageable);

    List<Product> getProductsbyId(List<String> productIds);


}
