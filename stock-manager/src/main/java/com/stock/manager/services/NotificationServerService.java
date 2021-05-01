package com.stock.manager.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stock.manager.dto.Application;

@Service
public class NotificationServerService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Set<Application> apps = new HashSet<>();
	
	public Set<Application> getApps() {
		return Collections.unmodifiableSet(apps);
	}
	
	public void addApp(Application app) {
		apps.add(app);
	}
	
	public void notifyServers() {
		apps.forEach(app -> {
			restTemplate.delete(String.format("http://%s:%s/stockcache", app.getHost(), app.getPort()));
		});
	}

}
