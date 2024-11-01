package com.rafaeljaber.inventory.config.usecases;

import com.rafaeljaber.inventory.adapters.out.FindInventoryByProductIdAdapter;
import com.rafaeljaber.inventory.application.core.usecases.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindInventoryByProductIdConfig {

    @Bean
    public FindInventoryByProductIdUseCase findInventoryByProductIdUseCase(
            FindInventoryByProductIdAdapter findInventoryByProductIdAdapter
    ) {
        return new FindInventoryByProductIdUseCase(
                findInventoryByProductIdAdapter
        );
    }

}
