package com.product.product.service.controller;

import com.product.product.service.service.passwordencoderforall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class EncoderController {

    @Autowired
    private passwordencoderforall pwd;

    @GetMapping("/encode")
    public String encodePasswords() {
        pwd.encodeExistingPasswords();
        return "Password encoding completed for the specified users!";
    }
}
