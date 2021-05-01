package com.stock.quote.manager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.quote.manager.dto.StockQuote;
import com.stock.quote.manager.services.StockQuoteService;

@RestController
@RequestMapping("/quote/stock")
public class QuoteStockController {	
	
	@Autowired
	private StockQuoteService service;
	
	@PostMapping
	public ResponseEntity<Void> createQuoteStock(@RequestBody StockQuote payload) {
		service.createQuoteStock(payload);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StockQuote> readAllStockQuotesById(@PathVariable String id) {
		StockQuote stockQuote = service.readStockQuoteById(id);
		return ResponseEntity.ok().body(stockQuote);
	}
	
	@GetMapping
	public ResponseEntity<List<StockQuote>> readAllStockQuotes() {
		List<StockQuote> list = service.readAllStockQuotes();
		return ResponseEntity.ok().body(list);
	}

}
