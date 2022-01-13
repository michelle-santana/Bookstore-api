package com.michelle.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.michelle.bookstore.services.DBService;

@Configuration
@Profile("dev")
public class devConfig {
	
	@Autowired
	public DBService service;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String stratergy;
	
	@Bean
	public boolean instanceDatabase() {
		if(stratergy.equals("create")) {
			this.service.instantiateDatabase();
		}
		
		return false;
	}
	

}
