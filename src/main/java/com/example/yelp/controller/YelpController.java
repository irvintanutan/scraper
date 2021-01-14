package com.example.yelp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.model.Review;
import com.example.yelp.service.YelpServiceImpl;

@RestController
public class YelpController {

	@Autowired
	YelpServiceImpl service;

	@GetMapping("/scraper")
	ResponseEntity<?> getAllClient(@RequestParam String url, @RequestParam(required = false, defaultValue = "0") int rating) {

		List<Review> result = new ArrayList<Review>();
 
		try {

			result = this.service.getAllReviewByRestaurant(url, rating);
			
			if (result.isEmpty()) {
				throw new ResponseStatusException(
				          HttpStatus.BAD_REQUEST, "No result found with url " + url);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(
			          HttpStatus.BAD_REQUEST, "No result found with url " + url, e);
		}

		return ResponseEntity.ok(result);
	}

}
