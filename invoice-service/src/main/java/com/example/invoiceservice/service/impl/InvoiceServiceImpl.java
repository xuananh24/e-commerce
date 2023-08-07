package com.example.invoiceservice.service.impl;

import com.example.invoiceservice.model.entity.Invoice;
import com.example.invoiceservice.model.entity.Item;
import com.example.invoiceservice.model.mapper.InvoiceMapper;
import com.example.invoiceservice.model.mapper.ItemMapper;
import com.example.invoiceservice.model.request.InvoiceInfoRequest;
import com.example.invoiceservice.model.response.InvoiceInfoResponse;
import com.example.invoiceservice.repository.InvoiceRepository;
import com.example.invoiceservice.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public void add(InvoiceInfoRequest invoiceInfoRequest) {
        Invoice invoice = InvoiceMapper.toEntity(invoiceInfoRequest);
        List<Item> items = invoiceInfoRequest.getItems().stream().map(o -> {
                    Item item = ItemMapper.toEntity(o);
                    item.setInvoice(invoice);
                    return item;
                })
                .toList();
        items.forEach(o -> o.setInvoice(invoice));
        invoice.setItems(items);
        invoiceRepository.save(invoice);
    }

    @Override
    public List<InvoiceInfoResponse> showByUserId(Long userId) {
        return invoiceRepository.findInvoiceByUserId(userId).stream().map(InvoiceMapper::toDto).toList();
    }

    @Override
    public InvoiceInfoResponse showByUserIdAndInvoiceId(Long userId, Long invoiceId) {
        return Optional.ofNullable(invoiceRepository.findInvoiceByUserIdAndId(userId, invoiceId)).map(InvoiceMapper::toDto).orElse(null);
    }
}
