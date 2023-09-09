package com.product.product.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
//	@Bean
//	CommandLineRunner run(CustomerRepository cr , PasswordEncoder pw){
//
//		return args -> {
//			Customer cs = new Customer("1","admin", pw.encode("password") );
//			cr.save(cs);
//		};
//	}

}
