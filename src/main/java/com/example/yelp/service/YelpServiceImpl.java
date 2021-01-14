package com.example.yelp.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.example.model.Review;
import com.example.model.User;

@Service
public class YelpServiceImpl implements YelpService {

	@Override
	public List<Review> getAllReviewByRestaurant(String url, int rating) {
		// TODO Auto-generated method stub

		List<Review> result = new ArrayList<Review>();

		try {

			String html = this.getHTMLBody(url);
			Document doc = Jsoup.parse(html);
			Element element = doc.select("div[class=main-content-wrap main-content-wrap--full]").first();
			Elements childScripts = element.getElementsByTag("script");
			Element finalElement = null;

			for (Element e : childScripts) {
				if (e.toString().contains("reviewFeedQueryProps")) {
					finalElement = e;
					break;
				}
			}

			String finalString = finalElement.data().replace("<!--", "").replace("-->", "");

			JSONObject object = new JSONObject(finalString);
			JSONArray reviews = object.getJSONObject("bizDetailsPageProps").getJSONObject("reviewFeedQueryProps")
					.getJSONArray("reviews");

			for (int a = 0; a < reviews.length(); a++) {

				JSONObject review = reviews.getJSONObject(a);

				if (rating > 0 && review.getInt("rating") != rating) continue;

				Review r = new Review();

				User user = new User();
				JSONObject userObject = review.getJSONObject("user");
				user.setAvatarUrl(userObject.getString("src"));
				user.setFriendCount(userObject.getInt("friendCount"));
				user.setLocation(userObject.getString("displayLocation"));
				user.setName(userObject.getString("markupDisplayName"));
				user.setPhotoCount(userObject.getInt("photoCount"));
				user.setReviewCount(userObject.getInt("reviewCount"));
				user.setUserId(review.getString("userId"));

				r.setComment(review.getJSONObject("comment").getString("text"));
				r.setDate(review.getString("localizedDate"));
				r.setRating(review.getInt("rating"));
				r.setUser(user);

				result.add(r);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
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
