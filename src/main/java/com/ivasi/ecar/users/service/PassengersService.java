package com.ivasi.ecar.users.service;

import com.ivasi.ecar.users.models.Passenger;

import java.util.Collection;

public interface PassengersService {
    Passenger getById(String id);
    Collection<Passenger> getAll();
}
