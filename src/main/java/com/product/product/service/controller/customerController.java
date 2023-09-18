package com.product.product.service.controller;

import com.product.product.service.DTO.CustomerDTO;
import com.product.product.service.exception.ResourceNotFoundException;
import com.product.product.service.model.Customer;
import com.product.product.service.model.Product;
import com.product.product.service.repository.CustomerRepository;
import com.product.product.service.service.CustomerService;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
@CrossOrigin("*")
public class customerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers(){
     return customerService.getAllCustomer();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") String id) {
        try {
            Customer customer = customerService.getCustomerById(id);
            return new ResponseEntity<>(CustomerDTO.fromEntity(customer), HttpStatus.OK);
        } catch (ResourceNotFoundException ex) {
            Optional<Customer> customer = customerRepository.findById(id);
            if (!customer.isPresent()) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }else{return ResponseEntity.ok(customer.get());
            }
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer){
        return new ResponseEntity<Customer>(customerService.updateCustomer(customer,id),HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") String id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<String>("Customer Delete Successfully", HttpStatus.OK);
    }
}
