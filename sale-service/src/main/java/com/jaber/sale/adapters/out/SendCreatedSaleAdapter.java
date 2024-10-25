package com.jaber.sale.adapters.out;

import com.jaber.sale.adapters.out.message.SaleMessage;
import com.jaber.sale.application.core.domain.Sale;
import com.jaber.sale.application.core.domain.enums.SaleEvent;
import com.jaber.sale.application.ports.out.SendCreatedSaleOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendCreatedSaleAdapter implements SendCreatedSaleOutputPort {

    private final KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Value("${jaber.kafka.topics.sale}")
    private String saleTopic;

    @Override
    public void send(Sale sale, SaleEvent event) {
        SaleMessage saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send(saleTopic, saleMessage);
    }

}
