package com.stock.quote.manager.dto;

import java.io.Serializable;

public class Application implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String host;
	private String port;
	
	@Deprecated
	public Application() {}

	public Application(String host, String port) {
		this.host = host;
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}
}
