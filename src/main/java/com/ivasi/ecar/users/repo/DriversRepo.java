package com.ivasi.ecar.users.repo;

import com.ivasi.ecar.users.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriversRepo extends JpaRepository<Driver, String> {
    Optional<Driver> findByName(String name);
}
