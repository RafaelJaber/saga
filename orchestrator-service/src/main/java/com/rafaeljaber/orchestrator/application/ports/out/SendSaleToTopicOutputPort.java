package com.rafaeljaber.orchestrator.application.ports.out;

import com.rafaeljaber.orchestrator.application.core.domain.Sale;
import com.rafaeljaber.orchestrator.application.core.domain.enums.SaleEvent;
import com.rafaeljaber.orchestrator.application.core.domain.enums.Topics;

public interface SendSaleToTopicOutputPort {

    void send(Sale sale, SaleEvent saleEvent, Topics topic);

}
