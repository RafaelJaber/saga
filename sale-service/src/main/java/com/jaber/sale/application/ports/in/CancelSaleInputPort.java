package com.jaber.sale.application.ports.in;

import com.jaber.sale.application.core.domain.Sale;

public interface CancelSaleInputPort {

    void cancel(Sale sale);

}
