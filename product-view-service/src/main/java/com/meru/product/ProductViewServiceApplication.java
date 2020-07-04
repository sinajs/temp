package com.meru.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class ProductViewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductViewServiceApplication.class, args);
	}

	
}
