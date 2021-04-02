package com.ivasi.ecar.users.service.impl;

import com.ivasi.ecar.users.models.Driver;
import com.ivasi.ecar.users.repo.DriversRepo;
import com.ivasi.ecar.users.service.DriversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class DriversServiceImpl implements DriversService {
    private final DriversRepo driversRepo;

    @Autowired
    public DriversServiceImpl(DriversRepo driversRepo) {
        this.driversRepo = driversRepo;
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
}
