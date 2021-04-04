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
            Driver driver1 = new Driver("Olivia", "Aston Martin", "petrol", 9.5);
            Driver driver2 = new Driver("Oswald", "Trabant", "petrol", 12);
            Driver driver3 = new Driver("Mohammed", "Benz", "diesel", 6.2);
            Driver driver4 = new Driver("Alicia", "Scania", "hydrogene", 2.7);

            this.driversRepo.saveAll(List.of(
                    driver1, driver2, driver3, driver4
            ));
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
        driver.setUser(user);
        return this.driversRepo.save(driver).getId();
    }
}
