package com.rafaeljaber.orchestrator.config.usecase;

import com.rafaeljaber.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.rafaeljaber.orchestrator.application.core.usecases.CreatedSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatedSaleConfig {

    @Bean
    public CreatedSaleUseCase createdSaleUseCase(
            SendSaleToTopicAdapter sendSaleToTopicAdapter
    ) {
        return new CreatedSaleUseCase(sendSaleToTopicAdapter);
    }

}
