package com.rafaeljaber.payment.adapters.out.repository;

import com.rafaeljaber.payment.adapters.out.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
