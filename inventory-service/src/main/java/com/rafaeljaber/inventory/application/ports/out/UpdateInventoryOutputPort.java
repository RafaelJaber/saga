package com.rafaeljaber.inventory.application.ports.out;

import com.rafaeljaber.inventory.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {

    void update(Inventory inventory);

}
