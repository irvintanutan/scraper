package com.example.yelp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Review;

@Service
public class YelpServiceImpl implements YelpService { 

	@Override
	public List<Review> getReviewByRating(int rating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> getAllReviewByRestaurant(String url) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
