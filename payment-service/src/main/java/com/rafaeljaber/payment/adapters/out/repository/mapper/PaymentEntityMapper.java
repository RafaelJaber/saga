package com.rafaeljaber.payment.adapters.out.repository.mapper;

import com.rafaeljaber.payment.adapters.out.repository.entity.PaymentEntity;
import com.rafaeljaber.payment.application.core.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {

    Payment toPayment(PaymentEntity paymentEntity);

    PaymentEntity toPaymentEntity(Payment payment);

}
