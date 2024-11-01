package com.rafaeljaber.payment.application.core.usecases;

import com.rafaeljaber.payment.application.core.domain.Payment;
import com.rafaeljaber.payment.application.core.domain.Sale;
import com.rafaeljaber.payment.application.core.domain.User;
import com.rafaeljaber.payment.application.core.domain.enums.SaleEvent;
import com.rafaeljaber.payment.application.core.usecases.exceptions.InsufficientFundsException;
import com.rafaeljaber.payment.application.ports.in.FindUserByIdInputPort;
import com.rafaeljaber.payment.application.ports.out.SavePaymentOutputPort;
import com.rafaeljaber.payment.application.ports.out.SendValidatedPaymentOutputPort;
import com.rafaeljaber.payment.application.ports.out.UpdateUserOutputPort;

public class SalePaymentUseCase {

    private final FindUserByIdInputPort findUserByIdInputPort;
    private final UpdateUserOutputPort updateUserOutputPort;
    private final SavePaymentOutputPort savePaymentOutputPort;
    private final SendValidatedPaymentOutputPort sendValidatedPaymentOutputPort;

    public SalePaymentUseCase(
            FindUserByIdInputPort findUserByIdInputPort,
            UpdateUserOutputPort updateUserOutputPort,
            SavePaymentOutputPort savePaymentOutputPort,
            SendValidatedPaymentOutputPort sendValidatedPaymentOutputPort
    ) {
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.updateUserOutputPort = updateUserOutputPort;
        this.savePaymentOutputPort = savePaymentOutputPort;
        this.sendValidatedPaymentOutputPort = sendValidatedPaymentOutputPort;
    }


    public void payment(Sale sale) {
        User user = findUserByIdInputPort.find(sale.getUserId());
        if (user.getBalance().compareTo(sale.getValue()) < 0) {
            throw new InsufficientFundsException(user.getBalance(), sale.getValue());
        }
        user.debitBalance(sale.getValue());
        this.updateUserOutputPort.update(user);
        savePaymentOutputPort.save(
                this.buildPayment(sale)
        );
        this.sendValidatedPaymentOutputPort.send(sale, SaleEvent.VALIDATED_PAYMENT);
    }


    private Payment buildPayment(Sale sale) {
        return new Payment(
                null,
                sale.getUserId(),
                sale.getId(),
                sale.getValue()
        );
    }

}