package com.rafaeljaber.inventory.application.ports.out;

import com.rafaeljaber.inventory.application.core.domain.Sale;
import com.rafaeljaber.inventory.application.core.domain.enums.SaleEvent;

public interface SendUpdatedInventoryOutputPort {

    void send(Sale sale, SaleEvent event);

}
