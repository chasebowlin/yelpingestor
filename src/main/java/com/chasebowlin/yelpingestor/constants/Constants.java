package com.chasebowlin.yelpingestor.constants;

public final class Constants {

    // The request string for the Yelp API request including the restuarant's id
    public static final String urlString = "https://api.yelp.com/v3/businesses/grabs-burger-bar-kenosha/reviews";

    //header : authorization
    public static final String headerKey = "authorization";

    /*
     for proof of concept I am storing the api_key here,
     but sensitive information like this shouldn't be hard coded
     and should be passed in as a variable for use.
     */
    public static final String headerValue = "REMOVEDFORSECURITYREASONS";
}
