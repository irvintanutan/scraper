package com.example.model;

public class User {

	private String name;
	private String userId;
	private String avatarUrl;
	private int friendCount;
	private int reviewCount;
	private int photoCount;
	private String location;

	public User(String name, String userId, String avatarUrl, int friendCount, int reviewCount, int photoCount,
			String location) {
		super();
		this.name = name;
		this.userId = userId;
		this.avatarUrl = avatarUrl;
		this.friendCount = friendCount;
		this.reviewCount = reviewCount;
		this.photoCount = photoCount;
		this.location = location;
	}

	public User() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public int getFriendCount() {
		return friendCount;
	}

	public void setFriendCount(int friendCount) {
		this.friendCount = friendCount;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public int getPhotoCount() {
		return photoCount;
	}

	public void setPhotoCount(int photoCount) {
		this.photoCount = photoCount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
