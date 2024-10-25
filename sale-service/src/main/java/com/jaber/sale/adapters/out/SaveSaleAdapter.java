package com.jaber.sale.adapters.out;

import com.jaber.sale.adapters.out.repository.SaleRepository;
import com.jaber.sale.adapters.out.repository.entity.SaleEntity;
import com.jaber.sale.adapters.out.repository.mapper.SaleEntityMapper;
import com.jaber.sale.application.core.domain.Sale;
import com.jaber.sale.application.ports.out.SaveSaleOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveSaleAdapter implements SaveSaleOutputPort {

    private final SaleRepository saleRepository;
    private final SaleEntityMapper saleEntityMapper;

    @Override
    public Sale save(Sale sale) {
        SaleEntity saleEntity = saleEntityMapper.toSaleEntity(sale);
        SaleEntity saleEntityResponse = saleRepository.save(saleEntity);
        return saleEntityMapper.toSale(saleEntityResponse);
    }

}
