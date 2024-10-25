package com.jaber.sale.application.ports.out;

import com.jaber.sale.application.core.domain.Sale;
import com.jaber.sale.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutputPort {

    void send(Sale sale, SaleEvent event);

}
