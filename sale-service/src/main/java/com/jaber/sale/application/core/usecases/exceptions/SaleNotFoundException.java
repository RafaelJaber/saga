package com.jaber.sale.application.core.usecases.exceptions;

public class SaleNotFoundException extends RuntimeException {
    public SaleNotFoundException() {
        super("Sale not found");
    }

    public SaleNotFoundException(Throwable cause) {
        super("Sale not found", cause);
    }
}
