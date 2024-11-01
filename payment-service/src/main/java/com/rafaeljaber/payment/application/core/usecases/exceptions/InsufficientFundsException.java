package com.rafaeljaber.payment.application.core.usecases.exceptions;

import java.math.BigDecimal;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(BigDecimal availableBalance, BigDecimal requiredAmount) {
        super(
                String.format(
                        "Insufficient funds to complete the purchase. Available balance: $%.2f, required amount: $%.2f",
                        availableBalance,
                        requiredAmount
                )
        );
    }

    public InsufficientFundsException(BigDecimal availableBalance, BigDecimal requiredAmount, Throwable cause) {
        super(
                String.format(
                        "Insufficient funds to complete the purchase. Available balance: $%.2f, required amount: $%.2f",
                        availableBalance,
                        requiredAmount
                ),
                cause
        );
    }
}
