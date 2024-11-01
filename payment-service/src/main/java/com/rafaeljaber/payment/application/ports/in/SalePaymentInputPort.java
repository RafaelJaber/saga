package com.rafaeljaber.payment.application.ports.in;

import com.rafaeljaber.payment.application.core.domain.Sale;

public interface SalePaymentInputPort {

    void payment(Sale sale);

}
