package com.rafaeljaber.payment.config.usecases;

import com.rafaeljaber.payment.adapters.out.SavePaymentAdapter;
import com.rafaeljaber.payment.adapters.out.SendValidatedPaymentAdapter;
import com.rafaeljaber.payment.adapters.out.UpdateUserAdapter;
import com.rafaeljaber.payment.application.core.usecases.FindUserByIdUseCase;
import com.rafaeljaber.payment.application.core.usecases.SalePaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {

    @Bean
    public SalePaymentUseCase salePaymentUseCase(
            FindUserByIdUseCase findUserByIdUseCase,
            UpdateUserAdapter updateUserAdapter,
            SavePaymentAdapter savePaymentAdapter,
            SendValidatedPaymentAdapter sendValidatedPaymentAdapter
    ){
        return new SalePaymentUseCase(
                findUserByIdUseCase,
                updateUserAdapter,
                savePaymentAdapter,
                sendValidatedPaymentAdapter
        );
    }

}