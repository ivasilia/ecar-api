package com.ivasi.ecar.users.service;

import com.ivasi.ecar.users.models.UserEntity;

public interface UserService {
    void initializeUsers();

    UserEntity getUserByUsername(String username);

    UserEntity registerUser(String name, String password);

//    String login(UserLoginDto loginDto);
}
