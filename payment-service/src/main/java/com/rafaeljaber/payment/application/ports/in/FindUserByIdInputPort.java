package com.rafaeljaber.payment.application.ports.in;

import com.rafaeljaber.payment.application.core.domain.User;

public interface FindUserByIdInputPort {

    User find(final Integer id);

}
