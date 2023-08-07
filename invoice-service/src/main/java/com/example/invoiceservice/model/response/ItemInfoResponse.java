package com.example.invoiceservice.model.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemInfoResponse {
    private Long id;

    private Long productId;

    private Long quantity;

    private Double unitPrice;

}
