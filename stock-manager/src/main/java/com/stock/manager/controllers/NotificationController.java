package com.stock.manager.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.manager.dto.Application;
import com.stock.manager.services.NotificationServerService;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	@Autowired
	private NotificationServerService service;
	
	@PostMapping
	public ResponseEntity<Void> registerApplication(@RequestBody Application app) {
		service.addApp(app);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<Set<Application>> readAllApplications() {
		Set<Application> apps = service.getApps();
		return ResponseEntity.ok().body(apps);
	}
}
