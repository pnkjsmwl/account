package com.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AccountBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountBackendApplication.class, args);
	}

}
