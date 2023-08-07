package com.example.invoiceservice.model.mapper;

import com.example.invoiceservice.model.entity.Item;
import com.example.invoiceservice.model.request.ItemInfoRequest;
import com.example.invoiceservice.model.response.ItemInfoResponse;

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
