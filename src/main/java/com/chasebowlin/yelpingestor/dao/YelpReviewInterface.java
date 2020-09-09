package com.chasebowlin.yelpingestor.dao;

import com.chasebowlin.yelpingestor.model.YelpReview;

import java.util.List;
import java.util.UUID;

public interface YelpReviewInterface {

    int insertYelpReview(YelpReview yelpReview);

    List<YelpReview> getAllYelpReveiws();
}
