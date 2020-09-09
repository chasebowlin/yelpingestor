package com.chasebowlin.yelpingestor.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class YelpReview {

    private final String reviewerName;
    private final String avatarImage;
    private final String location;
    private final double rating;
    private final String reviewContent;

    public YelpReview(@JsonProperty("name") String reviewerName,
                      @JsonProperty("image_url")String avatarImage,
                      @JsonProperty("url")String location,
                      @JsonProperty("rating")double rating,
                      @JsonProperty("text")String reviewContent) {
        this.reviewerName = reviewerName;
        this.avatarImage = avatarImage;
        this.location = location;
        this.rating = rating;
        this.reviewContent = reviewContent;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public String getLocation() {
        return location;
    }

    public double getRating() {
        return rating;
    }

    public String getReviewContent() {
        return reviewContent;
    }


}
