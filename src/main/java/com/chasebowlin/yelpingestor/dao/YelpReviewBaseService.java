package com.chasebowlin.yelpingestor.dao;

import com.chasebowlin.yelpingestor.model.YelpReview;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


import static com.chasebowlin.yelpingestor.constants.Constants.*;


@Repository("YelpConnectorService")
public class YelpReviewBaseService implements YelpReviewInterface {

    private static List<YelpReview> reviews = new ArrayList<>();

    @Override
    public int insertYelpReview(YelpReview yelpReview) {
        reviews.add(yelpReview);
        System.out.println("submitted yelp review for name: " + yelpReview.getReviewerName());
        return 1;
    }

    /** This method will connect to the yelp API to get all reviews for a specific restaurant
     *
     * @return
     */
    @Override
    public List<YelpReview> getAllYelpReveiws() {
        try {
            RequestYelpReviews();
        }
        catch (Exception e) {
            System.err.println("there was an error trying to retrieve yelp reviews" + e.toString());
        }

        return reviews;
    }

    /** A helper method that does the leg work of connecting to the Yelp
     *  API and getting the reviews for the specified restaurant.
     *  It then converts the reviews into the YelpReview model and
     *  adds them to the list of reviews
     *
     * @throws IOException
     */
    private void RequestYelpReviews() throws IOException {

        //set up the connection informtion for the yelp API
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty(headerKey, headerValue);


        //read in the review information
        BufferedReader inputBuffer = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputData;
        StringBuffer response = new StringBuffer();
        while ((inputData = inputBuffer.readLine()) != null) {
            response.append(inputData);
        }
        inputBuffer.close();

        //TODO: clean up this section of code to avoid use
        //TODO: of both Gson and JSONObjects
        JSONArray jsonObjects = new JSONArray(response.toString());

        Gson gson = new Gson();
        for (Object object: jsonObjects) {
            YelpReview review = gson.fromJson(object.toString(), YelpReview.class);
            reviews.add(review);
        }
    }
}
