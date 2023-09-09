package com.product.product.service.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyGeneratorUtility {

    public static KeyPair generateRsaKey(){

        KeyPair kp;
        try{
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            kp = keyPairGenerator.generateKeyPair();
        }catch(Exception e){
            throw new IllegalStateException();
        }
        return kp;

    }
}
