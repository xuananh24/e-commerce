package com.example.productservice.model.mapper;

import com.example.productservice.model.entity.Product;
import com.example.productservice.model.request.ProductInfoRequest;
import com.example.productservice.model.response.ProductInfoResponse;

public class ProductMapper {
    public static Product toEntity(ProductInfoRequest productInfoRequest) {
        return Product.builder()
                .name(productInfoRequest.getName())
                .description(productInfoRequest.getDescription())
                .price(productInfoRequest.getPrice())
                .remainingQuantity(productInfoRequest.getRemainingQuantity())
                .build();
    }

    public static ProductInfoResponse toDto(Product product) {
        return ProductInfoResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .remainingQuantity(product.getRemainingQuantity())
                .reviews(product.getReviews().stream().map(ReviewMapper::toDto).toList())
                .build();
    }
}
