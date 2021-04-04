package com.ivasi.ecar.users.repo;

import com.ivasi.ecar.users.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengersRepo extends JpaRepository<Passenger, String> {
}
