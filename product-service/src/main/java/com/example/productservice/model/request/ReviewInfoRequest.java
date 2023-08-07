package com.example.productservice.model.request;

import lombok.Data;

@Data
public class ReviewInfoRequest {
    private Long userId;

    private Long productId;

    private String content;
}
