package com.michelle.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.michelle.bookstore.services.DBService;

@Configuration
@Profile("test")
public class testeConfig {
	
	@Autowired
	public DBService service;
	
	@Bean
	public void instantiateDatabase() {
		this.service.instantiateDatabase();
	}

}
