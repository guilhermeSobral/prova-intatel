package com.stock.manager.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.stock.manager.entities.Stock;
import com.stock.manager.repositories.StockRepository;

@Configuration
public class AppConfig {
	
	@Autowired
	private StockRepository repository;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public void initDatabase() {
		repository.saveAll(Arrays.asList(
				new Stock("petr3", "petr3 Stock"),
				new Stock("VALE5", "Stock VALE5")
			)	
		);
	}

}
