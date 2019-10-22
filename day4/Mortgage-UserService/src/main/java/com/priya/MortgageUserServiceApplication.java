package com.priya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MortgageUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MortgageUserServiceApplication.class, args);
	}

}
