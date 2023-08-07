package com.example.productservice.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductInfoResponse {
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Long remainingQuantity;

    private List<ReviewInfoResponse> reviews;
}
