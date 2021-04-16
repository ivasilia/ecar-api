package com.ivasi.ecar.users.service;

import com.ivasi.ecar.users.models.Passenger;

import java.util.Collection;

public interface PassengersService {
    Passenger getByUserId(String id);
    Collection<Passenger> getAll();

    String register(String username, String password, String imageUrl);
}
