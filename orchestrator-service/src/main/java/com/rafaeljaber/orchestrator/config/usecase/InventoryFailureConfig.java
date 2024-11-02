package com.rafaeljaber.orchestrator.config.usecase;

import com.rafaeljaber.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.rafaeljaber.orchestrator.application.core.usecases.InventoryFailureUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryFailureConfig {

    @Bean
    public InventoryFailureUseCase inventoryFailureUseCase(
            SendSaleToTopicAdapter sendSaleToTopicAdapter
    ) {
        return new InventoryFailureUseCase(sendSaleToTopicAdapter);
    }

}
