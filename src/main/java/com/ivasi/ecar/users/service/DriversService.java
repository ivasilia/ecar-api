package com.ivasi.ecar.users.service;

import com.ivasi.ecar.users.models.Driver;

import java.util.Collection;
import java.util.Optional;

public interface DriversService {
    Driver getById(String id);
    Driver getByName(String name);

    void initializeDrivers();

    Collection<Driver> getAll();
}
