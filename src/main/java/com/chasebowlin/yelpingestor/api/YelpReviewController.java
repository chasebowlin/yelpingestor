package com.chasebowlin.yelpingestor.api;

import com.chasebowlin.yelpingestor.model.YelpReview;
import com.chasebowlin.yelpingestor.service.YelpReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/reviews")
@RestController
public class YelpReviewController {

    private final YelpReviewService yelpReviewService;

    @Autowired
    public YelpReviewController(YelpReviewService yelpReviewService) {
        this.yelpReviewService = yelpReviewService;
    }

    @PostMapping
    public void addYelpReview(@RequestBody  YelpReview yelpReview) {
        yelpReviewService.addYelpReview(yelpReview);
    }

    @GetMapping
    public List<YelpReview> getAllYelpReviews() {
        return yelpReviewService.getAllYelpReviews();
    }
}
