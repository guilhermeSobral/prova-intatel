package com.stock.manager.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_stock")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String description;
	
	@Deprecated
	public Stock() {}

	public Stock(String id, String description) {
		this.id = id;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}
}
