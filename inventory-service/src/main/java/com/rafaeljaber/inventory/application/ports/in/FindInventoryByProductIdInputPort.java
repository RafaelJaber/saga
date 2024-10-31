package com.rafaeljaber.inventory.application.ports.in;

import com.rafaeljaber.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {

    Inventory find(Integer productId);

}
