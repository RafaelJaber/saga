package com.jaber.sale.application.core.usecases;

import com.jaber.sale.application.core.domain.Sale;
import com.jaber.sale.application.core.domain.enums.SaleStatus;
import com.jaber.sale.application.ports.in.CancelSaleInputPort;
import com.jaber.sale.application.ports.in.FindSaleByIdInputPort;
import com.jaber.sale.application.ports.out.SaveSaleOutputPort;

public class CancelSaleUseCase implements CancelSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;
    private final SaveSaleOutputPort saveSaleOutputPort;

    public CancelSaleUseCase(
            FindSaleByIdInputPort findSaleByIdInputPort,
            SaveSaleOutputPort saveSaleOutputPort
    ) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }

    @Override
    public void cancel(Sale sale) {
        Sale saleToCancel = findSaleByIdInputPort.find(sale.getId());
        saleToCancel.setStatus(SaleStatus.CANCELED);
        saveSaleOutputPort.save(saleToCancel);
    }

}
