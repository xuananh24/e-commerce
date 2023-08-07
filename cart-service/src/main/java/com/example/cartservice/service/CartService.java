package com.example.cartservice.service;

import com.example.cartservice.model.request.CartInfoRequest;
import com.example.cartservice.model.request.ItemInfoRequest;
import com.example.cartservice.model.response.CartInfoResponse;

public interface CartService {
    void addItem(Long id, ItemInfoRequest itemInfoRequest);
    void removeItem(Long itemId);
    void removeCart(Long id);
    void createCart(CartInfoRequest cartInfoRequest);
    CartInfoResponse showCartUser(Long userId);
}
