package com.example.productservice.controller;

import com.example.productservice.common.constant.PathConstant;
import com.example.productservice.model.request.ReviewInfoRequest;
import com.example.productservice.service.ReviewService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping(value = PathConstant.API_REVIEW_ADD_URL)
    public void add(@RequestBody ReviewInfoRequest reviewInfoRequest) {
        reviewService.add(reviewInfoRequest);
    }
}
