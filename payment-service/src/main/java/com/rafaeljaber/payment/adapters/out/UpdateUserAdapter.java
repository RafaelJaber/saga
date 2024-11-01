package com.rafaeljaber.payment.adapters.out;

import com.rafaeljaber.payment.adapters.out.repository.UserRepository;
import com.rafaeljaber.payment.adapters.out.repository.entity.UserEntity;
import com.rafaeljaber.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.rafaeljaber.payment.application.core.domain.User;
import com.rafaeljaber.payment.application.ports.out.UpdateUserOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUserAdapter implements UpdateUserOutputPort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;


    @Override
    public void update(User user) {
        UserEntity userEntity = userEntityMapper.toUserEntity(user);
        userRepository.save(userEntity);
    }

}
