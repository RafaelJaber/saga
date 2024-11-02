package com.rafaeljaber.orchestrator.adapters.in.consumer;

import com.rafaeljaber.orchestrator.adapters.out.message.SaleMessage;
import com.rafaeljaber.orchestrator.application.ports.in.WorkflowInputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ReceiveSaleToProcessConsumer {

    private final List<WorkflowInputPort> workflows;


    @KafkaListener(
            topics = "${jaber.kafka.topics.orchestrator}",
            groupId = "${jaber.kafka.group-id.orchestrator}"
    )
    public void receive(SaleMessage saleMessage) {
        WorkflowInputPort workflow = workflows.stream()
                .filter(w -> w.isCalledByTheEvent(saleMessage.getEvent()))
                .findFirst()
                .orElse(null);

        if (workflow != null) {
            workflow.execute(saleMessage.getSale());
        } else {
            log.error("Invalid event");
        }
    }

}
