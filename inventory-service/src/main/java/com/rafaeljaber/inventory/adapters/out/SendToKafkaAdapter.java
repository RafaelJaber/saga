package com.rafaeljaber.inventory.adapters.out;

import com.rafaeljaber.inventory.adapters.out.message.SaleMessage;
import com.rafaeljaber.inventory.application.core.domain.Sale;
import com.rafaeljaber.inventory.application.core.domain.enums.SaleEvent;
import com.rafaeljaber.inventory.application.ports.out.SendToKafkaOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendToKafkaAdapter implements SendToKafkaOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Value("${jaber.kafka.topics.sale}")
    private String saleTopic;

    @Override
    public void send(Sale sale, SaleEvent event) {
        SaleMessage saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send(saleTopic, saleMessage);
    }

}
