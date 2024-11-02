package com.rafaeljaber.orchestrator.config.usecase;

import com.rafaeljaber.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.rafaeljaber.orchestrator.application.core.usecases.PaymentExecutedUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentExecutedConfig {

    @Bean
    public PaymentExecutedUseCase paymentExecutedUseCase(
            SendSaleToTopicAdapter sendSaleToTopicAdapter
    ) {
        return new PaymentExecutedUseCase(sendSaleToTopicAdapter);
    }

}
