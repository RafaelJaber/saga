package com.rafaeljaber.inventory.application.core.usecases;

import com.rafaeljaber.inventory.application.core.domain.Inventory;
import com.rafaeljaber.inventory.application.core.domain.Sale;
import com.rafaeljaber.inventory.application.core.domain.enums.SaleEvent;
import com.rafaeljaber.inventory.application.core.domain.exceptions.InsufficientStockException;
import com.rafaeljaber.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.rafaeljaber.inventory.application.ports.out.SendUpdatedInventoryOutputPort;
import com.rafaeljaber.inventory.application.ports.out.UpdateInventoryOutputPort;

public class DebitInventoryUseCase {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;
    private final SendUpdatedInventoryOutputPort sendUpdatedInventoryOutputPort;

    public DebitInventoryUseCase(
            FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
            UpdateInventoryOutputPort updateInventoryOutputPort,
            SendUpdatedInventoryOutputPort sendUpdatedInventoryOutputPort
    ) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendUpdatedInventoryOutputPort = sendUpdatedInventoryOutputPort;
    }


    public void debit(Sale sale) {
        Inventory inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        if (inventory.getQuantity() < sale.getQuantity()) {
            throw new InsufficientStockException(
                    sale.getProductId(),
                    inventory.getQuantity(),
                    sale.getQuantity()
            );
        }
        inventory.debitQuantity(sale.getQuantity());
        updateInventoryOutputPort.update(inventory);
        sendUpdatedInventoryOutputPort.send(sale, SaleEvent.UPDATED_INVENTORY);
    }

}
