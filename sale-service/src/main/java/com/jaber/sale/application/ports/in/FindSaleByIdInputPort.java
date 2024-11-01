package com.jaber.sale.application.ports.in;

import com.jaber.sale.application.core.domain.Sale;

public interface FindSaleByIdInputPort {

    Sale find(final Integer id);

}
