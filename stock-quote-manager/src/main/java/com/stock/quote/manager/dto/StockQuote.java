package com.stock.quote.manager.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StockQuote {
	
	private String idStock;
	private List<QuoteDTO> quotes = new ArrayList<>();
	
	public StockQuote() {}
	
	@JsonCreator
	public StockQuote(
			@JsonProperty("id") String idStock, 
			@JsonProperty("quotes") List<QuoteDTO> quotes) {
		this.idStock = idStock;
		this.quotes = quotes;
	}
	
	public StockQuote(String idStock, QuoteDTO dto) {
		this.idStock = idStock;
		this.quotes.add(dto);
	}
	
	public String getIdStock() {
		return idStock;
	}

	public List<QuoteDTO> getQuotes() {
		return Collections.unmodifiableList(quotes);
	}
}
