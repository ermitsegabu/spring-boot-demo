package com.amigos.demo.features.user.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amigos.demo.features.user.data.models.UserEntity;

public interface UserJpaRepository extends JpaRepository<UserEntity, String> {
    // @Query()
    // public UserEntity findByEmail(String email);
}
