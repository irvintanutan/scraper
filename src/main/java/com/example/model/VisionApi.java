package com.example.model;

import org.json.JSONObject;

public class VisionApi {
	private String surprise;

	public String getSurprise() {
		return surprise;
	}

	public VisionApi(String surprise, String joy, String anger) {
		super();
		this.surprise = surprise;
		this.joy = joy;
		this.anger = anger;
	}
	
	public VisionApi (JSONObject object) {
		 this.surprise = object.optString("surprise", "none");
		 this.joy = object.optString("joy", "none");
		 this.anger = object.optString("anger", "none");
	}

	public void setSurprise(String surprise) {
		this.surprise = surprise;
	}

	public String getJoy() {
		return joy;
	}

	public void setJoy(String joy) {
		this.joy = joy;
	}

	public String getAnger() {
		return anger;
	}

	public void setAnger(String anger) {
		this.anger = anger;
	}

	private String joy;
	private String anger;

}
