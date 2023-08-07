package com.example.productservice.controller;

import com.example.productservice.common.constant.PathConstant;
import com.example.productservice.model.request.ProductInfoRequest;
import com.example.productservice.model.response.ProductInfoResponse;
import com.example.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = PathConstant.API_PRODUCT_SHOW_ALL_URL)
    public List<ProductInfoResponse> showAll() {
        return productService.showAll();
    }

    @GetMapping(value = PathConstant.API_PRODUCT_SHOW_URL)
    public ProductInfoResponse showById(@PathVariable Long id) {
        return productService.showById(id);
    }

    @PostMapping(value = PathConstant.API_PRODUCT_ADD_URL)
    public void addProduct(@RequestBody ProductInfoRequest productInfoRequest) {
        productService.add(productInfoRequest);
    }

    @DeleteMapping(value = PathConstant.API_PRODUCT_REMOVE_URL)
    public void removeProductById(@PathVariable Long id) {
        productService.removeById(id);
    }
}
