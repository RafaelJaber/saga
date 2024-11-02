package com.rafaeljaber.inventory.application.core.usecases;

import com.rafaeljaber.inventory.application.core.domain.Inventory;
import com.rafaeljaber.inventory.application.core.domain.Sale;
import com.rafaeljaber.inventory.application.ports.in.CreditInventoryInputPort;
import com.rafaeljaber.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.rafaeljaber.inventory.application.ports.out.UpdateInventoryOutputPort;

public class CreditInventoryUseCase implements CreditInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;

    public CreditInventoryUseCase(
            FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
            UpdateInventoryOutputPort updateInventoryOutputPort
    ) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
    }

    @Override
    public void credit(Sale sale) {
        Inventory inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        inventory.creditQuantity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);
    }

}
