package com.example.invoiceservice.common.constant;

public class PathConstant {
    public static final String API_BASE_URL = "/api/invoice-service";
    public static final String API_INVOICE_ADD_URL = API_BASE_URL + "/invoice/add";
    public static final String API_INVOICE_SHOW_ALL_BY_USER_URL = API_BASE_URL + "/invoice/{userId}";
    public static final String API_INVOICE_SHOW_BY_USER_AND_ID_URL = API_BASE_URL + "/invoice/{userId}/{invoiceId}";
}
