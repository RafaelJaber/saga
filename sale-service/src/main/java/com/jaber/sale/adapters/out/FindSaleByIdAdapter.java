package com.jaber.sale.adapters.out;

import com.jaber.sale.adapters.out.repository.SaleRepository;
import com.jaber.sale.adapters.out.repository.entity.SaleEntity;
import com.jaber.sale.adapters.out.repository.mapper.SaleEntityMapper;
import com.jaber.sale.application.core.domain.Sale;
import com.jaber.sale.application.ports.out.FindSaleByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindSaleByIdAdapter implements FindSaleByIdOutputPort {

    private final SaleRepository saleRepository;
    private final SaleEntityMapper saleEntityMapper;

    @Override
    public Optional<Sale> find(Integer id) {
        Optional<SaleEntity> saleEntity = saleRepository.findById(id);
        return saleEntity.map(saleEntityMapper::toSale);
    }

}
