package com.stock.quote.manager.controllers.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class Erro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer statusCode;
	private String mensage;
	private Instant moment;
	
	public Erro(Integer statusCode, String mensage) {
		this.statusCode = statusCode;
		this.mensage = mensage;
		this.moment = Instant.now();
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public String getMensage() {
		return mensage;
	}

	public Instant getMoment() {
		return moment;
	}
}
