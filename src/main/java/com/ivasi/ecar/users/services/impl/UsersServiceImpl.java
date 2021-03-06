package com.ivasi.ecar.users.services.impl;

import com.ivasi.ecar.users.models.UserEntity;
import com.ivasi.ecar.users.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UserService {
    @Override
    public void initializeUsers() {

    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return null;
    }
}
