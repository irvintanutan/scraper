package com.example.yelp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Review;
import com.example.yelp.service.YelpServiceImpl;

@RestController
public class YelpController {
		
	@Autowired
	YelpServiceImpl service;
	
	@GetMapping("/{url}")
	public List<Review> getAllClient(@PathVariable String url) { 
		return this.service.getAllReviewByRestaurant(url);
	}
	
}
