package com.example.cartservice.model.request;

import lombok.Data;

@Data
public class ItemInfoRequest {
    private Long productId;

    private Long quantity;

    private Double unitPrice;
}
