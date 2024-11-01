package com.jaber.sale.config.usecases;

import com.jaber.sale.adapters.out.SaveSaleAdapter;
import com.jaber.sale.application.core.usecases.FinalizeSaleUseCase;
import com.jaber.sale.application.core.usecases.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinalizeSaleConfig {

    @Bean
    public FinalizeSaleUseCase finalizeSaleUseCase(
            FindSaleByIdUseCase findSaleByIdUseCase,
            SaveSaleAdapter saveSaleAdapter
    ) {
        return new FinalizeSaleUseCase(
                findSaleByIdUseCase,
                saveSaleAdapter
        );
    }

}
