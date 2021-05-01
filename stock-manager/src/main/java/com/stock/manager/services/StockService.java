package com.stock.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.manager.entities.Stock;
import com.stock.manager.repositories.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository repository;
	
	@Transactional
	public Stock createStock(Stock stock) {
		return repository.save(stock);
		
	}
	
	@Transactional(readOnly = true)
	public List<Stock> readAllStocks() {
		return repository.findAll();
	}
}
