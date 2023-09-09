package com.product.product.service.model;

public class LoginDTO {

    private Customer user;
    private String jwt;

    public LoginDTO(){
        super();
    }

    public LoginDTO(Customer user, String jwt){
        this.user = user;
        this.jwt = jwt;
    }

    public Customer getUser(){
        return this.user;
    }

    public void setUser(Customer user){
        this.user = user;
    }

    public String getJwt(){
        return this.jwt;
    }

    public void setJwt(String jwt){
        this.jwt = jwt;
    }

}