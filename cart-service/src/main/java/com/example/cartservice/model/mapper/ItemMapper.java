package com.example.cartservice.model.mapper;


import com.example.cartservice.model.entity.Item;
import com.example.cartservice.model.request.ItemInfoRequest;
import com.example.cartservice.model.response.ItemInfoResponse;

public class ItemMapper {
    public static Item toEntity(ItemInfoRequest itemInfoRequest) {
        return Item.builder()
                .productId(itemInfoRequest.getProductId())
                .quantity(itemInfoRequest.getQuantity())
                .unitPrice(itemInfoRequest.getUnitPrice())
                .build();
    }

    public static ItemInfoResponse toDto(Item item) {
        return ItemInfoResponse.builder()
                .id(item.getId())
                .productId(item.getProductId())
                .quantity(item.getQuantity())
                .unitPrice(item.getUnitPrice())
                .build();
    }
}
