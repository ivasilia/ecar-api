package com.ivasi.ecar.users.service.impl;

import com.ivasi.ecar.users.models.Driver;
import com.ivasi.ecar.users.models.UserEntity;
import com.ivasi.ecar.users.repo.DriversRepo;
import com.ivasi.ecar.users.service.DriversService;
import com.ivasi.ecar.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DriversServiceImpl implements DriversService {
    private final DriversRepo driversRepo;
    private final UserService userService;

    @Autowired
    public DriversServiceImpl(DriversRepo driversRepo, UserService userService) {
        this.driversRepo = driversRepo;
        this.userService = userService;
    }

    @Override
    public Driver getById(String id) {
        return this.driversRepo.findById(id).orElse(null);
    }

    @Override
    public Driver getByName(String name) {
        return this.driversRepo.findByName(name).orElse(null);
    }

    @Override
    public void initializeDrivers() {
        if (this.driversRepo.count() == 0) {
            this.register("Olivia", "olivia", "Aston Martin", "petrol", 9.5);
            this.register("Dragan", "dragan", "Trabant", "petrol", 12);
            this.register("Mohammed", "mohammed", "Benz", "diesel", 6.2);
            this.register("Alicia", "alicia", "Scania", "hydrogene", 2.7);
        }
    }

    @Override
    public Collection<Driver> getAll() {
        return this.driversRepo.findAll();
    }

    @Override
    public String register(
            String username,
            String password,
            String model,
            String fuel,
            double consumption) {
        UserEntity user = this.userService.registerUser(username, password);
        Driver driver = new Driver(username, model, fuel, consumption);
        this.userService.save(user);
        driver.setUser(user);
        this.driversRepo.save(driver);
        return driver.getId();
    }

    @Override
    public Driver getByUserId(String userId) {
        UserEntity user = this.userService.getById(userId);
        return this.driversRepo.findById(user.getDriver().getId()).orElse(null);
    }
}
