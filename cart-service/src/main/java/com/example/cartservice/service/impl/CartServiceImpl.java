package com.example.cartservice.service.impl;

import com.example.cartservice.model.entity.Cart;
import com.example.cartservice.model.entity.Item;
import com.example.cartservice.model.mapper.CartMapper;
import com.example.cartservice.model.mapper.ItemMapper;
import com.example.cartservice.model.request.CartInfoRequest;
import com.example.cartservice.model.request.ItemInfoRequest;
import com.example.cartservice.model.response.CartInfoResponse;
import com.example.cartservice.repository.CartRepository;
import com.example.cartservice.repository.ItemRepository;
import com.example.cartservice.service.CartService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ItemRepository itemRepository;

    public CartServiceImpl(CartRepository cartRepository, ItemRepository itemRepository) {
        this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void addItem(Long id, ItemInfoRequest itemInfoRequest) {
        Cart cart = cartRepository.findById(id).orElse(null);
        Item item = ItemMapper.toEntity(itemInfoRequest);
        if (cart != null) {
            item.setCart(cart);
            itemRepository.save(item);
        }
    }

    @Override
    public void removeItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }

    @Override
    public void removeCart(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void createCart(CartInfoRequest cartInfoRequest) {
        cartRepository.save(CartMapper.toEntity(cartInfoRequest));
    }

    @Override
    public CartInfoResponse showCartUser(Long userId) {
        return Optional.ofNullable(cartRepository.findCartByUserId(userId)).map(CartMapper::toDto).orElse(null);
    }
}
