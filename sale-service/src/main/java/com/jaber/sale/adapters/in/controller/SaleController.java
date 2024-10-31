package com.jaber.sale.adapters.in.controller;

import com.jaber.sale.adapters.in.controller.mapper.SaleRequestMapper;
import com.jaber.sale.adapters.in.controller.request.SaleRequest;
import com.jaber.sale.application.core.domain.Sale;
import com.jaber.sale.application.ports.in.CreateSaleInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sales")
public class SaleController {

    private final CreateSaleInputPort createSaleInputPort;
    private final SaleRequestMapper saleRequestMapper;

    @PostMapping
    public ResponseEntity<Void> createSale(@Valid @RequestBody SaleRequest saleRequest) {
        Sale sale = saleRequestMapper.toSale(saleRequest);
        createSaleInputPort.create(sale);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
