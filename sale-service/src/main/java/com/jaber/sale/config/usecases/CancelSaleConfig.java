package com.jaber.sale.config.usecases;

import com.jaber.sale.adapters.out.SaveSaleAdapter;
import com.jaber.sale.application.core.usecases.CancelSaleUseCase;
import com.jaber.sale.application.core.usecases.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CancelSaleConfig {

    @Bean
    public CancelSaleUseCase cancelSaleUseCase(
            FindSaleByIdUseCase findSaleByIdUseCase,
            SaveSaleAdapter saveSaleAdapter
    ) {
        return new CancelSaleUseCase(
                findSaleByIdUseCase,
                saveSaleAdapter
        );
    }

}
