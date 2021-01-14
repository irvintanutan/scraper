package com.example.model;

public class Review {

	private String name;
	private String location;
	private String review;
	private String date;
	private int star;
	private int follower;
	private int rating;

	public Review(String name, String location, String review, String date, int star, int follower, int rating,
			String profUrl) {
		super();
		this.name = name;
		this.location = location;
		this.review = review;
		this.date = date;
		this.star = star;
		this.follower = follower;
		this.rating = rating;
		this.profUrl = profUrl;
	}

	public Review() {
		
	}
	
	private String profUrl;

	public String getProfUrl() {
		return profUrl;
	}

	public void setProfUrl(String profUrl) {
		this.profUrl = profUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public int getFollower() {
		return follower;
	}

	public void setFollower(int follower) {
		this.follower = follower;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
