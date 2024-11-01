package com.rafaeljaber.payment.application.ports.out;

import com.rafaeljaber.payment.application.core.domain.Sale;
import com.rafaeljaber.payment.application.core.domain.enums.SaleEvent;

public interface SendValidatedPaymentOutputPort {

    void send(Sale sale, SaleEvent event);

}
