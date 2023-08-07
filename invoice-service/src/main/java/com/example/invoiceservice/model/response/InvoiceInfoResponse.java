package com.example.invoiceservice.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InvoiceInfoResponse {
    private Long id;

    private Long userId;

    private List<ItemInfoResponse> items;
}
