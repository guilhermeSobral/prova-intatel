package com.stock.quote.manager.services.exceptions;

public class StockNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StockNotFoundException() {
		super();
	}

	public StockNotFoundException(String message) {
		super(message);
	}
	
	

}
