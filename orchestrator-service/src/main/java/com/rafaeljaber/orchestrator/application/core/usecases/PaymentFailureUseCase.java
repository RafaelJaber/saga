package com.rafaeljaber.orchestrator.application.core.usecases;

import com.rafaeljaber.orchestrator.application.core.domain.Sale;
import com.rafaeljaber.orchestrator.application.core.domain.enums.SaleEvent;
import com.rafaeljaber.orchestrator.application.core.domain.enums.Topics;
import com.rafaeljaber.orchestrator.application.ports.in.WorkflowInputPort;
import com.rafaeljaber.orchestrator.application.ports.out.SendSaleToTopicOutputPort;

public class PaymentFailureUseCase implements WorkflowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public PaymentFailureUseCase(
            SendSaleToTopicOutputPort sendSaleToTopicOutputPort
    ) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }

    @Override
    public void execute(Sale sale) {
        sendSaleToTopicOutputPort.send(sale, SaleEvent.EXECUTE_ROLLBACK, Topics.INVENTORY.getTopic());
        sendSaleToTopicOutputPort.send(sale, SaleEvent.CANCEL_SALE, Topics.SALE.getTopic());
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return SaleEvent.PAYMENT_FAILED.equals(saleEvent);
    }
}
