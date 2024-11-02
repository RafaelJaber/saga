package com.rafaeljaber.orchestrator.config.usecase;

import com.rafaeljaber.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.rafaeljaber.orchestrator.application.core.usecases.InventoryPreparedUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryPreparedConfig {

    @Bean
    public InventoryPreparedUseCase inventoryPreparedUseCase(
            SendSaleToTopicAdapter sendSaleToTopicAdapter
    ) {
        return new InventoryPreparedUseCase(sendSaleToTopicAdapter);
    }

}
