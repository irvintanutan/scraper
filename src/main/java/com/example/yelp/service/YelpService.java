package com.example.yelp.service;

import java.util.List;

import com.example.model.Review;

public interface YelpService {  
	public List<Review> getAllReviewByRestaurant(String url, int rating); 
}
