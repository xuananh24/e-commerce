package com.example.productservice.service;

import com.example.productservice.model.request.ProductInfoRequest;
import com.example.productservice.model.response.ProductInfoResponse;

import java.util.List;

public interface ProductService {
    void add(ProductInfoRequest productInfoRequest);

    void removeById(Long id);
    ProductInfoResponse showById(Long id);

    List<ProductInfoResponse> showAll();
}
