package com.jaber.sale.application.ports.out;

import com.jaber.sale.application.core.domain.Sale;

public interface SaveSaleOutputPort {

    Sale save(Sale sale);

}
