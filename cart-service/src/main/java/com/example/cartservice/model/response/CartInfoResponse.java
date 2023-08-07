package com.example.cartservice.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CartInfoResponse {
    private Long id;

    private Long userId;

    private List<ItemInfoResponse> items;
}
