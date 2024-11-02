package com.rafaeljaber.orchestrator.config.usecase;

import com.rafaeljaber.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.rafaeljaber.orchestrator.application.core.usecases.PaymentFailureUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentFailureConfig {

    @Bean
    public PaymentFailureUseCase paymentFailureUseCase(
            SendSaleToTopicAdapter sendSaleToTopicAdapter
    ) {
        return new PaymentFailureUseCase(sendSaleToTopicAdapter);
    }

}
