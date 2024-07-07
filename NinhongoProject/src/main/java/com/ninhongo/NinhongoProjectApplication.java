package com.ninhongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.ninhongo.controllers.NinhongoController;

@SpringBootApplication
public class NinhongoProjectApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(NinhongoProjectApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(NinhongoProjectApplication.class, args);
		
		//NinhongoController ninhongoController;
		
	}

	
	
	

}
