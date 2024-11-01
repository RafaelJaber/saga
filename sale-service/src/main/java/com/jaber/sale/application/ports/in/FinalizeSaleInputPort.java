package com.jaber.sale.application.ports.in;

import com.jaber.sale.application.core.domain.Sale;

public interface FinalizeSaleInputPort {

    void finalize(Sale sale);

}
