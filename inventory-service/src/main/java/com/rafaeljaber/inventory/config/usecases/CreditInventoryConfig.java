package com.rafaeljaber.inventory.config.usecases;

import com.rafaeljaber.inventory.adapters.out.SendToKafkaAdapter;
import com.rafaeljaber.inventory.adapters.out.UpdateInventoryAdapter;
import com.rafaeljaber.inventory.application.core.usecases.CreditInventoryUseCase;
import com.rafaeljaber.inventory.application.core.usecases.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditInventoryConfig {

    @Bean
    public CreditInventoryUseCase creditInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter,
            SendToKafkaAdapter sendToKafkaAdapter
    ) {
        return new CreditInventoryUseCase(
                findInventoryByProductIdUseCase,
                updateInventoryAdapter,
                sendToKafkaAdapter
        );
    }

}
