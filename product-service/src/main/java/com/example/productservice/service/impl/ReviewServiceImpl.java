package com.example.productservice.service.impl;

import com.example.productservice.model.entity.Product;
import com.example.productservice.model.entity.Review;
import com.example.productservice.model.mapper.ReviewMapper;
import com.example.productservice.model.request.ReviewInfoRequest;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.repository.ReviewRepository;
import com.example.productservice.service.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void add(ReviewInfoRequest reviewInfoRequest) {
        Review review = ReviewMapper.toEntity(reviewInfoRequest);
        Product product = productRepository.findById(reviewInfoRequest.getProductId()).orElse(null);
        if (product != null) {
            review.setProduct(product);
            reviewRepository.save(review);
        }
    }
}
