package com.example.yelp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.FaceAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.ImageSource;

public class VisionApiService {

	public static JSONObject detectFacesGcs(String gcsPath) throws IOException {
		List<AnnotateImageRequest> requests = new ArrayList<>();

		ImageSource imgSource = ImageSource.newBuilder().setImageUri(gcsPath).build();
		Image img = Image.newBuilder().setSource(imgSource).build();
		Feature feat = Feature.newBuilder().setType(Feature.Type.FACE_DETECTION).build();

		AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
		requests.add(request);

		// Initialize client that will be used to send requests. This client only needs
		// to be created
		// once, and can be reused for multiple requests. After completing all of your
		// requests, call
		// the "close" method on the client to safely clean up any remaining background
		// resources.
		try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
			BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
			List<AnnotateImageResponse> responses = response.getResponsesList();

			for (AnnotateImageResponse res : responses) {
				if (res.hasError()) {
					System.out.format("Error: %s%n", res.getError().getMessage());
					return new JSONObject();
				}

				// For full list of available annotations, see http://g.co/cloud/vision/docs
				for (FaceAnnotation annotation : res.getFaceAnnotationsList()) {

					JSONObject object = new JSONObject();
					object.put("joy", annotation.getJoyLikelihood());
					object.put("surprise", annotation.getSurpriseLikelihood());
					object.put("anger", annotation.getAngerLikelihood());

					return object;
				}
			}
		}
		return null;
	}

}
