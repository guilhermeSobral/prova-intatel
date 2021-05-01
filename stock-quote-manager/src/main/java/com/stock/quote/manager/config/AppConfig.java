package com.stock.quote.manager.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.stock.quote.manager.dto.Application;

@Configuration
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	@Primary
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public void registerStockManager() throws UnknownHostException {
		Application app = new Application (
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port")				
		);
		
		RestTemplate rt = restTemplate();
		rt.postForLocation("http://localhost:8080/notification", app);
	}

}
