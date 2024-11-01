package com.rafaeljaber.payment.adapters.in.consumer;

import com.rafaeljaber.payment.adapters.out.message.SaleMessage;
import com.rafaeljaber.payment.application.core.domain.enums.SaleEvent;
import com.rafaeljaber.payment.application.ports.in.SalePaymentInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToPaymentConsumer {

    private final SalePaymentInputPort salePaymentInputPort;

    @KafkaListener(
            topics = "${jaber.kafka.topics.sale}",
            groupId = "${jaber.kafka.group-id.payment}"
    )
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.UPDATED_INVENTORY.equals(saleMessage.getEvent())) {
            log.info("Beginning of payment");
            salePaymentInputPort.payment(saleMessage.getSale());
            log.info("End of payment");
        }
    }

}
