package com.rafaeljaber.inventory.application.core.usecases.exceptions;


public class InsufficientStockException extends RuntimeException {

    public InsufficientStockException(
            Integer productId,
            Integer currentQuantity,
            Integer requiredQuantity
    ) {
        super(
                String.format(
                        "Insufficient stock for product with ID: '%s'. Current stock: %d, required quantity: %d",
                        productId,
                        currentQuantity,
                        requiredQuantity)
        );
    }

    public InsufficientStockException(
            Integer productId,
            Integer currentQuantity,
            Integer requiredQuantity,
            Throwable cause
    ) {
        super(
                String.format(
                        "Insufficient stock for product with ID: '%s'. Current stock: %d, required quantity: %d",
                        productId,
                        currentQuantity,
                        requiredQuantity),
                cause
        );
    }
}