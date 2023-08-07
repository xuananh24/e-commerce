package com.example.cartservice.controller;

import com.example.cartservice.Common.Constant.PathConstant;
import com.example.cartservice.model.request.CartInfoRequest;
import com.example.cartservice.model.request.ItemInfoRequest;
import com.example.cartservice.model.response.CartInfoResponse;
import com.example.cartservice.service.CartService;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(value = PathConstant.API_ITEM_ADD_URL)
    public void addItemToCart(@PathVariable Long cartId, @RequestBody ItemInfoRequest itemInfoRequest) {
        cartService.addItem(cartId, itemInfoRequest);
    }

    @DeleteMapping(value = PathConstant.API_ITEM_REMOVE_URL)
    public void removeItemFromCart(@PathVariable Long itemId) {
        cartService.removeItem(itemId);
    }

    @DeleteMapping(value = PathConstant.API_CART_REMOVE_URL)
    public void removeCart(@PathVariable Long cartId) {
        cartService.removeCart(cartId);
    }

    @PostMapping(value = PathConstant.API_CART_CREATE_URL)
    public void createCart(@RequestBody CartInfoRequest cartInfoRequest) {
        cartService.createCart(cartInfoRequest);
    }

    @GetMapping(value = PathConstant.API_CART_SHOW_URL)
    public CartInfoResponse showCartUser(@PathVariable Long userId) {
        return cartService.showCartUser(userId);
    }
}
