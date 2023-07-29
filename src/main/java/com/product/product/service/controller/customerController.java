package com.product.product.service.controller;

import com.product.product.service.model.Customer;
import com.product.product.service.model.Product;
import com.product.product.service.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class customerController {

 private CustomerService customerService;
 @PostMapping
 @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Customer> createProduct(@RequestBody Customer customer){
        return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers(){
     return customerService.getAllCustomer();
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getProductById(@PathVariable("id") long id){
        return new ResponseEntity<Customer>(customerService.getCustomerById(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer){
        return new ResponseEntity<Customer>(customerService.updateCustomer(customer,id),HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<String>("Customer Delete Successfully", HttpStatus.OK);
    }
}
