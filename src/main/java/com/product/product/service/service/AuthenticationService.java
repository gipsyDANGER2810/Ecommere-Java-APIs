package com.product.product.service.service;

import com.product.product.service.model.Customer;
import com.product.product.service.model.LoginDTO;
import com.product.product.service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Autowired
    public AuthenticationService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder,
                                 AuthenticationManager authenticationManager, TokenService tokenService) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    public Customer RegisterCustomer(String Username , String password) {
        Customer cs = new Customer();
        cs.setUsername(Username);
        String passwordEncoded = passwordEncoder.encode(password);
        cs.setPassword(passwordEncoded);
        return customerRepository.save(cs);
    }


    public LoginDTO Login(String username , String password){


        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,password)
            );
            String token = tokenService.genrateJwt(auth);

            return new LoginDTO(customerRepository.findByUsername(username).get() , token);
        }catch(AuthenticationException e){
            return new LoginDTO(null, "");
        }

    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return customerRepository.findByUsername(username).orElseThrow(()->
//                new UsernameNotFoundException("User not found"));
//    }
}
