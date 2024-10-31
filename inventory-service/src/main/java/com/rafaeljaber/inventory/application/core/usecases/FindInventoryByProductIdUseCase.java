package com.rafaeljaber.inventory.application.core.usecases;

import com.rafaeljaber.inventory.application.core.domain.Inventory;
import com.rafaeljaber.inventory.application.core.domain.exceptions.InventoryNotFoundByProductIdException;
import com.rafaeljaber.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.rafaeljaber.inventory.application.ports.out.FindInventoryByProductIdOutputPort;

public class FindInventoryByProductIdUseCase implements FindInventoryByProductIdInputPort {

    private final FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort;

    public FindInventoryByProductIdUseCase(FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort) {
        this.findInventoryByProductIdOutputPort = findInventoryByProductIdOutputPort;
    }

    @Override
    public Inventory find(Integer productId) {
        return findInventoryByProductIdOutputPort.find(productId).orElseThrow(
                () -> new InventoryNotFoundByProductIdException(productId)
        );
    }

}
