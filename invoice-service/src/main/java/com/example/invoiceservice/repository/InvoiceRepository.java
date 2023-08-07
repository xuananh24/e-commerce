package com.example.invoiceservice.repository;

import com.example.invoiceservice.model.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findInvoiceByUserId(Long userId);
    Invoice findInvoiceByUserIdAndId(Long userId, Long id);
}
