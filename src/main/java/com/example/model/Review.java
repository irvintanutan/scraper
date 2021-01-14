package com.example.model;

import org.json.JSONArray;
import org.json.JSONObject;

public class Review {

	private String comment;
	private String date; 
	private int rating; 
	private User user;

	public Review(String comment, String date, int rating, User user) {
		super();
		this.comment = comment;
		this.date = date; 
		this.rating = rating; 
		this.user = user;
	}

	public Review() {

	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	} 

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	} 

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
