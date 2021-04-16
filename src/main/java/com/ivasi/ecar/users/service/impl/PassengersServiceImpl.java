package com.ivasi.ecar.users.service.impl;

import com.ivasi.ecar.users.models.Driver;
import com.ivasi.ecar.users.models.Passenger;
import com.ivasi.ecar.users.models.UserEntity;
import com.ivasi.ecar.users.repo.PassengersRepo;
import com.ivasi.ecar.users.service.PassengersService;
import com.ivasi.ecar.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;

@Service
public class PassengersServiceImpl implements PassengersService {
    private final PassengersRepo passengersRepo;
    private final UserService userService;

    @Autowired
    public PassengersServiceImpl(PassengersRepo passengersRepo, UserService userService) {
        this.passengersRepo = passengersRepo;
        this.userService = userService;
    }

    @Override
    public Passenger getByUserId(String userId) {
        UserEntity user = this.userService.getById(userId);
        return this.passengersRepo.findById(user.getPassenger().getId()).orElse(null);
    }

    @Override
    public Collection<Passenger> getAll() {
        return this.passengersRepo.findAll();
    }

    @Override
    public String register(
            String username,
            String password,
            String imageUrl) {
        UserEntity user = this.userService.registerUser(username, password);
        Passenger passenger = new Passenger(username, imageUrl);
        this.userService.save(user);
        passenger.setUser(user);
        passenger.setRegistrationDate(LocalDateTime.now());
        this.passengersRepo.save(passenger);
        return passenger.getId();
    }
}
