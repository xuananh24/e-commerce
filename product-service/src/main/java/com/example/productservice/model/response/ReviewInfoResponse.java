package com.example.productservice.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewInfoResponse {
    private Long userId;

    private String content;
}
