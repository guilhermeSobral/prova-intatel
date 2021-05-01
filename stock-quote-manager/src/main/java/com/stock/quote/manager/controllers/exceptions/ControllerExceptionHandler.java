package com.stock.quote.manager.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.stock.quote.manager.services.exceptions.StockNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(StockNotFoundException.class)
	public ResponseEntity<Erro> stockNotFoundHandler(StockNotFoundException e) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		Erro erro = new Erro(status.value(), e.getMessage());	
		return ResponseEntity.status(status).body(erro);
	}

}
