package com.product.product.service.service.impl;

import com.product.product.service.exception.ResourceNotFoundException;
import com.product.product.service.model.Product;
import com.product.product.service.repository.ProductRepository;
import com.product.product.service.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;


    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
//        Optional<Product> product = productRepository.findById(id);
//        if(product.isPresent()){
//            return product.get();
//        }else{
//            throw new ResourceNotFoundException("Product","Id", id);
//        }

        return   productRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Product","Id",id));
    }

    @Override
    public Product updateProduct(Product product, String id) {
        return null;
    }

//    @Override
//    public Product updateProduct(Product product, String id) {
//        Product existingProduct = productRepository.findById(id).orElseThrow(()
//                -> new ResourceNotFoundException("Product","Id",id));
//        existingProduct.setName(product.getName());
//        existingProduct.setDescription(product.getDescription());
//        productRepository.save(existingProduct);
//
//
//        return existingProduct;
//    }

    @Override
    public void deleteProduct(String id) {
        productRepository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Product","Id",id));
        productRepository.deleteById(id);
    }
}