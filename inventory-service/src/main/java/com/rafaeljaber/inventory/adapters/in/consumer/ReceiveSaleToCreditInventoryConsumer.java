package com.rafaeljaber.inventory.adapters.in.consumer;

import com.rafaeljaber.inventory.adapters.out.message.SaleMessage;
import com.rafaeljaber.inventory.application.core.domain.enums.SaleEvent;
import com.rafaeljaber.inventory.application.ports.in.CreditInventoryInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToCreditInventoryConsumer {

    private final CreditInventoryInputPort creditInventoryInputPort;

    @KafkaListener(
            topics = "${jaber.kafka.topics.inventory}",
            groupId = "${jaber.kafka.group-id.inventory-credit}"
    )
    public void receive(SaleMessage saleMessage) {
        if (SaleEvent.EXECUTE_ROLLBACK.equals(saleMessage.getEvent())) {
            log.info("Beginning of rollback inventory");
            creditInventoryInputPort.credit(saleMessage.getSale());
            log.info("End of rollback inventory");
        }
    }

}
