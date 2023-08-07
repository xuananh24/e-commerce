package com.example.productservice.common.constant;

public class PathConstant {
    public static final String API_BASE_URL = "/api/product-service";
    public static final String API_ADMIN_URL = API_BASE_URL + "/admin";
    public static final String API_PRODUCT_ADD_URL = API_ADMIN_URL + "/product/add";
    public static final String API_PRODUCT_REMOVE_URL = API_ADMIN_URL + "/product/remove/{id}";
    public static final String API_PRODUCT_SHOW_ALL_URL = API_BASE_URL + "/product";
    public static final String API_PRODUCT_SHOW_URL = API_BASE_URL + "/product/{id}";
    public static final String API_REVIEW_ADD_URL= API_BASE_URL + "/review/add";

}
