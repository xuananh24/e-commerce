package com.example.invoiceservice.service;

import com.example.invoiceservice.model.request.InvoiceInfoRequest;
import com.example.invoiceservice.model.response.InvoiceInfoResponse;

import java.util.List;

public interface InvoiceService {
    void add(InvoiceInfoRequest invoiceInfoRequest);
    List<InvoiceInfoResponse> showByUserId(Long userId);
    InvoiceInfoResponse showByUserIdAndInvoiceId(Long userId, Long invoiceId);
}
