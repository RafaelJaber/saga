package com.rafaeljaber.orchestrator.application.ports.in;

import com.rafaeljaber.orchestrator.application.core.domain.Sale;
import com.rafaeljaber.orchestrator.application.core.domain.enums.SaleEvent;

public interface WorkflowInputPort {

    void execute(Sale sale);

    boolean isCalledByTheEvent(SaleEvent saleEvent);

}
