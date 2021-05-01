package com.stock.quote.manager.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_quote")
public class Quote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String stockId;
	private String quoteDate;
	private String quotation;	
	
	public Quote() {}

	public Quote(String stockId, String quoteDate, String quotation) {
		this.stockId = stockId;
		this.quoteDate = quoteDate;
		this.quotation = quotation;
	}	

	public Long getId() {
		return id;
	}

	public String getStockId() {
		return stockId;
	}

	public String getQuoteDate() {
		return quoteDate;
	}

	public String getQuotation() {
		return quotation;
	}
}
