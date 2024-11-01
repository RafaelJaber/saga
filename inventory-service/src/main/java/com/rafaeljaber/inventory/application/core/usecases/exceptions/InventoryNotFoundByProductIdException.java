package com.rafaeljaber.inventory.application.core.usecases.exceptions;

public class InventoryNotFoundByProductIdException extends RuntimeException {
    public InventoryNotFoundByProductIdException(Integer productId) {
        super(
                String.format("Inventory not found for product with ID: '%d'", productId)
        );
    }

    public InventoryNotFoundByProductIdException(String productId, Throwable cause) {
        super(
                String.format("Inventory not found for product with ID: '%s'", productId),
                cause
        );
    }
}