package com.rafaeljaber.inventory.application.core.usecases;

import com.rafaeljaber.inventory.application.core.domain.Inventory;
import com.rafaeljaber.inventory.application.core.domain.Sale;
import com.rafaeljaber.inventory.application.core.domain.enums.SaleEvent;
import com.rafaeljaber.inventory.application.core.usecases.exceptions.InsufficientStockException;
import com.rafaeljaber.inventory.application.ports.in.DebitInventoryInputPort;
import com.rafaeljaber.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.rafaeljaber.inventory.application.ports.out.SendToKafkaOutputPort;
import com.rafaeljaber.inventory.application.ports.out.UpdateInventoryOutputPort;

public class DebitInventoryUseCase implements DebitInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutputPort updateInventoryOutputPort;
    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    public DebitInventoryUseCase(
            FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
            UpdateInventoryOutputPort updateInventoryOutputPort,
            SendToKafkaOutputPort sendToKafkaOutputPort
    ) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutputPort = updateInventoryOutputPort;
        this.sendToKafkaOutputPort = sendToKafkaOutputPort;
    }


    @Override
    public void debit(Sale sale) {
        try {
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
            sendToKafkaOutputPort.send(sale, SaleEvent.INVENTORY_PREPARED);
        } catch (Exception e) {
            sendToKafkaOutputPort.send(sale, SaleEvent.INVENTORY_ERROR);
        }

    }

}
