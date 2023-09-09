package com.product.product.service.controller;

import com.product.product.service.DTO.CustomerDTO;
import com.product.product.service.model.Customer;
import com.product.product.service.model.Product;
import com.product.product.service.service.CustomerService;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
@CrossOrigin("*")
public class customerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers(){
     return customerService.getAllCustomer();
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") String id) {
        Customer customer = customerService.getCustomerById(id);

//        // Using a logger for better logging practices
//        LoggerFactory.getLogger(customerController.class).info("Customer received: " + (customer != null ? customer.toString() : "null"));

        if (customer != null) {
//            System.out.println(CustomerDTO.fromEntity(customer));
            return new ResponseEntity<>(CustomerDTO.fromEntity(customer), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
