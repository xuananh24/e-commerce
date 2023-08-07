package com.example.cartservice.Common.Constant;

public class PathConstant {
    public static final String API_BASE_URL = "/api/cart-service";
    public static final String API_CART_CREATE_URL = API_BASE_URL + "/cart/create";
    public static final String API_CART_REMOVE_URL = API_BASE_URL + "/cart/remove/{cartId}";
    public static final String API_CART_SHOW_URL = API_BASE_URL + "/cart/{userId}";
    public static final String API_ITEM_ADD_URL = API_BASE_URL + "/item/add/{cartId}";
    public static final String API_ITEM_REMOVE_URL = API_BASE_URL + "/item/remove/{itemId}";
}
