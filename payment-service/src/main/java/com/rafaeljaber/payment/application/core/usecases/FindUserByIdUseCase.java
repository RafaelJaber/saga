package com.rafaeljaber.payment.application.core.usecases;

import com.rafaeljaber.payment.application.core.domain.User;
import com.rafaeljaber.payment.application.core.usecases.exceptions.UserNotFoundException;
import com.rafaeljaber.payment.application.ports.in.FindUserByIdInputPort;
import com.rafaeljaber.payment.application.ports.out.FindUserByIdOutputPort;

public class FindUserByIdUseCase implements FindUserByIdInputPort {

    private final FindUserByIdOutputPort findUserByIdOutputPort;

    public FindUserByIdUseCase(FindUserByIdOutputPort findUserByIdOutputPort) {
        this.findUserByIdOutputPort = findUserByIdOutputPort;
    }

    @Override
    public User find(final Integer id) {
        return findUserByIdOutputPort.find(id).orElseThrow(
                UserNotFoundException::new
        );
    }

}
