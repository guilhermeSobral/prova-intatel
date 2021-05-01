package com.stock.manager.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.stock.manager.entities.Stock;
import com.stock.manager.services.NotificationServerService;
import com.stock.manager.services.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {
	
	@Autowired
	private StockService service;
	
	@Autowired
	private NotificationServerService notificationService;
	
	@PostMapping
	public ResponseEntity<Stock> createStock(@RequestBody Stock stockPayload) {
		Stock stock = service.createStock(stockPayload);
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(stock.getId())
					.toUri();
		notificationService.notifyServers();
		return ResponseEntity.created(uri).body(stock);
	}
	
	@GetMapping
	public ResponseEntity<List<Stock>> readAllStocks() {
		List<Stock> listStocks = service.readAllStocks();
		return ResponseEntity.ok().body(listStocks);
	}
}
