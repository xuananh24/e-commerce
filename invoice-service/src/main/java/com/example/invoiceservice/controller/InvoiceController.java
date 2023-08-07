package com.example.invoiceservice.controller;

import com.example.invoiceservice.common.constant.PathConstant;
import com.example.invoiceservice.model.request.InvoiceInfoRequest;
import com.example.invoiceservice.model.response.InvoiceInfoResponse;
import com.example.invoiceservice.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping(value = PathConstant.API_INVOICE_ADD_URL)
    public void createInvoice(@RequestBody InvoiceInfoRequest invoiceInfoRequest) {
        invoiceService.add(invoiceInfoRequest);
    }

    @GetMapping(value = PathConstant.API_INVOICE_SHOW_ALL_BY_USER_URL)
    public List<InvoiceInfoResponse> showInvoiceByUserId(@PathVariable Long userId) {
        return invoiceService.showByUserId(userId);
    }

    @GetMapping(value = PathConstant.API_INVOICE_SHOW_BY_USER_AND_ID_URL)
    public InvoiceInfoResponse showInvoiceByUserIdAndInvoiceId(@PathVariable Long userId,@PathVariable Long invoiceId) {
        return invoiceService.showByUserIdAndInvoiceId(userId, invoiceId);
    }
}
