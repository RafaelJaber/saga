package com.jaber.sale.config.usecases;

import com.jaber.sale.adapters.out.SaveSaleAdapter;
import com.jaber.sale.adapters.out.SendCreatedSaleAdapter;
import com.jaber.sale.application.core.usecases.CreateSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateSaleConfig {

    @Bean
    public CreateSaleUseCase createSaleUseCase(
            SaveSaleAdapter saveSaleAdapter,
            SendCreatedSaleAdapter sendCreatedSaleAdapter
    ) {
        return new CreateSaleUseCase(saveSaleAdapter, sendCreatedSaleAdapter);
    }

}
