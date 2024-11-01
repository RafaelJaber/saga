package com.rafaeljaber.payment.config.usecases;

import com.rafaeljaber.payment.adapters.out.FindUserByIdAdapter;
import com.rafaeljaber.payment.application.core.usecases.FindUserByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindUserByIdConfig {

    @Bean
    public FindUserByIdUseCase findUserByIdUseCase(
            FindUserByIdAdapter findUserByIdAdapter
    ) {
        return new FindUserByIdUseCase(
                findUserByIdAdapter
        );
    }

}
