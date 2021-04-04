package com.ivasi.ecar.users.service.impl;

import com.ivasi.ecar.users.models.Passenger;
import com.ivasi.ecar.users.repo.PassengersRepo;
import com.ivasi.ecar.users.service.PassengersService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class PassengersServiceImpl implements PassengersService {
    private final PassengersRepo passengersRepo;

    @Autowired
    public PassengersServiceImpl(PassengersRepo passengersRepo) {
        this.passengersRepo = passengersRepo;
    }

    @Override
    public Passenger getById(String id) {
        return this.passengersRepo.findById(id).orElse(null);
    }

    @Override
    public Collection<Passenger> getAll() {
        return this.passengersRepo.findAll();
    }
}
