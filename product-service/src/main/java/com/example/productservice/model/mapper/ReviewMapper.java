package com.example.productservice.model.mapper;

import com.example.productservice.model.entity.Review;
import com.example.productservice.model.request.ReviewInfoRequest;
import com.example.productservice.model.response.ReviewInfoResponse;

public class ReviewMapper {
    public static Review toEntity(ReviewInfoRequest reviewInfoRequest) {
        return Review.builder()
                .userId(reviewInfoRequest.getUserId())
                .content(reviewInfoRequest.getContent())
                .build();
    }

    public static ReviewInfoResponse toDto(Review review) {
        return ReviewInfoResponse.builder()
                .userId(review.getUserId())
                .content(review.getContent())
                .build();
    }
}
