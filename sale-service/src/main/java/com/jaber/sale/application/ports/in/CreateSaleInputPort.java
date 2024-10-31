package com.jaber.sale.application.ports.in;


import com.jaber.sale.application.core.domain.Sale;

public interface CreateSaleInputPort {

    void create(Sale sale);

}
