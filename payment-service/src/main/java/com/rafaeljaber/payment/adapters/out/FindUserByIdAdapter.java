package com.rafaeljaber.payment.adapters.out;

import com.rafaeljaber.payment.adapters.out.repository.UserRepository;
import com.rafaeljaber.payment.adapters.out.repository.entity.UserEntity;
import com.rafaeljaber.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.rafaeljaber.payment.application.core.domain.User;
import com.rafaeljaber.payment.application.ports.out.FindUserByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindUserByIdAdapter implements FindUserByIdOutputPort {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> find(Integer userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        return userEntity.map(userEntityMapper::toUser);
    }

}
