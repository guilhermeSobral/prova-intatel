package com.stock.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.manager.entities.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, String> {

}
