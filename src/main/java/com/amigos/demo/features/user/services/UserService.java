package com.amigos.demo.features.user.services;

import com.amigos.demo.features.user.data.dtos.User;

public interface UserService {

    void register(User user);
    User getUser(String id);
    void updateUser(String id, User user);
    void deleteUser(String id);
}
