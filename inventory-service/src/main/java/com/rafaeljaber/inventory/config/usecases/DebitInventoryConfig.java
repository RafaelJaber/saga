package com.rafaeljaber.inventory.config.usecases;

import com.rafaeljaber.inventory.adapters.out.SendToKafkaAdapter;
import com.rafaeljaber.inventory.adapters.out.UpdateInventoryAdapter;
import com.rafaeljaber.inventory.application.core.usecases.DebitInventoryUseCase;
import com.rafaeljaber.inventory.application.core.usecases.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebitInventoryConfig {

    @Bean
    public DebitInventoryUseCase debitInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter,
            SendToKafkaAdapter sendToKafkaAdapter
    ) {
        return new DebitInventoryUseCase(
                findInventoryByProductIdUseCase,
                updateInventoryAdapter,
                sendToKafkaAdapter
        );
    }

}
