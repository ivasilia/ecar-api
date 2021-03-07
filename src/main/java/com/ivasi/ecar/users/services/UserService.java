package com.ivasi.ecar.users.services;

import com.ivasi.ecar.users.models.UserEntity;

import java.util.List;

public interface UserService {
    void initializeUsers();

    UserEntity getUserByUsername(String username);

//    String login(UserLoginDto loginDto);
}
