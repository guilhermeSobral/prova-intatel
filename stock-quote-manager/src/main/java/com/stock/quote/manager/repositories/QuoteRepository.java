package com.stock.quote.manager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stock.quote.manager.entities.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {
	
	public List<Quote> findByStockId(String stockId);	
	
	@Query("SELECT DISTINCT obj.stockId FROM Quote obj")
	public List<String> findAllStockIds();

}
