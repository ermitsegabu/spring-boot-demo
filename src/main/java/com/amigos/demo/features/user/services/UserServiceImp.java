package com.amigos.demo.features.user.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amigos.demo.features.user.data.dtos.User;
import com.amigos.demo.features.user.data.models.UserEntity;
import com.amigos.demo.features.user.data.repositories.UserJpaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserJpaRepository repository;

    @Override
    public void register(User user) {
       UserEntity userEntity = UserEntity.builder()
            .email(user.getEmail())
            .name(user.getName())
            .build();
        repository.save(userEntity);
    }

    @Override
    public User getUser(String id) {
        UserEntity userEntity = repository.findById(id).orElseThrow();
        return convertToDTO(userEntity);
    }

    @Override
    public void updateUser(String id, User user) {
        UserEntity userEntity = repository.findById(id).orElseThrow();
        userEntity.setName(user.getName());
        userEntity.setEmail(user.getEmail());
        repository.save(userEntity);
    }

    @Override
    public void deleteUser(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    private User convertToDTO(UserEntity userEntity) {
        User user = new User();
        user.setName(userEntity.getName());
        user.setEmail(userEntity.getEmail());
        return user;
    }
    
}
