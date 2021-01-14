package com.example.yelp.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.yelp.service.YelpServiceImpl;

@RestController
public class YelpController {

	@Autowired
	YelpServiceImpl service;

	@GetMapping("/scraper")
	public String getAllClient(@RequestParam String url) {
		String result = "";
		try {

			String html = service.getHTMLBody(url);
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

			result = finalString;
			JSONObject object = new JSONObject(finalString);
			JSONArray reviewObject = object.getJSONObject("bizDetailsPageProps")
					.getJSONObject("reviewFeedQueryProps").getJSONArray("reviews");

			result = reviewObject.toString();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
