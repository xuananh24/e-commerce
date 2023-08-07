package com.example.productservice.model.request;

import lombok.Data;

@Data
public class ProductInfoRequest {
    private String name;

    private String description;

    private Double price;

    private Long remainingQuantity;

}
