package com.jaber.sale.config.usecases;

import com.jaber.sale.adapters.out.FindSaleByIdAdapter;
import com.jaber.sale.application.core.usecases.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSaleByIdConfig {

    @Bean
    public FindSaleByIdUseCase findSaleByIdUseCase(
            FindSaleByIdAdapter findSaleByIdAdapter
    ) {
        return new FindSaleByIdUseCase(
                findSaleByIdAdapter
        );
    }

}
