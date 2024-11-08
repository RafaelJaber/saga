package com.rafaeljaber.orchestrator.application.core.usecases;

import com.rafaeljaber.orchestrator.application.core.domain.Sale;
import com.rafaeljaber.orchestrator.application.core.domain.enums.SaleEvent;
import com.rafaeljaber.orchestrator.application.core.domain.enums.Topics;
import com.rafaeljaber.orchestrator.application.ports.in.WorkflowInputPort;
import com.rafaeljaber.orchestrator.application.ports.out.SendSaleToTopicOutputPort;

public class InventoryFailureUseCase implements WorkflowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public InventoryFailureUseCase(
            SendSaleToTopicOutputPort sendSaleToTopicOutputPort
    ) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }


    @Override
    public void execute(Sale sale) {
        sendSaleToTopicOutputPort.send(sale, SaleEvent.CANCEL_SALE, Topics.SALE);
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return SaleEvent.INVENTORY_ERROR.equals(saleEvent);
    }
}
