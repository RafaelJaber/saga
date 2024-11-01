package com.jaber.sale.application.ports.out;

import com.jaber.sale.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {

    Optional<Sale> find(Integer id);

}
