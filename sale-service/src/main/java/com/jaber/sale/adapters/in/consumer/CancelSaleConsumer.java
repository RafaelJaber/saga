package com.jaber.sale.adapters.in.consumer;

import com.jaber.sale.adapters.out.message.SaleMessage;
import com.jaber.sale.application.core.domain.enums.SaleEvent;
import com.jaber.sale.application.ports.in.CancelSaleInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CancelSaleConsumer {

    private final CancelSaleInputPort cancelSaleInputPort;


    @KafkaListener(
            topics = "${jaber.kafka.topics.sale}",
            groupId = "${jaber.kafka.group-id.sale-cancel}"
    )
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.ROLLBACK_INVENTORY.equals(saleMessage.getEvent())) {
            log.info("Beginning of sale cancellation");
            cancelSaleInputPort.cancel(saleMessage.getSale());
            log.info("End of sale cancellation");
        }
    }

}
