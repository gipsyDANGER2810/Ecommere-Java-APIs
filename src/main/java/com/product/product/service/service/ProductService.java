package com.product.product.service.service;

import com.product.product.service.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();

    Product getProductById(String id);

    Product updateProduct(Product product, String id);

    void deleteProduct(String id);
}
