package com.example.yelp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yelp.service.YelpServiceImpl;

@RestController
public class YelpController {
		
	@Autowired
	YelpServiceImpl service;
	
	@GetMapping("/client")
	public String getAllClient() {
		
		return this.service.getResponse();
	}
	
}
