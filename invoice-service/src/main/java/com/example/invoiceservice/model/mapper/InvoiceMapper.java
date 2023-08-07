package com.example.invoiceservice.model.mapper;

import com.example.invoiceservice.model.entity.Invoice;
import com.example.invoiceservice.model.request.InvoiceInfoRequest;
import com.example.invoiceservice.model.response.InvoiceInfoResponse;

public class InvoiceMapper {
    public static Invoice toEntity(InvoiceInfoRequest invoiceInfoRequest) {
        return Invoice.builder()
                .userId(invoiceInfoRequest.getUserId())
                .build();
    }

    public static InvoiceInfoResponse toDto(Invoice invoice) {
        return InvoiceInfoResponse.builder()
                .id(invoice.getId())
                .userId(invoice.getUserId())
                .items(invoice.getItems().stream().map(ItemMapper::toDto).toList())
                .build();
    }
}
