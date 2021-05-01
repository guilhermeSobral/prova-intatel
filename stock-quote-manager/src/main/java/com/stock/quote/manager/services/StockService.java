package com.stock.quote.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stock.quote.manager.entities.Stock;

@Service
public class StockService {
	
	@Autowired
	private RestTemplate rt;
	
	@Cacheable(value = "listValidStocks")
	public List<Stock> readAllStocks() {
		ResponseEntity<List<Stock>> response = rt.exchange("http://localhost:8080/stock",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Stock>>() {
        });
		return response.getBody();		
	}

}
