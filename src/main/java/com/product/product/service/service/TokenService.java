package com.product.product.service.service;

import org.springframework.security.oauth2.jwt.Jwt;
import com.nimbusds.jwt.JWT;
//import com.nimbusds.jwt.JWTClaimsSet;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.stream.Collectors;

import static org.python.core.Py.getName;

@Service
public class TokenService {
    @Autowired
    private JwtEncoder jwtEncoder;
    @Autowired
    private JwtDecoder jwtDecoder;

    public String genrateJwt(Authentication auth){

        Instant now = Instant.now();
//        String scope = auth.getAuthorities().stream()
//                .map(GrantedAuthority::getAuthority)
//                .collect(Collectors.joining(" "));

        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .subject(auth.getName())
                .issuedAt(now)
                .issuer("self")
                .build();


        return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }
}
