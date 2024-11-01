package com.rafaeljaber.payment.adapters.out;

import com.rafaeljaber.payment.adapters.out.repository.PaymentRepository;
import com.rafaeljaber.payment.adapters.out.repository.entity.PaymentEntity;
import com.rafaeljaber.payment.adapters.out.repository.mapper.PaymentEntityMapper;
import com.rafaeljaber.payment.application.core.domain.Payment;
import com.rafaeljaber.payment.application.ports.out.SavePaymentOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SavePaymentAdapter implements SavePaymentOutputPort {

    private final PaymentRepository paymentRepository;
    private final PaymentEntityMapper paymentEntityMapper;


    @Override
    public void save(Payment payment) {
        PaymentEntity paymentEntity = paymentEntityMapper.toPaymentEntity(payment);
        paymentRepository.save(paymentEntity);
    }

}
