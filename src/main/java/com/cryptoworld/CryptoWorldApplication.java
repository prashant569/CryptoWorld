package com.cryptoworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CryptoWorldApplication extends SpringBootServletInitializer {


	public static void main(String[] args) {
		SpringApplication.run(CryptoWorldApplication.class, args);
	}
	
	
	   @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(CryptoWorldApplication.class);
	    }
}
