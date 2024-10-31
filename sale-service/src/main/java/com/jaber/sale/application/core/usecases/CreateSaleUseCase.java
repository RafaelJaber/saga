package com.jaber.sale.application.core.usecases;

import com.jaber.sale.application.core.domain.Sale;
import com.jaber.sale.application.core.domain.enums.SaleEvent;
import com.jaber.sale.application.core.domain.enums.SaleStatus;
import com.jaber.sale.application.ports.in.CreateSaleInputPort;
import com.jaber.sale.application.ports.out.SaveSaleOutputPort;
import com.jaber.sale.application.ports.out.SendCreatedSaleOutputPort;

public class CreateSaleUseCase implements CreateSaleInputPort {

    private final SaveSaleOutputPort saveSaleOutputPort;
    private final SendCreatedSaleOutputPort sendCreatedSaleOutputPort;

    public CreateSaleUseCase(
            SaveSaleOutputPort saveSaleOutputPort,
             SendCreatedSaleOutputPort sendCreatedSaleOutputPort
    ) {
        this.saveSaleOutputPort = saveSaleOutputPort;
        this.sendCreatedSaleOutputPort = sendCreatedSaleOutputPort;
    }

    @Override
    public void create(Sale sale) {
        sale.setStatus(SaleStatus.PENDING);
        Sale saleResponse = this.saveSaleOutputPort.save(sale);
        this.sendCreatedSaleOutputPort
                .send(
                        saleResponse,
                        SaleEvent.CREATED_SALE
                );
    }

}
