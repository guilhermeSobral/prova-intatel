package com.stock.quote.manager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stock.quote.manager.dto.QuoteDTO;
import com.stock.quote.manager.dto.StockQuote;
import com.stock.quote.manager.entities.Quote;
import com.stock.quote.manager.entities.Stock;
import com.stock.quote.manager.repositories.QuoteRepository;
import com.stock.quote.manager.services.exceptions.StockNotFoundException;

@Service
public class StockQuoteService {
	
	@Autowired
	private QuoteRepository repository;
	
	@Autowired
	private StockService stockService;

	@Transactional	
	public void createQuoteStock(StockQuote payload) {
		String stockId = payload.getIdStock();
		
		if(!isValidStock(stockId))
			throw new StockNotFoundException(String.format("Stock with id: %s can't have a quote!", stockId));
		
		payload.getQuotes().forEach(stockQuote -> {
			Quote quote = new Quote(stockId, stockQuote.getQuoteDate(), stockQuote.getQuotation());
			repository.save(quote);
		});
	}
	
	@Transactional(readOnly = true)
	public StockQuote readStockQuoteById(String stockId) {
		List<Quote> list = repository.findByStockId(stockId);
		List<QuoteDTO> quoteDto = list
				.stream()
				.map(quote -> new QuoteDTO(quote.getQuoteDate(), quote.getQuotation()))
				.collect(Collectors.toList());
		return new StockQuote(stockId, quoteDto);
		
	}
	
	@Transactional(readOnly = true)
	public List<StockQuote> readAllStockQuotes() {
		List<StockQuote> list = new ArrayList<>();
		List<String> ids = repository.findAllStockIds();
		ids.forEach(id -> list.add(readStockQuoteById(id)));
		return list;
	}
	
	private boolean isValidStock(String stockId) {
		List<Stock> listStocks = stockService.readAllStocks();
		return listStocks
				.stream()
				.anyMatch(stock -> stock.getId().equals(stockId));
	}
}
