package com.product.product.service.controller;

import com.product.product.service.model.Customer;
import com.product.product.service.model.LoginDTO;
import com.product.product.service.service.AuthenticationService;
import com.product.product.service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/login")
    public LoginDTO LoginUser(@RequestBody Customer cs) {

        return authenticationService.Login(cs.getUsername(), cs.getPassword());
    }

    @PostMapping("/register")
    public Customer RegisterUser(@RequestBody Customer cs){

        return authenticationService.RegisterCustomer( cs.getUsername(), cs.getPassword());
    }
}

