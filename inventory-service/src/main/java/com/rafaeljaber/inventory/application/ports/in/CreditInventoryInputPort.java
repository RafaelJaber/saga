package com.rafaeljaber.inventory.application.ports.in;

import com.rafaeljaber.inventory.application.core.domain.Sale;

public interface CreditInventoryInputPort {

    void credit(Sale sale);

}
