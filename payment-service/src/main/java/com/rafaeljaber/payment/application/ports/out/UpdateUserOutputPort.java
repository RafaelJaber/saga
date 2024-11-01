package com.rafaeljaber.payment.application.ports.out;

import com.rafaeljaber.payment.application.core.domain.User;

public interface UpdateUserOutputPort {

    void update(User user);

}
