package com.jaber.sale.adapters.in.consumer;

import com.jaber.sale.adapters.out.message.SaleMessage;
import com.jaber.sale.application.core.domain.enums.SaleEvent;
import com.jaber.sale.application.ports.in.FinalizeSaleInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToFinalizeConsumer {

    private final FinalizeSaleInputPort finalizeSaleInputPort;


    @KafkaListener(
            topics = "${jaber.kafka.topics.sale}",
            groupId = "${jaber.kafka.group-id.sale-finalize}"
    )
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.VALIDATED_PAYMENT.equals(saleMessage.getEvent())) {
            log.info("Beginning of sale finalization");
            finalizeSaleInputPort.finalize(saleMessage.getSale());
            log.info("End of sale finalization");
        }
    }

}
