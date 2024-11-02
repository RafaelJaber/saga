package com.rafaeljaber.orchestrator.adapters.out;

import com.rafaeljaber.orchestrator.adapters.out.message.SaleMessage;
import com.rafaeljaber.orchestrator.application.core.domain.Sale;
import com.rafaeljaber.orchestrator.application.core.domain.enums.SaleEvent;
import com.rafaeljaber.orchestrator.application.core.domain.enums.Topics;
import com.rafaeljaber.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendSaleToTopicAdapter implements SendSaleToTopicOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;


    @Override
    public void send(Sale sale, SaleEvent saleEvent, Topics topic) {
        SaleMessage saleMessage = new SaleMessage(sale, saleEvent);
        kafkaTemplate.send(topic.getTopic(), saleMessage);
    }

}
