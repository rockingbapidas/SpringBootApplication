package com.bapi.springbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringServiceApplication.class, args);
	}
}
