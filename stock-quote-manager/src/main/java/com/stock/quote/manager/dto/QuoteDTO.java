package com.stock.quote.manager.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoteDTO {
	
	private String quoteDate;
	private String quotation;
	
	public QuoteDTO() {}

	@JsonCreator
	public QuoteDTO(
			@JsonProperty("quoteDate") String quoteDate, 
			@JsonProperty("quotation") String quotation
		) {
		this.quoteDate = quoteDate;
		this.quotation = quotation;
	}

	public String getQuoteDate() {
		return quoteDate;
	}

	public String getQuotation() {
		return quotation;
	}
}
