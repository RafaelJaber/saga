package com.jaber.sale.adapters.out.repository.mapper;

import com.jaber.sale.adapters.out.repository.entity.SaleEntity;
import com.jaber.sale.application.core.domain.Sale;
import com.jaber.sale.application.core.domain.enums.SaleStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SaleEntityMapper {


    @Mapping(
            source = "status",
            target = "statusId",
            qualifiedByName = "setStatusId"
    )
    SaleEntity toSaleEntity(Sale sale);

    @Mapping(source = "statusId", target = "status", qualifiedByName = "setStatus")
    Sale toSale(SaleEntity saleEntity);


    @Named("setStatusId")
    default Integer setStatusId(SaleStatus saleStatus) {
        return saleStatus.getStatusId();
    }

    @Named("setStatus")
    default SaleStatus toSaleStatus(Integer statusId) {
        return SaleStatus.toEnum(statusId);
    }
}
