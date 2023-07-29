package com.product.product.service.controller;

import com.product.product.service.model.Product;
import com.product.product.service.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.product.product.service.model.recommender;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class productController {
    private ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.saveProduct(product),HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProduct(){
        String name = "water";
        String suggestion =recommender.getRecommendation(name);
        System.out.print(suggestion);
        return productService.getAllProducts();
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") String id){
        return new ResponseEntity<Product>(productService.getProductById(id),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
        return new ResponseEntity<Product>(productService.updateProduct(product,id),HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") String id){
        productService.deleteProduct(id);
        return new ResponseEntity<String>("Product Delete Successfully", HttpStatus.OK);
    }
}
