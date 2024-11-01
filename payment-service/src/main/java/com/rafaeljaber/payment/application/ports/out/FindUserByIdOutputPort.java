package com.rafaeljaber.payment.application.ports.out;

import com.rafaeljaber.payment.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutputPort {

    Optional<User> find(Integer userId);

}
