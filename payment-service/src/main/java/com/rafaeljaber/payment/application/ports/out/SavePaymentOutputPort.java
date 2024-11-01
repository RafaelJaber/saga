package com.rafaeljaber.payment.application.ports.out;

import com.rafaeljaber.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {

    void save(Payment payment);

}
