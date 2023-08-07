package com.example.productservice.service.impl;

import com.example.productservice.model.entity.Product;
import com.example.productservice.model.mapper.ProductMapper;
import com.example.productservice.model.request.ProductInfoRequest;
import com.example.productservice.model.response.ProductInfoResponse;
import com.example.productservice.repository.ProductRepository;
import com.example.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void add(ProductInfoRequest productInfoRequest) {
        Product product = ProductMapper.toEntity(productInfoRequest);
        productRepository.save(product);
    }

    @Override
    public void removeById(Long id) {
        productRepository.findById(id).ifPresent(productRepository::delete);
    }

    @Override
    public ProductInfoResponse showById(Long id) {
        return productRepository.findById(id).map(ProductMapper::toDto).orElse(null);
    }

    @Override
    public List<ProductInfoResponse> showAll() {
        return productRepository.findAll().stream().map(ProductMapper::toDto).toList();
    }
}
