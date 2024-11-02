package com.rafaeljaber.inventory.adapters.in.consumer;

import com.rafaeljaber.inventory.adapters.out.message.SaleMessage;
import com.rafaeljaber.inventory.application.core.domain.enums.SaleEvent;
import com.rafaeljaber.inventory.application.ports.in.DebitInventoryInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToDebitInventoryConsume {

    private final DebitInventoryInputPort debitInventoryInputPort;

    @KafkaListener(
            topics = "${jaber.kafka.topics.inventory}",
            groupId = "${jaber.kafka.group-id.inventory-debit}"
    )
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.PREPARE_INVENTORY.equals(saleMessage.getEvent())) {
            log.info("Beginning of goods separation");
            debitInventoryInputPort.debit(saleMessage.getSale());
            log.info("End of separation of goods");
        }
    }

}
