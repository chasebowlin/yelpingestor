package com.chasebowlin.yelpingestor.service;

import com.chasebowlin.yelpingestor.dao.YelpReviewInterface;
import com.chasebowlin.yelpingestor.model.YelpReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YelpReviewService {

    private final YelpReviewInterface yelpConnectorInterface;

    @Autowired
    public YelpReviewService(@Qualifier("YelpConnectorService") YelpReviewInterface yelpConnectorInterface) {
        this.yelpConnectorInterface = yelpConnectorInterface;
    }

    public int addYelpReview(YelpReview yelpReview) {
        return yelpConnectorInterface.insertYelpReview(yelpReview);
    }

    public List<YelpReview> getAllYelpReviews() {
        return yelpConnectorInterface.getAllYelpReveiws();
    }
}
