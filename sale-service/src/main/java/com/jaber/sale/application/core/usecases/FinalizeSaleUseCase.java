package com.jaber.sale.application.core.usecases;

import com.jaber.sale.application.core.domain.Sale;
import com.jaber.sale.application.core.domain.enums.SaleStatus;
import com.jaber.sale.application.ports.in.FinalizeSaleInputPort;
import com.jaber.sale.application.ports.in.FindSaleByIdInputPort;
import com.jaber.sale.application.ports.out.SaveSaleOutputPort;

public class FinalizeSaleUseCase implements FinalizeSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;
    private final SaveSaleOutputPort saveSaleOutputPort;

    public FinalizeSaleUseCase(
            FindSaleByIdInputPort findSaleByIdInputPort,
            SaveSaleOutputPort saveSaleOutputPort
    ) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutputPort = saveSaleOutputPort;
    }


    @Override
    public void finalize(Sale sale) {
        Sale saleToFinalize = findSaleByIdInputPort.find(sale.getId());
        saleToFinalize.setStatus(SaleStatus.FINALIZED);
        saveSaleOutputPort.save(saleToFinalize);
    }

}
