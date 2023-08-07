package com.example.cartservice.model.mapper;

import com.example.cartservice.model.entity.Cart;
import com.example.cartservice.model.request.CartInfoRequest;
import com.example.cartservice.model.response.CartInfoResponse;

public class CartMapper {
    public static Cart toEntity(CartInfoRequest cartInfoRequest) {
        return Cart.builder()
                .userId(cartInfoRequest.getUserId())
                .build();
    }

    public static CartInfoResponse toDto(Cart cart) {
        return CartInfoResponse.builder()
                .id(cart.getId())
                .userId(cart.getUserId())
                .items(cart.getItems().stream().map(ItemMapper::toDto).toList())
                .build();
    }
}
