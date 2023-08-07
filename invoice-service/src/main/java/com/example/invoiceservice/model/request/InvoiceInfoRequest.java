package com.example.invoiceservice.model.request;

import lombok.Data;

import java.util.List;

@Data
public class InvoiceInfoRequest {
    private Long userId;

    private List<ItemInfoRequest> items;
}
