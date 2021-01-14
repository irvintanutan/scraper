package com.example.yelp.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
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

	public String getHTMLBody(String input) throws Exception {
		URL url = new URL(input);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		int status = con.getResponseCode();

		Reader streamReader = null;

		if (status > 299) {
		    streamReader = new InputStreamReader(con.getErrorStream());
		} else {
		    streamReader = new InputStreamReader(con.getInputStream());
		}
		
		BufferedReader in = new BufferedReader(streamReader);
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();

		con.disconnect();
		
		return content.toString();
	}

}
