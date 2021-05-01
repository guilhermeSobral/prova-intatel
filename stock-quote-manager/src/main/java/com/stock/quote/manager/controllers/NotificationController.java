package com.stock.quote.manager.controllers;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stockcache")
public class NotificationController {
	
	@DeleteMapping
	@CacheEvict(value = "listValidStocks")
	public void cleanCache() {
		//All the logic is implemented by the annotation @CacheEvict
	}

}
